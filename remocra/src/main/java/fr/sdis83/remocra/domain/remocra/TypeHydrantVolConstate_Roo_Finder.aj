// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.TypeHydrantVolConstate;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect TypeHydrantVolConstate_Roo_Finder {
    
    public static Long TypeHydrantVolConstate.countFindTypeHydrantVolConstatesByActif(Boolean actif) {
        if (actif == null) throw new IllegalArgumentException("The actif argument is required");
        EntityManager em = TypeHydrantVolConstate.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM TypeHydrantVolConstate AS o WHERE o.actif = :actif", Long.class);
        q.setParameter("actif", actif);
        return ((Long) q.getSingleResult());
    }
    
    public static Long TypeHydrantVolConstate.countFindTypeHydrantVolConstatesByCode(String code) {
        if (code == null || code.length() == 0) throw new IllegalArgumentException("The code argument is required");
        EntityManager em = TypeHydrantVolConstate.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM TypeHydrantVolConstate AS o WHERE o.code = :code", Long.class);
        q.setParameter("code", code);
        return ((Long) q.getSingleResult());
    }
    
    public static TypedQuery<TypeHydrantVolConstate> TypeHydrantVolConstate.findTypeHydrantVolConstatesByActif(Boolean actif) {
        if (actif == null) throw new IllegalArgumentException("The actif argument is required");
        EntityManager em = TypeHydrantVolConstate.entityManager();
        TypedQuery<TypeHydrantVolConstate> q = em.createQuery("SELECT o FROM TypeHydrantVolConstate AS o WHERE o.actif = :actif", TypeHydrantVolConstate.class);
        q.setParameter("actif", actif);
        return q;
    }
    
    public static TypedQuery<TypeHydrantVolConstate> TypeHydrantVolConstate.findTypeHydrantVolConstatesByActif(Boolean actif, String sortFieldName, String sortOrder) {
        if (actif == null) throw new IllegalArgumentException("The actif argument is required");
        EntityManager em = TypeHydrantVolConstate.entityManager();
        String jpaQuery = "SELECT o FROM TypeHydrantVolConstate AS o WHERE o.actif = :actif";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<TypeHydrantVolConstate> q = em.createQuery(jpaQuery, TypeHydrantVolConstate.class);
        q.setParameter("actif", actif);
        return q;
    }
    
    public static TypedQuery<TypeHydrantVolConstate> TypeHydrantVolConstate.findTypeHydrantVolConstatesByCode(String code) {
        if (code == null || code.length() == 0) throw new IllegalArgumentException("The code argument is required");
        EntityManager em = TypeHydrantVolConstate.entityManager();
        TypedQuery<TypeHydrantVolConstate> q = em.createQuery("SELECT o FROM TypeHydrantVolConstate AS o WHERE o.code = :code", TypeHydrantVolConstate.class);
        q.setParameter("code", code);
        return q;
    }
    
    public static TypedQuery<TypeHydrantVolConstate> TypeHydrantVolConstate.findTypeHydrantVolConstatesByCode(String code, String sortFieldName, String sortOrder) {
        if (code == null || code.length() == 0) throw new IllegalArgumentException("The code argument is required");
        EntityManager em = TypeHydrantVolConstate.entityManager();
        String jpaQuery = "SELECT o FROM TypeHydrantVolConstate AS o WHERE o.code = :code";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<TypeHydrantVolConstate> q = em.createQuery(jpaQuery, TypeHydrantVolConstate.class);
        q.setParameter("code", code);
        return q;
    }
    
}
