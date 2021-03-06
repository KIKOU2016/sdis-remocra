package fr.sdis83.remocra.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.impl.DefaultHttpRequestFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.Geometry;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import fr.sdis83.remocra.domain.remocra.ProfilDroit;
import fr.sdis83.remocra.domain.remocra.ZoneCompetence;
import fr.sdis83.remocra.domain.utils.RemocraDateHourTransformer;
import fr.sdis83.remocra.exception.BusinessException;
import fr.sdis83.remocra.json.JsonObjectResponse;
import fr.sdis83.remocra.service.AuthService;
import fr.sdis83.remocra.service.ParamConfService;
import fr.sdis83.remocra.service.UtilisateurService;
import fr.sdis83.remocra.service.ZoneCompetenceService;
import fr.sdis83.remocra.util.GeometryUtil;
import fr.sdis83.remocra.util.Layer;
import fr.sdis83.remocra.util.Layer.AccessLevel;
import fr.sdis83.remocra.web.serialize.transformer.GeometryTransformer;

@RequestMapping("/geoserver")
@Controller
public class GeoserverController {

    private final Logger log = Logger.getLogger(getClass());

    public static enum RequestType {
        // txt
        GetCapabilities, GetFeatureInfo, DescribeLayer,
        // bin
        GetMap, GetLegendGraphic;
    }

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private ParamConfService paramConfService;

    @Autowired
    private ZoneCompetenceService zoneCompetenceService;

    private Map<String, Layer> layers = null;

    public Map<String, Layer> getLayers() {
        if (layers == null) {
            layers = new HashMap<String, Layer>();
            // HD : Couches publiques, privées et restreintes sur la zone
            String folder = paramConfService.getDossierLayers();
            try {
                FileReader filereader = new FileReader(folder + "/layers.json");
                List<Layer> confLayers = new JSONDeserializer<List<Layer>>().use("values", Layer.class).deserialize(filereader);
                for (Layer l : confLayers) {
                    layers.put(l.getName(), new Layer(l.getName(), l.isOpen(), l.getProfils(), l.getProfilslimites()));
                }
            } catch (FileNotFoundException e) {
                log.error("Proxy WMS : fichier de configuration non trouvé", e);
            }
            int layersCountInFile = layers.size();
            // DB : couches publiques supplémentaires éventuelles
            // (rétrocompatibilité)
            for (String aPublicDbLayer : paramConfService.getWmsPublicLayers()) {
                if (!layers.containsKey(aPublicDbLayer)) {
                    layers.put(aPublicDbLayer, new Layer(aPublicDbLayer, true, new String[] {}, new String[] {}));
                }
            }
            int layersInParamConf = layers.size() - layersCountInFile;
            log.info("Proxy WMS : fichier de configuration chargé : " + layers.size() + " couches dont " + layersCountInFile + " de layers.json et " + layersInParamConf
                    + " publiques issues de param_conf");
        }
        return layers;
    }

    @PreAuthorize("hasRight('REFERENTIELS_C')")
    protected void reloadLayers() {
        log.info("Proxy WMS : rechargement de la configuration");
        this.layers = null;
        getLayers();
    }

    @PreAuthorize("hasRight('REFERENTIELS_C')")
    public ResponseEntity<java.lang.String> readLayers() {
        Map<String, Layer> l = getLayers();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json;charset=utf-8");
        return new ResponseEntity<String>(new JSONSerializer().exclude("*.class").include("*").prettyPrint(true).serialize(l), responseHeaders, HttpStatus.OK);
    }

