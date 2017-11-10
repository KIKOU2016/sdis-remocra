// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.CadastreParcelle;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect CadastreParcelle_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager CadastreParcelle.entityManager;
    
    public static final List<String> CadastreParcelle.fieldNames4OrderClauseFilter = java.util.Arrays.asList("");
    
    public static final EntityManager CadastreParcelle.entityManager() {
        EntityManager em = new CadastreParcelle().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long CadastreParcelle.countCadastreParcelles() {
        return entityManager().createQuery("SELECT COUNT(o) FROM CadastreParcelle o", Long.class).getSingleResult();
    }
    
    public static List<CadastreParcelle> CadastreParcelle.findAllCadastreParcelles() {
        return entityManager().createQuery("SELECT o FROM CadastreParcelle o", CadastreParcelle.class).getResultList();
    }
    
    public static List<CadastreParcelle> CadastreParcelle.findAllCadastreParcelles(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM CadastreParcelle o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, CadastreParcelle.class).getResultList();
    }
    
    public static CadastreParcelle CadastreParcelle.findCadastreParcelle(Long id) {
        if (id == null) return null;
        return entityManager().find(CadastreParcelle.class, id);
    }
    
    public static List<CadastreParcelle> CadastreParcelle.findCadastreParcelleEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM CadastreParcelle o", CadastreParcelle.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<CadastreParcelle> CadastreParcelle.findCadastreParcelleEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM CadastreParcelle o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, CadastreParcelle.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void CadastreParcelle.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void CadastreParcelle.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            CadastreParcelle attached = CadastreParcelle.findCadastreParcelle(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void CadastreParcelle.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void CadastreParcelle.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public CadastreParcelle CadastreParcelle.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        CadastreParcelle merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}