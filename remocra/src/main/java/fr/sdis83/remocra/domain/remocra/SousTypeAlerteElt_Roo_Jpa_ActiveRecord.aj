// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.SousTypeAlerteElt;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect SousTypeAlerteElt_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager SousTypeAlerteElt.entityManager;
    
    public static final List<String> SousTypeAlerteElt.fieldNames4OrderClauseFilter = java.util.Arrays.asList("id", "nom", "code", "actif", "typeAlerteElt", "typeGeom");
    
    public static final EntityManager SousTypeAlerteElt.entityManager() {
        EntityManager em = new SousTypeAlerteElt().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long SousTypeAlerteElt.countSousTypeAlerteElts() {
        return entityManager().createQuery("SELECT COUNT(o) FROM SousTypeAlerteElt o", Long.class).getSingleResult();
    }
    
    public static List<SousTypeAlerteElt> SousTypeAlerteElt.findAllSousTypeAlerteElts() {
        return entityManager().createQuery("SELECT o FROM SousTypeAlerteElt o", SousTypeAlerteElt.class).getResultList();
    }
    
    public static List<SousTypeAlerteElt> SousTypeAlerteElt.findAllSousTypeAlerteElts(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM SousTypeAlerteElt o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, SousTypeAlerteElt.class).getResultList();
    }
    
    public static SousTypeAlerteElt SousTypeAlerteElt.findSousTypeAlerteElt(Long id) {
        if (id == null) return null;
        return entityManager().find(SousTypeAlerteElt.class, id);
    }
    
    public static List<SousTypeAlerteElt> SousTypeAlerteElt.findSousTypeAlerteEltEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM SousTypeAlerteElt o", SousTypeAlerteElt.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<SousTypeAlerteElt> SousTypeAlerteElt.findSousTypeAlerteEltEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM SousTypeAlerteElt o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, SousTypeAlerteElt.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void SousTypeAlerteElt.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void SousTypeAlerteElt.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            SousTypeAlerteElt attached = SousTypeAlerteElt.findSousTypeAlerteElt(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void SousTypeAlerteElt.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void SousTypeAlerteElt.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public SousTypeAlerteElt SousTypeAlerteElt.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        SousTypeAlerteElt merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
