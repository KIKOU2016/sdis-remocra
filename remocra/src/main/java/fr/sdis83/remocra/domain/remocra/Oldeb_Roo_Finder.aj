// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.Commune;
import fr.sdis83.remocra.domain.remocra.Oldeb;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect Oldeb_Roo_Finder {
    
    public static Long Oldeb.countFindOldebsByCommune(Commune commune) {
        if (commune == null) throw new IllegalArgumentException("The commune argument is required");
        EntityManager em = Oldeb.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Oldeb AS o WHERE o.commune = :commune", Long.class);
        q.setParameter("commune", commune);
        return ((Long) q.getSingleResult());
    }
    
    public static TypedQuery<Oldeb> Oldeb.findOldebsByCommune(Commune commune) {
        if (commune == null) throw new IllegalArgumentException("The commune argument is required");
        EntityManager em = Oldeb.entityManager();
        TypedQuery<Oldeb> q = em.createQuery("SELECT o FROM Oldeb AS o WHERE o.commune = :commune", Oldeb.class);
        q.setParameter("commune", commune);
        return q;
    }
    
    public static TypedQuery<Oldeb> Oldeb.findOldebsByCommune(Commune commune, String sortFieldName, String sortOrder) {
        if (commune == null) throw new IllegalArgumentException("The commune argument is required");
        EntityManager em = Oldeb.entityManager();
        String jpaQuery = "SELECT o FROM Oldeb AS o WHERE o.commune = :commune";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Oldeb> q = em.createQuery(jpaQuery, Oldeb.class);
        q.setParameter("commune", commune);
        return q;
    }
    
}