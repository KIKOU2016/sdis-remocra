// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.Metadonnee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Metadonnee_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Metadonnee.entityManager;
    
    public static final List<String> Metadonnee.fieldNames4OrderClauseFilter = java.util.Arrays.asList("id", "titre", "resume", "urlVignette", "urlFiche", "thematique");
    
    public static final EntityManager Metadonnee.entityManager() {
        EntityManager em = new Metadonnee().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Metadonnee.countMetadonnees() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Metadonnee o", Long.class).getSingleResult();
    }
    
    public static List<Metadonnee> Metadonnee.findAllMetadonnees() {
        return entityManager().createQuery("SELECT o FROM Metadonnee o", Metadonnee.class).getResultList();
    }
    
    public static List<Metadonnee> Metadonnee.findAllMetadonnees(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Metadonnee o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Metadonnee.class).getResultList();
    }
    
    public static Metadonnee Metadonnee.findMetadonnee(Long id) {
        if (id == null) return null;
        return entityManager().find(Metadonnee.class, id);
    }
    
    public static List<Metadonnee> Metadonnee.findMetadonneeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Metadonnee o", Metadonnee.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Metadonnee> Metadonnee.findMetadonneeEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Metadonnee o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Metadonnee.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Metadonnee.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Metadonnee.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Metadonnee attached = Metadonnee.findMetadonnee(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Metadonnee.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Metadonnee.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Metadonnee Metadonnee.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Metadonnee merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
