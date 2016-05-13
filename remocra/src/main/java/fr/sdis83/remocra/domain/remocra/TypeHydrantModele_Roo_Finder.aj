// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.TypeHydrantModele;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect TypeHydrantModele_Roo_Finder {
    
    public static Long TypeHydrantModele.countFindTypeHydrantModelesByActif(Boolean actif) {
        if (actif == null) throw new IllegalArgumentException("The actif argument is required");
        EntityManager em = TypeHydrantModele.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM TypeHydrantModele AS o WHERE o.actif = :actif", Long.class);
        q.setParameter("actif", actif);
        return ((Long) q.getSingleResult());
    }
    
    public static Long TypeHydrantModele.countFindTypeHydrantModelesByCode(String code) {
        if (code == null || code.length() == 0) throw new IllegalArgumentException("The code argument is required");
        EntityManager em = TypeHydrantModele.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM TypeHydrantModele AS o WHERE o.code = :code", Long.class);
        q.setParameter("code", code);
        return ((Long) q.getSingleResult());
    }
    
    public static TypedQuery<TypeHydrantModele> TypeHydrantModele.findTypeHydrantModelesByActif(Boolean actif) {
        if (actif == null) throw new IllegalArgumentException("The actif argument is required");
        EntityManager em = TypeHydrantModele.entityManager();
        TypedQuery<TypeHydrantModele> q = em.createQuery("SELECT o FROM TypeHydrantModele AS o WHERE o.actif = :actif", TypeHydrantModele.class);
        q.setParameter("actif", actif);
        return q;
    }
    
    public static TypedQuery<TypeHydrantModele> TypeHydrantModele.findTypeHydrantModelesByActif(Boolean actif, String sortFieldName, String sortOrder) {
        if (actif == null) throw new IllegalArgumentException("The actif argument is required");
        EntityManager em = TypeHydrantModele.entityManager();
        String jpaQuery = "SELECT o FROM TypeHydrantModele AS o WHERE o.actif = :actif";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<TypeHydrantModele> q = em.createQuery(jpaQuery, TypeHydrantModele.class);
        q.setParameter("actif", actif);
        return q;
    }
    
    public static TypedQuery<TypeHydrantModele> TypeHydrantModele.findTypeHydrantModelesByCode(String code) {
        if (code == null || code.length() == 0) throw new IllegalArgumentException("The code argument is required");
        EntityManager em = TypeHydrantModele.entityManager();
        TypedQuery<TypeHydrantModele> q = em.createQuery("SELECT o FROM TypeHydrantModele AS o WHERE o.code = :code", TypeHydrantModele.class);
        q.setParameter("code", code);
        return q;
    }
    
    public static TypedQuery<TypeHydrantModele> TypeHydrantModele.findTypeHydrantModelesByCode(String code, String sortFieldName, String sortOrder) {
        if (code == null || code.length() == 0) throw new IllegalArgumentException("The code argument is required");
        EntityManager em = TypeHydrantModele.entityManager();
        String jpaQuery = "SELECT o FROM TypeHydrantModele AS o WHERE o.code = :code";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<TypeHydrantModele> q = em.createQuery(jpaQuery, TypeHydrantModele.class);
        q.setParameter("code", code);
        return q;
    }
    
}
