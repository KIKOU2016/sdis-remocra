package fr.sdis83.remocra.web;

import java.util.List;
import java.util.Map;

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

import flexjson.JSONSerializer;
import fr.sdis83.remocra.domain.remocra.HistoVerificationHydraulique;
import fr.sdis83.remocra.domain.remocra.HydrantPibi;
import fr.sdis83.remocra.exception.BusinessException;
import fr.sdis83.remocra.service.HydrantPibiService;
import fr.sdis83.remocra.util.ExceptionUtils;
import fr.sdis83.remocra.web.message.ItemFilter;
import fr.sdis83.remocra.web.message.ItemSorting;
import fr.sdis83.remocra.web.serialize.ext.AbstractExtListSerializer;
import fr.sdis83.remocra.web.serialize.ext.AbstractExtObjectSerializer;
import fr.sdis83.remocra.web.serialize.ext.SuccessErrorExtSerializer;
import fr.sdis83.remocra.web.serialize.transformer.GeometryTransformer;

@RequestMapping("/hydrantspibi")
@Controller
public class HydrantPibiController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private HydrantPibiService hydrantPibiService;

    @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
    @PreAuthorize("hasRight('HYDRANTS_R')")
    public ResponseEntity<java.lang.String> listJson(final @RequestParam(value = "page", required = false) Integer page,
            final @RequestParam(value = "start", required = false) Integer start, final @RequestParam(value = "limit", required = false) Integer limit,
            final @RequestParam(value = "sort", required = false) String sorts, final @RequestParam(value = "filter", required = false) String filters,
            final @RequestParam(value = "query", required = false) String query) {

        final List<ItemSorting> sortList = ItemSorting.decodeJson(sorts);
        final List<ItemFilter> itemFilterList = ItemFilter.decodeJson(filters);

        if (query != null && !query.isEmpty()) {
            itemFilterList.add(new ItemFilter("query", query));
        }

        return new AbstractExtListSerializer<HydrantPibi>("fr.sdis83.remocra.domain.remocra.HydrantPibi retrieved.") {

            @Override
            protected JSONSerializer additionnalIncludeExclude(JSONSerializer serializer) {
                return new JSONSerializer().include("data.anomalies", "data.photos", "data.pena.id", "data.utilisateurModification")
                        .exclude( "data.commune.geometrie", "data.pena.*", "*.class").transform(new GeometryTransformer(), Geometry.class);
            }

            @Override
            protected List<HydrantPibi> getRecords() {
                return hydrantPibiService.find(start, limit, sortList, itemFilterList);
            }

            @Override
            protected Long countRecords() {
                return hydrantPibiService.count(itemFilterList);
            }

        }.serialize();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @PreAuthorize("hasRight('HYDRANTS_R')")
    public ResponseEntity<java.lang.String> getHydrant(final @RequestParam(value = "id", required = true) Long id) {

        return new AbstractExtObjectSerializer<HydrantPibi>("fr.sdis83.remocra.domain.remocra.Hydrant-Pibi retrieved.") {

            @Override
            protected JSONSerializer additionnalIncludeExclude(JSONSerializer serializer) {
                return serializer
                        // anomalies
                        .include("data.anomalies")
                        // tournees
                        .include("data.tournees.id").include("data.tournees.nom")
                        .include( "data.utilisateurModification.id").include( "data.utilisateurModification.nom")

                    // photo associée
                        .include("data.photo")
                        // Documents
                        .include("data.hydrantDocuments.id").include("data.hydrantDocuments.titre").include("data.hydrantDocuments.code")
                        .exclude("data.hydrantDocuments.*")
                        .exclude("data.tournees.*")
                        .exclude( "data.organisme.zoneCompetence.geometrie")
                        .exclude( "data.utilisateurModification.*")
                        .exclude( "data.commune.geometrie");

            }

            @Override
            protected HydrantPibi getRecord() {
                return HydrantPibi.findHydrantPibi(id);
            }

        }.serialize();
    }

    @RequestMapping(value = "", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
    @PreAuthorize("hasRight('HYDRANTS_C')")
    public ResponseEntity<java.lang.String> createHydrant(MultipartHttpServletRequest request) {
        String json = request.getParameter("hydrant");
        Map<String, MultipartFile> files = request.getFileMap();
        try {
            final HydrantPibi attached = hydrantPibiService.create(json, files);
            if (attached != null) {
                return new AbstractExtObjectSerializer<HydrantPibi>("Hydrant Pibi created.", SuccessErrorExtSerializer.DEFAULT_CONTENT_TYPE) {
                    @Override
                    protected HydrantPibi getRecord() throws BusinessException {
                        return attached;
                    }
                }.serialize();
            }
        } catch (Exception e) {
            ConstraintViolationException dke = ExceptionUtils.getNestedExceptionWithClass(e,
                    ConstraintViolationException.class);
            if (dke != null) {
                String message = dke.getMessage();
                logger.error(message, e);
                if (message != null && message.contains("hydrant_numero_key")) {
                    return new SuccessErrorExtSerializer(false, "hydrant_numero_key").serialize();
                }
            }
            return new SuccessErrorExtSerializer(false, e.getMessage()).serialize();
        }
        return new SuccessErrorExtSerializer(false, "Hydrant Pena inexistant", HttpStatus.NOT_FOUND).serialize();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
    @PreAuthorize("hasRight('HYDRANTS_C') or hasRight('HYDRANTS_RECONNAISSANCE_C') or hasRight('HYDRANTS_CONTROLE_C')")
    public ResponseEntity<java.lang.String> updateHydrant(final @PathVariable Long id, MultipartHttpServletRequest request) {
        String json = request.getParameter("hydrant");
        Map<String, MultipartFile> files = request.getFileMap();
        try {
            final HydrantPibi attached = hydrantPibiService.update(id, json, files);
            if (attached != null) {
                return new AbstractExtObjectSerializer<HydrantPibi>("Hydrant Pibi updated.", SuccessErrorExtSerializer.DEFAULT_CONTENT_TYPE) {
                    @Override
                    protected HydrantPibi getRecord() throws BusinessException {
                        return attached;
                    }
                }.serialize();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new SuccessErrorExtSerializer(false, e.getMessage()).serialize();
        }
        return new SuccessErrorExtSerializer(false, "Hydrant Pena inexistant", HttpStatus.NOT_FOUND).serialize();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    @PreAuthorize("hasRight('HYDRANTS_D')")
    public ResponseEntity<java.lang.String> deleteHydrantPibi(@PathVariable("id") Long id) {
        try {
            hydrantPibiService.delete(id);
            return new SuccessErrorExtSerializer(true, "Hydrant Pibi supprimé").serialize();
        } catch (Exception e) {
            return new SuccessErrorExtSerializer(false, e.getMessage()).serialize();
        }
    }

    @RequestMapping(value = "/histoverifhydrau/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @PreAuthorize("hasRight('HYDRANTS_R')")
    public ResponseEntity<java.lang.String> getHistoVerifHydrau(final @PathVariable Long id) {

        return new AbstractExtObjectSerializer<HistoVerificationHydraulique>("Hydrant Pibi historique vérification hydraulique retrieved.") {
            @Override
            protected HistoVerificationHydraulique getRecord() {
                return hydrantPibiService.getHistoVerifHydrau(id);
            }

        }.serialize();
    }

    @RequestMapping(value = "/histoverifhydrauforchart/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @PreAuthorize("hasRight('HYDRANTS_R')")
    public ResponseEntity<java.lang.String> getHistoVerifHydrauForChart(final @PathVariable Long id) {

        return new AbstractExtObjectSerializer<List<Object>>("Hydrant Pibi historique vérification hydraulique retrieved.") {
            @Override
            protected List<Object> getRecord() {
                return hydrantPibiService.getHistoVerifHydrauForChart(id);
            }

        }.serialize();
    }

}
