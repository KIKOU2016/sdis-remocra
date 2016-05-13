// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.Utilisateur;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Utilisateur_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Utilisateur.entityManager;
    
    public static final List<String> Utilisateur.fieldNames4OrderClauseFilter = java.util.Arrays.asList("ROLE_SDIS_USER", "version", "id", "organisme", "nom", "prenom", "telephone", "email", "identifiant", "password", "salt", "messageRemocra", "profilUtilisateur", "actif");
    
    public static final EntityManager Utilisateur.entityManager() {
        EntityManager em = new Utilisateur().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Utilisateur.countUtilisateurs() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Utilisateur o", Long.class).getSingleResult();
    }
    
    public static List<Utilisateur> Utilisateur.findAllUtilisateurs() {
        return entityManager().createQuery("SELECT o FROM Utilisateur o", Utilisateur.class).getResultList();
    }
    
    public static List<Utilisateur> Utilisateur.findAllUtilisateurs(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Utilisateur o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Utilisateur.class).getResultList();
    }
    
    public static Utilisateur Utilisateur.findUtilisateur(Long id) {
        if (id == null) return null;
        return entityManager().find(Utilisateur.class, id);
    }
    
    public static List<Utilisateur> Utilisateur.findUtilisateurEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Utilisateur o", Utilisateur.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Utilisateur> Utilisateur.findUtilisateurEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Utilisateur o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Utilisateur.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Utilisateur.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Utilisateur.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Utilisateur attached = Utilisateur.findUtilisateur(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Utilisateur.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Utilisateur.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Utilisateur Utilisateur.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Utilisateur merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
