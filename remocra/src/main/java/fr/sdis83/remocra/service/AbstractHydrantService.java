package fr.sdis83.remocra.service;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.vividsolutions.jts.geom.Geometry;

import fr.sdis83.remocra.domain.remocra.Document;
import fr.sdis83.remocra.domain.remocra.Document.TypeDocument;
import fr.sdis83.remocra.domain.remocra.Hydrant;
import fr.sdis83.remocra.domain.remocra.HydrantDocument;
import fr.sdis83.remocra.util.DocumentUtil;
import fr.sdis83.remocra.web.message.ItemFilter;
import fr.sdis83.remocra.web.message.ItemSorting;

@Configuration
public abstract class AbstractHydrantService<T extends Hydrant> extends AbstractService<T> {

    @Autowired
    protected ParamConfService paramConfService;

    @Autowired
    private UtilisateurService utilisateurService;

    // private final Logger logger = Logger.getLogger(getClass());

    public AbstractHydrantService(Class<T> cls) {
        super(cls);
    }

    @Override
    protected Predicate processFilterItem(Map<String, Object> parameters, Root<T> from, ItemFilter itemFilter) {
        CriteriaBuilder cBuilder = this.getCriteriaBuilder();
        Predicate predicat = null;
        if ("tournee".equals(itemFilter.getFieldName())) {
            Expression<Integer> cpPath = from.join("tournee").get("id");
            predicat = cBuilder.equal(cpPath, itemFilter.getValue());
        } else if ("zoneCompetence".equals(itemFilter.getFieldName())) {

            Expression<Geometry> cpPath = from.get("geometrie");
            ParameterExpression<Geometry> zoneCompetence = cBuilder.parameter(Geometry.class, "zoneCompetence");
            ParameterExpression<Double> distanceZone = cBuilder.parameter(Double.class, "distanceZone");
            predicat = cBuilder.equal(cBuilder.function("st_dwithin", Boolean.class, cpPath, zoneCompetence, distanceZone), Boolean.TRUE);

        } else if ("id".equals(itemFilter.getFieldName())) {
            Expression<String> cpPath = from.get("id");
            predicat = cBuilder.equal(cpPath, itemFilter.getValue());
        } else if ("numero".equals(itemFilter.getFieldName()) || "query".equals(itemFilter.getFieldName())) {
            Expression<String> cpPath = from.get("numero");
            predicat = cBuilder.like(cpPath, "%" + itemFilter.getValue().toUpperCase(Locale.FRANCE) + "%");
        } else if ("dateReco".equals(itemFilter.getFieldName())) {
            Expression<Date> cpPath = from.get("dateReco");
            Integer nbMonths = Integer.valueOf(itemFilter.getValue());
            if (nbMonths > 0) {
                DateTime date = new DateTime().minus(Period.days(paramConfService.getHydrantRenouvellementReco())).plus(Period.months(nbMonths));
                predicat = cBuilder.or(cBuilder.isNull(cpPath), cBuilder.lessThanOrEqualTo(cpPath, date.toDate()));
            } else if (nbMonths < 0) {
                DateTime date = new DateTime().minus(Period.days(paramConfService.getHydrantRenouvellementReco()));
                predicat = cBuilder.lessThanOrEqualTo(cpPath, date.toDate());
            }
        } else if ("dateContr".equals(itemFilter.getFieldName())) {
            Expression<Date> cpPath = from.get("dateContr");
            Integer nbMonths = Integer.valueOf(itemFilter.getValue());
            if (nbMonths > 0) {
                DateTime date = new DateTime().minus(Period.days(paramConfService.getHydrantRenouvellementCtrl())).plus(Period.months(nbMonths));
                predicat = cBuilder.or(cBuilder.isNull(cpPath), cBuilder.lessThanOrEqualTo(cpPath, date.toDate()));
            } else if (nbMonths < 0) {
                DateTime date = new DateTime().minus(Period.days(paramConfService.getHydrantRenouvellementCtrl()));
                predicat = cBuilder.lessThanOrEqualTo(cpPath, date.toDate());
            }
        } else if ("nature".equals(itemFilter.getFieldName())) {
            Expression<Integer> cpPath = from.join("nature").get("id");
            predicat = cBuilder.equal(cpPath, itemFilter.getValue());
        } else if ("naturecode".equals(itemFilter.getFieldName())) {
            Expression<Integer> cpPath = from.join("nature").get("code");
            predicat = cBuilder.equal(cpPath, itemFilter.getValue());
        } else {
            return super.processFilterItem(parameters, from, itemFilter);
        }
        return predicat;
    }

    @Override
    protected void processQuery(TypedQuery<?> itemTypedQuery, List<ItemSorting> itemSortings, List<ItemFilter> itemFilters, List<Order> orders, Predicate[] predicates) {
        ItemFilter wktFilter = ItemFilter.getFilter(itemFilters, "zoneCompetence");
        if (wktFilter != null) {
            itemTypedQuery.setParameter("zoneCompetence", utilisateurService.getCurrentUtilisateur().getOrganisme().getZoneCompetence().getGeometrie());
            itemTypedQuery.setParameter("distanceZone", Double.valueOf(0));
        }
    }

    @Transactional
    @Override
    public T setUpInformation(T attached, Map<String, MultipartFile> files, Object... params) throws Exception {
        // traitement géométrie
        attached.getGeometrie().setSRID(2154);

        // date de modification
        attached.setDateModification(new Date());

        // traitement photo
        if (files != null && !files.isEmpty()) {
            MultipartFile file = files.values().iterator().next();
            if (!file.isEmpty()) {
                Document d = DocumentUtil.getInstance().createNonPersistedDocument(TypeDocument.HYDRANT, file, paramConfService.getDossierDocHydrant());
                HydrantDocument hd = new HydrantDocument();
                hd.setHydrant(attached);
                hd.setDocument(this.entityManager.merge(d));
                attached.getPhotos().clear();
                attached.getPhotos().add(hd);
            }
        }

        // On redéfinit le code, la zone spéciale éventuelle, le numéro interne et le numéro
        Hydrant.setCodeZoneSpecAndNumeros(attached);

        // On attache l'organisme de l'utilisateur courant
        attached.setOrganisme(utilisateurService.getCurrentUtilisateur().getOrganisme());

        return attached;
    }
}
