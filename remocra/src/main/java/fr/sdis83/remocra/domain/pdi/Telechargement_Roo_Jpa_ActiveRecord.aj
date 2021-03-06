// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.pdi;

import fr.sdis83.remocra.domain.pdi.Telechargement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Telechargement_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Telechargement.entityManager;
    
    public static final List<String> Telechargement.fieldNames4OrderClauseFilter = java.util.Arrays.asList("idtraitement", "code", "ressource");
    
    public static final EntityManager Telechargement.entityManager() {
        EntityManager em = new Telechargement().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Telechargement.countTelechargements() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Telechargement o", Long.class).getSingleResult();
    }
    
    public static List<Telechargement> Telechargement.findAllTelechargements() {
        return entityManager().createQuery("SELECT o FROM Telechargement o", Telechargement.class).getResultList();
    }
    
    public static List<Telechargement> Telechargement.findAllTelechargements(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Telechargement o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Telechargement.class).getResultList();
    }
    
    public static Telechargement Telechargement.findTelechargement(Integer idtraitement) {
        if (idtraitement == null) return null;
        return entityManager().find(Telechargement.class, idtraitement);
    }
    
    public static List<Telechargement> Telechargement.findTelechargementEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Telechargement o", Telechargement.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Telechargement> Telechargement.findTelechargementEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Telechargement o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Telechargement.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Telechargement.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Telechargement.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Telechargement attached = Telechargement.findTelechargement(this.idtraitement);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Telechargement.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Telechargement.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Telechargement Telechargement.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Telechargement merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
