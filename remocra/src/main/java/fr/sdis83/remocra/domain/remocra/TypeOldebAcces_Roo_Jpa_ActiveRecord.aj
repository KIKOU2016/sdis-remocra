// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

privileged aspect TypeOldebAcces_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager TypeOldebAcces.entityManager;
    
    public static final List<String> TypeOldebAcces.fieldNames4OrderClauseFilter = java.util.Arrays.asList("");
    
    public static final EntityManager TypeOldebAcces.entityManager() {
        EntityManager em = new TypeOldebAcces().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long TypeOldebAcces.countTypeOldebAcceses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM TypeOldebAcces o", Long.class).getSingleResult();
    }
    
    public static List<TypeOldebAcces> TypeOldebAcces.findAllTypeOldebAcceses() {
        return entityManager().createQuery("SELECT o FROM TypeOldebAcces o", TypeOldebAcces.class).getResultList();
    }
    
    public static List<TypeOldebAcces> TypeOldebAcces.findAllTypeOldebAcceses(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM TypeOldebAcces o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, TypeOldebAcces.class).getResultList();
    }
    
    public static TypeOldebAcces TypeOldebAcces.findTypeOldebAcces(Long id) {
        if (id == null) return null;
        return entityManager().find(TypeOldebAcces.class, id);
    }
    
    public static List<TypeOldebAcces> TypeOldebAcces.findTypeOldebAccesEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM TypeOldebAcces o", TypeOldebAcces.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<TypeOldebAcces> TypeOldebAcces.findTypeOldebAccesEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM TypeOldebAcces o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, TypeOldebAcces.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void TypeOldebAcces.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void TypeOldebAcces.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            TypeOldebAcces attached = TypeOldebAcces.findTypeOldebAcces(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void TypeOldebAcces.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void TypeOldebAcces.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public TypeOldebAcces TypeOldebAcces.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        TypeOldebAcces merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}