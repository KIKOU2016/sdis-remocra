// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.TypeHydrantDomaine;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect TypeHydrantDomaine_Roo_Finder {
    
    public static Long TypeHydrantDomaine.countFindTypeHydrantDomainesByActif(Boolean actif) {
        if (actif == null) throw new IllegalArgumentException("The actif argument is required");
        EntityManager em = TypeHydrantDomaine.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM TypeHydrantDomaine AS o WHERE o.actif = :actif", Long.class);
        q.setParameter("actif", actif);
        return ((Long) q.getSingleResult());
    }
    
    public static Long TypeHydrantDomaine.countFindTypeHydrantDomainesByCode(String code) {
        if (code == null || code.length() == 0) throw new IllegalArgumentException("The code argument is required");
        EntityManager em = TypeHydrantDomaine.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM TypeHydrantDomaine AS o WHERE o.code = :code", Long.class);
        q.setParameter("code", code);
        return ((Long) q.getSingleResult());
    }
    
    public static TypedQuery<TypeHydrantDomaine> TypeHydrantDomaine.findTypeHydrantDomainesByActif(Boolean actif) {
        if (actif == null) throw new IllegalArgumentException("The actif argument is required");
        EntityManager em = TypeHydrantDomaine.entityManager();
        TypedQuery<TypeHydrantDomaine> q = em.createQuery("SELECT o FROM TypeHydrantDomaine AS o WHERE o.actif = :actif", TypeHydrantDomaine.class);
        q.setParameter("actif", actif);
        return q;
    }
    
    public static TypedQuery<TypeHydrantDomaine> TypeHydrantDomaine.findTypeHydrantDomainesByActif(Boolean actif, String sortFieldName, String sortOrder) {
        if (actif == null) throw new IllegalArgumentException("The actif argument is required");
        EntityManager em = TypeHydrantDomaine.entityManager();
        String jpaQuery = "SELECT o FROM TypeHydrantDomaine AS o WHERE o.actif = :actif";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<TypeHydrantDomaine> q = em.createQuery(jpaQuery, TypeHydrantDomaine.class);
        q.setParameter("actif", actif);
        return q;
    }
    
    public static TypedQuery<TypeHydrantDomaine> TypeHydrantDomaine.findTypeHydrantDomainesByCode(String code) {
        if (code == null || code.length() == 0) throw new IllegalArgumentException("The code argument is required");
        EntityManager em = TypeHydrantDomaine.entityManager();
        TypedQuery<TypeHydrantDomaine> q = em.createQuery("SELECT o FROM TypeHydrantDomaine AS o WHERE o.code = :code", TypeHydrantDomaine.class);
        q.setParameter("code", code);
        return q;
    }
    
    public static TypedQuery<TypeHydrantDomaine> TypeHydrantDomaine.findTypeHydrantDomainesByCode(String code, String sortFieldName, String sortOrder) {
        if (code == null || code.length() == 0) throw new IllegalArgumentException("The code argument is required");
        EntityManager em = TypeHydrantDomaine.entityManager();
        String jpaQuery = "SELECT o FROM TypeHydrantDomaine AS o WHERE o.code = :code";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<TypeHydrantDomaine> q = em.createQuery(jpaQuery, TypeHydrantDomaine.class);
        q.setParameter("code", code);
        return q;
    }
    
}
