package fr.sdis83.remocra.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.sdis83.remocra.domain.remocra.Tournee;
import fr.sdis83.remocra.domain.remocra.Utilisateur;
import fr.sdis83.remocra.web.message.ItemFilter;
import fr.sdis83.remocra.web.message.ItemSorting;

@Configuration
public class TourneeService extends AbstractService<Tournee> {

    private final Logger logger = Logger.getLogger(getClass());

    public TourneeService() {
        super(Tournee.class);
    }

    @Bean
    public TourneeService tourneeService() {
        return new TourneeService();
    }

    @Override
    protected Predicate processFilterItem(Map<String, Object> parameters, Root<Tournee> from, ItemFilter itemFilter) {
        CriteriaBuilder cBuilder = this.getCriteriaBuilder();
        Predicate predicat = null;
        if ("id".equals(itemFilter.getFieldName())) {
            Expression<String> cpPath = from.get("id");
            predicat = cBuilder.equal(cpPath, itemFilter.getValue());
        } else if ("query".equals(itemFilter.getFieldName())) {
            Expression<String> cpPath = from.get("id");
            predicat = cBuilder.like(cBuilder.concat("", cpPath), itemFilter.getValue() + "%");
        } else if ("affectation".equals(itemFilter.getFieldName())) {
            Expression<String> cpPath = from.join("affectation").get("id");
            predicat = cBuilder.equal(cpPath, itemFilter.getValue());
        } else if ("hydrantCount".equals(itemFilter.getFieldName())) {
            Expression<Collection<String>> hydrants = from.get("hydrants");
            predicat = cBuilder.equal(cBuilder.size(hydrants), itemFilter.getValue());
        } else if ("reserved".equals(itemFilter.getFieldName())) {
            boolean reserved = Boolean.parseBoolean(itemFilter.getValue());
            Expression<String> cpPath = from.get("reservation");
            if (reserved) {
                predicat = cpPath.isNotNull();
            } else {
                predicat = cpPath.isNull();
            }
        } else {
            logger.info("processFilterItem non traité " + itemFilter.getFieldName() + " (" + itemFilter.getValue() + ")");
        }
        return predicat;
    }

    @Override
    protected boolean processItemSortings(ArrayList<Order> orders, ItemSorting itemSorting, CriteriaBuilder cBuilder, Root<Tournee> from) {
        if ("affectation".equals(itemSorting.getFieldName())) {
            Path<String> nom = from.get("affectation").get("nom");
            orders.add(itemSorting.isDesc() ? cBuilder.desc(nom) : cBuilder.asc(nom));
        } else if ("reservation".equals(itemSorting.getFieldName())) {
            Path<String> nom = from.join("reservation", JoinType.LEFT).get("nom");
            orders.add(itemSorting.isDesc() ? cBuilder.desc(nom) : cBuilder.asc(nom));
        }
        return super.processItemSortings(orders, itemSorting, cBuilder, from);
    }

    public List<Tournee> getTourneeDisponible(Utilisateur utilisateur) {
        String sql = "SELECT t FROM Tournee t where t.affectation = :organisme and t.reservation is null and t.etat < 100 and t.hydrantCount > 0";
        TypedQuery<Tournee> query = entityManager.createQuery(sql, Tournee.class);
        query.setParameter("organisme", utilisateur.getOrganisme());
        return query.getResultList();
    }

}
