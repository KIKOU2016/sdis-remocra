// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.CadastreSection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect CadastreSection_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager CadastreSection.entityManager;
    
    public static final List<String> CadastreSection.fieldNames4OrderClauseFilter = java.util.Arrays.asList("");
    
    public static final EntityManager CadastreSection.entityManager() {
        EntityManager em = new CadastreSection().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long CadastreSection.countCadastreSections() {
        return entityManager().createQuery("SELECT COUNT(o) FROM CadastreSection o", Long.class).getSingleResult();
    }
    
    public static List<CadastreSection> CadastreSection.findAllCadastreSections() {
        return entityManager().createQuery("SELECT o FROM CadastreSection o", CadastreSection.class).getResultList();
    }
    
    public static List<CadastreSection> CadastreSection.findAllCadastreSections(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM CadastreSection o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, CadastreSection.class).getResultList();
    }
    
    public static CadastreSection CadastreSection.findCadastreSection(Long id) {
        if (id == null) return null;
        return entityManager().find(CadastreSection.class, id);
    }
    
    public static List<CadastreSection> CadastreSection.findCadastreSectionEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM CadastreSection o", CadastreSection.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<CadastreSection> CadastreSection.findCadastreSectionEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM CadastreSection o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, CadastreSection.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void CadastreSection.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void CadastreSection.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            CadastreSection attached = CadastreSection.findCadastreSection(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void CadastreSection.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void CadastreSection.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public CadastreSection CadastreSection.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        CadastreSection merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
