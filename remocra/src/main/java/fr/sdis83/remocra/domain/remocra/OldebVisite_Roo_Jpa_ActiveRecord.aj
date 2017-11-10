// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.OldebVisite;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect OldebVisite_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager OldebVisite.entityManager;
    
    public static final List<String> OldebVisite.fieldNames4OrderClauseFilter = java.util.Arrays.asList("");
    
    public static final EntityManager OldebVisite.entityManager() {
        EntityManager em = new OldebVisite().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long OldebVisite.countOldebVisites() {
        return entityManager().createQuery("SELECT COUNT(o) FROM OldebVisite o", Long.class).getSingleResult();
    }
    
    public static List<OldebVisite> OldebVisite.findAllOldebVisites() {
        return entityManager().createQuery("SELECT o FROM OldebVisite o", OldebVisite.class).getResultList();
    }
    
    public static List<OldebVisite> OldebVisite.findAllOldebVisites(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM OldebVisite o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, OldebVisite.class).getResultList();
    }
    
    public static OldebVisite OldebVisite.findOldebVisite(Long id) {
        if (id == null) return null;
        return entityManager().find(OldebVisite.class, id);
    }
    
    public static List<OldebVisite> OldebVisite.findOldebVisiteEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM OldebVisite o", OldebVisite.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<OldebVisite> OldebVisite.findOldebVisiteEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM OldebVisite o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, OldebVisite.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void OldebVisite.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void OldebVisite.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            OldebVisite attached = OldebVisite.findOldebVisite(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void OldebVisite.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void OldebVisite.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public OldebVisite OldebVisite.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        OldebVisite merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}