    @RequestMapping("/**")
    public void proxyWms(HttpServletRequest request, HttpServletResponse response) {
        // /remocra/geoserver/** -> /geoserver/**

        // --------------------
        // Préparation de la requête
        // --------------------

        try {
            String geoserverPath = request.getServletPath().replaceFirst("/geoserver/", "");
            if (geoserverPath.endsWith("layers/reload")) {
                reloadLayers();
                return;
            } else if (geoserverPath.endsWith("layers")) {
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpStatus.OK.value());
                response.getWriter().write(readLayers().getBody());
                response.flushBuffer();
                return;
            }
            String wmsBaseUrl = paramConfService.getWmsBaseUrl();
            String targetURL = paramConfService.getWmsBaseUrl() + (wmsBaseUrl.endsWith("/") ? "" : "/") + geoserverPath;

            // Récupération de l'URL cible
            URI targetUri = new UrlResource(targetURL).getURI();
            HttpHost httpHost = new HttpHost(targetUri.getHost(), targetUri.getPort(), targetUri.getScheme());
            log.info("Proxy WMS : targetURL : " + targetURL);

            // Vérification WMS
            if (!isWms(request)) {
                log.info("Proxy WMS : service interdit (seulement wms)");
                response.setStatus(403);
            }

            String workspace = getWorkspace(request);
            RequestType requestType = getRequestType(request);

            // Vérification des autorisations
            AccessLevel accessLevel = getAccessLevel(request, response, workspace, requestType);
            if (accessLevel == AccessLevel.NONE) {
                return;
            }

            // Nouvelle URL cible
            UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl(targetURL);

            // Paramètres supplémentaires éventuels
            @SuppressWarnings("unchecked")
            Enumeration<String> paramNames = request.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                b.replaceQueryParam(paramName, request.getParameter(paramName));
            }

            // GetFeatureInfo : pour la mise en forme ultérieure
            if (RequestType.GetFeatureInfo == requestType) {
                // On force le format
                b.replaceQueryParam("INFO_FORMAT");
                b.replaceQueryParam("info_format", "application/vnd.ogc.gml/3.1.1");
            }

            // GetMap : filtre sur la zone de compétence si nécessaire
            if (RequestType.GetMap == requestType && accessLevel == AccessLevel.AUTH_ZONE) {
                String[] layers = getParameterOrLowerOrUpperCase(request, "LAYERS").split(",");
                // Exemple avec deux couches (clause INCLUDE si couche non
                // filtrée) :
                // &CQL_FILTER=INCLUDE;WITHIN(geometrie,(querySingle('remocra:zone_competence','geometrie','id=26')))
                // On passe par l'id en échappant avec %22 (double quote) car
                // mot réservé.
                // C'est plus sûr qu'en passant par une chaine de caractères
                // (code=VAR par exemple)
                ZoneCompetence zoneCompetence = utilisateurService.getCurrentUtilisateur().getOrganisme().getZoneCompetence();
                String idZone = zoneCompetence.getId().toString();
                String cqlFilterValue = "INTERSECTS(geometrie,(querySingle('remocra:zone_competence','geometrie','%22id%22=" + idZone + "')))";

                // On répère autant de fois la clause qu'il y a de couches
                String repeatedCqlFilterValue = StringUtils.repeat(cqlFilterValue, ";", layers.length);
                b.replaceQueryParam("CQL_FILTER", repeatedCqlFilterValue);
            }

            String targetURLWithFilter = b.build().toUriString();
            log.info("Proxy WMS : targetURLWithFilter : " + targetURLWithFilter);
            HttpRequest targetRequest = new DefaultHttpRequestFactory().newHttpRequest(request.getMethod(), targetURLWithFilter);

