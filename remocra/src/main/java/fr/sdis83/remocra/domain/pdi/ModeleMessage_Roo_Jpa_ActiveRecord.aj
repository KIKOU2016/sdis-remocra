// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.pdi;

import fr.sdis83.remocra.domain.pdi.ModeleMessage;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ModeleMessage_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager ModeleMessage.entityManager;
    
    public static final List<String> ModeleMessage.fieldNames4OrderClauseFilter = java.util.Arrays.asList("modeleTraitements", "modeleTraitements1");
    
    public static final EntityManager ModeleMessage.entityManager() {
        EntityManager em = new ModeleMessage().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long ModeleMessage.countModeleMessages() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ModeleMessage o", Long.class).getSingleResult();
    }
    
    public static List<ModeleMessage> ModeleMessage.findAllModeleMessages() {
        return entityManager().createQuery("SELECT o FROM ModeleMessage o", ModeleMessage.class).getResultList();
    }
    
    public static List<ModeleMessage> ModeleMessage.findAllModeleMessages(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ModeleMessage o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ModeleMessage.class).getResultList();
    }
    
    public static ModeleMessage ModeleMessage.findModeleMessage(Integer idmodele) {
        if (idmodele == null) return null;
        return entityManager().find(ModeleMessage.class, idmodele);
    }
    
    public static List<ModeleMessage> ModeleMessage.findModeleMessageEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ModeleMessage o", ModeleMessage.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<ModeleMessage> ModeleMessage.findModeleMessageEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ModeleMessage o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ModeleMessage.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void ModeleMessage.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void ModeleMessage.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            ModeleMessage attached = ModeleMessage.findModeleMessage(this.idmodele);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void ModeleMessage.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void ModeleMessage.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public ModeleMessage ModeleMessage.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ModeleMessage merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
