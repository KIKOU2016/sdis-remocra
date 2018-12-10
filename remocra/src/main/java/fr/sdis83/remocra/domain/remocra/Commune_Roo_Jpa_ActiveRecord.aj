// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.Commune;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Commune_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Commune.entityManager;
    
    public static final List<String> Commune.fieldNames4OrderClauseFilter = java.util.Arrays.asList("id", "insee", "nom", "geometrie", "pprif", "code", "bbox");
    
    public static final EntityManager Commune.entityManager() {
        EntityManager em = new Commune().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Commune.countCommunes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Commune o", Long.class).getSingleResult();
    }
    
    public static List<Commune> Commune.findAllCommunes() {
        return entityManager().createQuery("SELECT o FROM Commune o", Commune.class).getResultList();
    }
    
    public static List<Commune> Commune.findAllCommunes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Commune o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Commune.class).getResultList();
    }
    
    public static Commune Commune.findCommune(Long id) {
        if (id == null) return null;
        return entityManager().find(Commune.class, id);
    }
    
    public static List<Commune> Commune.findCommuneEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Commune o", Commune.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Commune> Commune.findCommuneEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Commune o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Commune.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Commune.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Commune.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Commune attached = Commune.findCommune(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Commune.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Commune.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Commune Commune.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Commune merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
