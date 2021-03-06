// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.TypeHydrant;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect TypeHydrant_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager TypeHydrant.entityManager;
    
    public static final List<String> TypeHydrant.fieldNames4OrderClauseFilter = java.util.Arrays.asList("id", "version", "nom", "code", "actif");
    
    public static final EntityManager TypeHydrant.entityManager() {
        EntityManager em = new TypeHydrant().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long TypeHydrant.countTypeHydrants() {
        return entityManager().createQuery("SELECT COUNT(o) FROM TypeHydrant o", Long.class).getSingleResult();
    }
    
    public static List<TypeHydrant> TypeHydrant.findAllTypeHydrants() {
        return entityManager().createQuery("SELECT o FROM TypeHydrant o", TypeHydrant.class).getResultList();
    }
    
    public static List<TypeHydrant> TypeHydrant.findAllTypeHydrants(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM TypeHydrant o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, TypeHydrant.class).getResultList();
    }
    
    public static TypeHydrant TypeHydrant.findTypeHydrant(Long id) {
        if (id == null) return null;
        return entityManager().find(TypeHydrant.class, id);
    }
    
    public static List<TypeHydrant> TypeHydrant.findTypeHydrantEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM TypeHydrant o", TypeHydrant.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<TypeHydrant> TypeHydrant.findTypeHydrantEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM TypeHydrant o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, TypeHydrant.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void TypeHydrant.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void TypeHydrant.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            TypeHydrant attached = TypeHydrant.findTypeHydrant(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void TypeHydrant.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void TypeHydrant.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public TypeHydrant TypeHydrant.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        TypeHydrant merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
