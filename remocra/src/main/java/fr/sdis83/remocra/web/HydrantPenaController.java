package fr.sdis83.remocra.web;

import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.exception.ConstraintViolationException;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import flexjson.JSONSerializer;
import fr.sdis83.remocra.domain.remocra.HydrantPena;
import fr.sdis83.remocra.exception.BusinessException;
import fr.sdis83.remocra.service.HydrantPenaService;
import fr.sdis83.remocra.service.HydrantPibiService;
import fr.sdis83.remocra.util.ExceptionUtils;
import fr.sdis83.remocra.util.GeometryUtil;
import fr.sdis83.remocra.web.serialize.ext.AbstractExtObjectSerializer;
import fr.sdis83.remocra.web.serialize.ext.SuccessErrorExtSerializer;

@RequestMapping("/hydrantspena")
@Controller
public class HydrantPenaController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private HydrantPenaService hydrantPenaService;

    @Autowired
    private HydrantPibiService hydrantPibiService;

    @Autowired
    DataSource dataSource;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @PreAuthorize("hasRight('HYDRANTS', 'READ')")
    public ResponseEntity<java.lang.String> getHydrant(final @RequestParam(value = "id", required = true) Long id) {

        return new AbstractExtObjectSerializer<HydrantPena>("fr.sdis83.remocra.domain.remocra.Hydrant-Pena retrieved.") {

            @Override
            protected JSONSerializer additionnalIncludeExclude(JSONSerializer serializer) {
                return serializer.include("data.anomalies")
                        // photo associée
                        .include("data.photo")
                        // Documents
                        .include("data.hydrantDocuments.id").include("data.hydrantDocuments.titre").include("data.hydrantDocuments.code").exclude("data.hydrantDocuments.*")
                        .include("data.pibiAssocie.id").exclude("data.utilisateur", "data.commune.geometrie", "data.pibiAssocie.*");
            }

            @Override
            protected HydrantPena getRecord() {
                return HydrantPena.findHydrantPena(id);
            }

        }.serialize();
    }

    @RequestMapping(value = "", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
    @PreAuthorize("hasRight('HYDRANTS', 'CREATE')")
    public ResponseEntity<java.lang.String> createHydrant(MultipartHttpServletRequest request) {
        String json = request.getParameter("hydrant");
        Map<String, MultipartFile> files = request.getFileMap();
        try {
            final HydrantPena hydrant = hydrantPenaService.create(json, files);
            return new AbstractExtObjectSerializer<HydrantPena>("Hydrant-Pena created", SuccessErrorExtSerializer.DEFAULT_CONTENT_TYPE) {
                @Override
                protected HydrantPena getRecord() throws BusinessException {
                    return hydrant;
                }

            }.serialize();
        } catch (Exception e) {
            e.printStackTrace();
            return new SuccessErrorExtSerializer(false, e.getMessage()).serialize();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
    @PreAuthorize("hasRight('HYDRANTS', 'CREATE') or hasRight('HYDRANTS_RECONNAISSANCE', 'CREATE') or hasRight('HYDRANTS_CONTROLE', 'CREATE')")
    public ResponseEntity<java.lang.String> updateHydrant(final @PathVariable Long id, MultipartHttpServletRequest request) {
        String json = request.getParameter("hydrant");
        String paramPibi = request.getParameter("idpibi");
        String jsonAssocie = request.getParameter("associe");
        Map<String, MultipartFile> files = request.getFileMap();
        try {
            final HydrantPena attached = hydrantPenaService.update(id, json, files);
            if (attached != null) {
                if (paramPibi != null && !paramPibi.isEmpty() && jsonAssocie != null && !jsonAssocie.isEmpty()) {
                    Long idPibi = Long.valueOf(paramPibi);
                    hydrantPibiService.update(idPibi, jsonAssocie, null, attached);
                }
                return new AbstractExtObjectSerializer<HydrantPena>("Hydrant Pena updated.", SuccessErrorExtSerializer.DEFAULT_CONTENT_TYPE) {
                    @Override
                    protected HydrantPena getRecord() throws BusinessException {
                        return attached;
                    }
                }.serialize();
            }
        } catch (Exception e) {
            ConstraintViolationException dke = ExceptionUtils.getNestedExceptionWithClass(e, ConstraintViolationException.class);
            if (dke!=null) {
                String message = dke.getMessage();
                logger.error(message, e);
                if (message!=null && message.contains("hydrant_numero_key")) {
                    return new SuccessErrorExtSerializer(false, "hydrant_numero_key").serialize();
                }
            }
            return new SuccessErrorExtSerializer(false, e.getMessage()).serialize();
        }
        return new SuccessErrorExtSerializer(false, "Hydrant Pena inexistant", HttpStatus.NOT_FOUND).serialize();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    @PreAuthorize("hasRight('HYDRANTS', 'DELETE')")
    public ResponseEntity<java.lang.String> deleteHydrantPena(@PathVariable("id") Long id) {
        try {
            hydrantPenaService.delete(id);
            return new SuccessErrorExtSerializer(true, "Hydrant Pena supprimé").serialize();
        } catch (Exception e) {
            return new SuccessErrorExtSerializer(false, e.getMessage()).serialize();
        }
    }

    /**
     * Droits nécessaires : HYDRANTS.READ ou RCI.CREATE car utilisé pour
     * récupérer les coordonnées
     * 
     * @param srid
     * @param wkt
     * @return
     */
    @RequestMapping(value = "/dfci", method = RequestMethod.POST, headers = "Accept=application/json")
    @PreAuthorize("hasRight('HYDRANTS', 'READ') OR hasRight('RCI', 'CREATE')")
    public ResponseEntity<java.lang.String> findCoordDfci(final @RequestParam(value = "srid", required = true) Integer srid,
            final @RequestParam(value = "wkt", required = true) String wkt) {
        try {
            WKTReader fromText = new WKTReader();
            Geometry filter = null;
            try {
                filter = fromText.read(wkt);
                filter.setSRID(srid);
            } catch (ParseException e) {
                throw new RuntimeException("Not a WKT string:" + wkt);
            }
            String result = GeometryUtil.findCoordDFCIFromGeom(dataSource, filter);
            return new SuccessErrorExtSerializer(true, result).serialize();
        } catch (BusinessException e) {
            logger.debug("Aucune entrée trouvée dans la table remocra_referentiel.carro_dfci pour " + wkt);
            return RemocraController.DUMMY_RESPONSE;
        } catch (Exception e) {
            logger.debug("Problème lors de la requête sur la table remocra_referentiel.carro_dfci");
            return RemocraController.DUMMY_RESPONSE;
        }
    }
}
