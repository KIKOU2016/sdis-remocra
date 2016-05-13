// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.Organisme;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Organisme_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Organisme.entityManager;
    
    public static final List<String> Organisme.fieldNames4OrderClauseFilter = java.util.Arrays.asList("id", "version", "code", "nom", "emailContact", "actif", "typeOrganisme", "profilOrganisme", "zoneCompetence");
    
    public static final EntityManager Organisme.entityManager() {
        EntityManager em = new Organisme().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Organisme.countOrganismes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Organisme o", Long.class).getSingleResult();
    }
    
    public static List<Organisme> Organisme.findAllOrganismes() {
        return entityManager().createQuery("SELECT o FROM Organisme o", Organisme.class).getResultList();
    }
    
    public static List<Organisme> Organisme.findAllOrganismes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Organisme o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Organisme.class).getResultList();
    }
    
    public static Organisme Organisme.findOrganisme(Long id) {
        if (id == null) return null;
        return entityManager().find(Organisme.class, id);
    }
    
    public static List<Organisme> Organisme.findOrganismeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Organisme o", Organisme.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Organisme> Organisme.findOrganismeEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Organisme o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Organisme.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Organisme.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Organisme.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Organisme attached = Organisme.findOrganisme(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Organisme.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Organisme.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Organisme Organisme.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Organisme merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