            // Entêtes
            @SuppressWarnings("unchecked")
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                if ("authorization".equalsIgnoreCase(headerName)) {
                    // Pour éviter de propager l'authentification Remocra vers
                    // le GeoServer
                    continue;
                }
                targetRequest.setHeader(headerName, request.getHeader(headerName));
            }

            // Réponse traitée txt => pas de zip
            if (RequestType.GetFeatureInfo == requestType || RequestType.GetCapabilities == requestType) {
                // On désire un résultat non compressé (pas de gzip, deflate,
                // etc.), sans quoi il faut le traiter ultérieurement
                targetRequest.setHeader("Accept-Encoding", "");
            }

            // --------------------
            // Exécution de la requête
            // --------------------

            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpResponse srcResponse = httpclient.execute(httpHost, targetRequest);

            // --------------------
            // Traitement de la réponse
            // --------------------

            // Entêtes
            Header[] headers = srcResponse.getAllHeaders();
            for (Header header : headers) {
                response.setHeader(header.getName(), header.getValue());
                if ("Content-Type".equalsIgnoreCase(header.getName())) {
                    response.setContentType(header.getValue());
                }
            }

            InputStream is = srcResponse.getEntity().getContent();
            OutputStream os = response.getOutputStream();

            try {
                if (RequestType.GetCapabilities == requestType) {
                    manageCapabilities(is, os, workspace);
                } else if (RequestType.GetFeatureInfo == requestType) {
                    manageFeatureInfo(is, os);
                } else {
                    // Retour direct (image ou autre)
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = is.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                }
            } catch (TransformerException e) {
                log.error("Proxy WMS : erreur de transformation", e);
            } catch (IOException e) {
                log.error("Proxy WMS : erreur d'entrée / sortie", e);
            } catch (Exception e) {
                log.error("Proxy WMS : autre erreur", e);
            } finally {
                os.flush();
                os.close();
            }
        } catch (MethodNotSupportedException e) {
            log.error("Proxy WMS : méthode invoquée non supportée", e);
            response.setStatus(500);
        } catch (IOException e) {
            log.error("Proxy WMS : erreur d'entrée / sortie", e);
            response.setStatus(500);
        }
    }

    boolean isWms(HttpServletRequest request) {
        String geoserverPath = request.getServletPath();
        String[] splittedPath = geoserverPath.split("/");
        String servicePath = splittedPath[splittedPath.length - 1];
        return "wms".equalsIgnoreCase(servicePath) || ("ows".equalsIgnoreCase(servicePath) && "wms".equalsIgnoreCase(getParameterOrLowerOrUpperCase(request, "SERVICE")));
    }

    String getWorkspace(HttpServletRequest request) {
        String geoserverPath = request.getServletPath();
        String[] splittedPath = geoserverPath.split("/");
        return splittedPath.length > 2 ? splittedPath[splittedPath.length - 2] : null;
    }

    RequestType getRequestType(HttpServletRequest request) {
        String requestParam = getParameterOrLowerOrUpperCase(request, "REQUEST");
        if ("DescribeLayer".equalsIgnoreCase(requestParam)) {
            return RequestType.DescribeLayer;
        } else if ("GetCapabilities".equalsIgnoreCase(requestParam)) {
            return RequestType.GetCapabilities;
        } else if ("GetFeatureInfo".equalsIgnoreCase(requestParam)) {
            return RequestType.GetFeatureInfo;
        } else if ("GetLegendGraphic".equalsIgnoreCase(requestParam)) {
            return RequestType.GetLegendGraphic;
        } else if ("GetMap".equalsIgnoreCase(requestParam)) {
            return RequestType.GetMap;
        }
        return null;
    }

    AccessLevel getAccessLevel(HttpServletRequest request, HttpServletResponse response, String workspace, RequestType requestType) {
        // Vérification des autorisations
        if (!(requestType == RequestType.GetCapabilities || requestType == RequestType.GetFeatureInfo || requestType == RequestType.GetMap
                || requestType == RequestType.GetLegendGraphic)) {
            log.info("Proxy WMS : " + requestType + " non permis");
            response.setStatus(403);
            return AccessLevel.NONE;
        }
        AccessLevel accessLevel = null;
        if (requestType == RequestType.GetLegendGraphic && AccessLevel.NONE == (accessLevel = getLayerAccessLevel(workspace, getParameterOrLowerOrUpperCase(request, "LAYER")))) {
            log.info("Proxy WMS : " + requestType + " sur couche non accessible");
            response.setStatus(403);
            return AccessLevel.NONE;
        }
        if ((requestType == RequestType.GetMap || requestType == RequestType.GetFeatureInfo)
                && AccessLevel.NONE == (accessLevel = getMoreRestrictedLayersAccessLevel(workspace, getParameterOrLowerOrUpperCase(request, "LAYERS")))) {
            log.info("Proxy WMS : " + requestType + " sur couche non accessible");
            response.setStatus(403);
            return AccessLevel.NONE;
        }
        // GetFeatureInfo : on filtre en amont selon la zone de compétence
        if (requestType == RequestType.GetFeatureInfo && accessLevel == AccessLevel.AUTH_ZONE) {
            // SRS, BBOX
            String bbox = getParameterOrLowerOrUpperCase(request, "BBOX");
            String wkt = GeometryUtil.wktFromBBox(bbox);
            Integer srid = GeometryUtil.sridFromEpsgCode(getParameterOrLowerOrUpperCase(request, "SRS"));
            Long zoneCompetence = utilisateurService.getCurrentZoneCompetenceId();

            if (!zoneCompetenceService.check(wkt, srid, zoneCompetence)) {
                log.info("Proxy WMS : " + requestType + " hors zone compétence");
                response.setStatus(403);
                return AccessLevel.NONE;
            }
        }
        return accessLevel;
    }

    public void manageCapabilities(InputStream is, OutputStream os, String workspace) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        InputSource source = new InputSource(is);
        Document doc = dBuilder.parse(source);

        manageCapabilitiesDocument(doc, workspace);

        // write the content
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource domSource = new DOMSource(doc);
        StreamResult result = new StreamResult(os);
        transformer.transform(domSource, result);
    }

    void manageCapabilitiesDocument(Document doc, String workspace) {
        doc.getDocumentElement().normalize();
        doc.getDocumentElement().removeAttribute("xsi:schemaLocation");
        doc.getDocumentElement().removeAttribute("schemaLocation");
        List<Node> layersToRemove = new LinkedList<Node>();
        NodeList layerNodes = doc.getElementsByTagName("Layer");
        for (int layerIdx = 0; layerIdx < layerNodes.getLength(); layerIdx++) {
            Node layerNode = layerNodes.item(layerIdx);
            if (layerNode.getNodeType() == Node.ELEMENT_NODE) {
                Element layerElement = (Element) layerNode;
                NodeList layerChildrenNodes = layerElement.getChildNodes();
                for (int layerChildrenIdx = 0; layerChildrenIdx < layerChildrenNodes.getLength(); layerChildrenIdx++) {
                    Node layerChildNode = layerChildrenNodes.item(layerChildrenIdx);
                    if ("Name".equals(layerChildNode.getNodeName())) {
                        String layerName = layerChildNode.getTextContent();
                        if (!isLayerAccessible(workspace, layerName)) {
                            layersToRemove.add(layerNode);
                            // break;
                        }
                    } else if (layerChildNode.getNodeType() == Node.COMMENT_NODE) {
                        layersToRemove.add(layerChildNode);
                    }
                }
            }
        }
        for (Node l : layersToRemove) {
            l.getParentNode().removeChild(l);
        }

        NodeList onlineResourceNodes = doc.getElementsByTagName("OnlineResource");
        for (int onlineResourceIdx = 0; onlineResourceIdx < onlineResourceNodes.getLength(); onlineResourceIdx++) {
            Node onlineResourceNode = onlineResourceNodes.item(onlineResourceIdx);
            Element onlineElement = (Element) onlineResourceNode;
            onlineElement.setAttribute("xlink:href", rewriteUrl(onlineElement.getAttribute("xlink:href")));
            onlineElement.setAttribute("href", rewriteUrl(onlineElement.getAttribute("href")));
        }
    }

    void manageFeatureInfo(InputStream is, OutputStream os) throws Exception {
        // Mise en forme via transfo XSL selon profil
        File transfoFile = getGetFeatureInfoTransfoFile();
        log.info("Proxy WMS : transfo : " + transfoFile.getAbsolutePath());
        StreamSource xmlSource = new StreamSource(is);

        StreamSource styleSource = new StreamSource(transfoFile);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(styleSource);

        StreamResult result = new StreamResult(os);
        transformer.transform(xmlSource, result);
    }

    /**
     * Retourne le fichier de configuration à utiliser pour la transformation
     * XSL. Dans l'ordre : fichier correspondant au profil, puis fichier public.
     * Enfin, une exception si aucun fichier trouvé
     * 
     * @return
     * @throws FileNotFoundException
     */
    protected File getGetFeatureInfoTransfoFile() throws FileNotFoundException {
        String codeFeuille = null, defaultCodeFeuille = "public";
        try {
            ProfilDroit profilDroit = utilisateurService.getCurrentProfilDroit();
            codeFeuille = profilDroit == null ? defaultCodeFeuille : profilDroit.getFeuilleDeStyleGeoServer().toLowerCase();
        } catch (AccessDeniedException e) {
            log.error("Proxy WMS : unable to find profile for utilisateur. Access Denied");
            codeFeuille = defaultCodeFeuille;
        } catch (BusinessException e) {
            log.error("Proxy WMS : unable to find profile for utilisateur.");
            codeFeuille = defaultCodeFeuille;
        }
        String folder = paramConfService.getDossierGetFeatureInfo();
        File returned = new File(folder + File.separatorChar + codeFeuille + ".xsl");
        if (!returned.exists()) {
            returned = new File(folder + File.separatorChar + defaultCodeFeuille + ".xsl");
            if (!returned.exists()) {
                throw new FileNotFoundException("Fichier de configuration non trouvé");
            }
        }
        return returned;
    }

    AccessLevel getMoreRestrictedLayersAccessLevel(String workspace, String layers) {
        if (layers == null) {
            return AccessLevel.OPEN;
        }
        return getMoreRestrictedLayersAccessLevel(workspace, layers.split(","));
    }

    AccessLevel getMoreRestrictedLayersAccessLevel(String workspace, String[] layers) {
        AccessLevel returned = AccessLevel.OPEN;
        for (String layer : layers) {
            AccessLevel al = getLayerAccessLevel(workspace, layer);
            returned = AccessLevel.getMostRestricted(returned, al);
        }
        return returned;
    }

    boolean isLayerAccessible(String workspace, String name) {
        return getLayerAccessLevel(workspace, name) != AccessLevel.NONE;
    }

    AccessLevel getLayerAccessLevel(String workspace, String name) {
        Layer l = getLayers().get(getLayerNameWithWorkspace(workspace, name));
        if (l == null) {
            return AccessLevel.NONE;
        }
        if (l.isOpen()) {
            return AccessLevel.OPEN;
        }
        if (!AuthService.isUserAuthenticated()) {
            return AccessLevel.NONE;
        }
        try {
            String profilCode = utilisateurService.getCurrentProfilDroit().getCode();
            if (l.hasProfil(profilCode)) {
                return AccessLevel.AUTH_ALL;
            }
            if (l.hasProfillimite(profilCode)) {
                return AccessLevel.AUTH_ZONE;
            }
        } catch (BusinessException e) {
            // Erreur de charge du profil : aucun accès
        }
        return AccessLevel.NONE;

    }

    String rewriteUrl(String url) {
        if (url != null) {
            String rewritten = url.replaceFirst("http(s?):\\/\\/.*\\/geoserver", paramConfService.getUrlSite() + "geoserver");
            log.debug("Proxy WMS : rewrite url (" + url + " -> " + rewritten + ")");
            return rewritten;
        }
        return url;
    }

    String getParameterOrLowerOrUpperCase(HttpServletRequest request, String name) {
        if (name == null) {
            return null;
        }
        String value = request.getParameter(name);
        if (value == null) {
            value = request.getParameter(name.toLowerCase());
            if (value == null) {
                value = request.getParameter(name.toUpperCase());
            }
        }
        return value;
    }

    String getLayerNameWithWorkspace(String workspace, String layername) {
        if (layername == null) {
            return null;
        }
        if (workspace == null || workspace.isEmpty() || layername.contains(":")) {
            return layername;
        }
        return workspace + ":" + layername;
    }
}
