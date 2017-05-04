// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.ExportModele;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ExportModele_Roo_Jpa_ActiveRecord {

    @PersistenceContext
    transient EntityManager ExportModele.entityManager;

    public static final List<String> ExportModele.fieldNames4OrderClauseFilter = java.util.Arrays.asList("id", "code", "libelle", "description", "sourceSql", "spatial");

    public static final EntityManager ExportModele.entityManager() {
        EntityManager em = new ExportModele().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

    public static long ExportModele.countExportModeles() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ExportModele o", Long.class).getSingleResult();
    }

    public static List<ExportModele> ExportModele.findAllExportModeles() {
        return entityManager().createQuery("SELECT o FROM ExportModele o", ExportModele.class).getResultList();
    }

    public static List<ExportModele> ExportModele.findAllExportModeles(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ExportModele o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ExportModele.class).getResultList();
    }

    public static ExportModele ExportModele.findExportModele(Long id) {
        if (id == null) return null;
        return entityManager().find(ExportModele.class, id);
    }

    public static List<ExportModele> ExportModele.findExportModeleEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ExportModele o", ExportModele.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    public static List<ExportModele> ExportModele.findExportModeleEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ExportModele o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ExportModele.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Transactional
    public void ExportModele.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }

    @Transactional
    public void ExportModele.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            ExportModele attached = ExportModele.findExportModele(this.id);
            this.entityManager.remove(attached);
        }
    }

    @Transactional
    public void ExportModele.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }

    @Transactional
    public void ExportModele.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }

    @Transactional
    public ExportModele ExportModele.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ExportModele merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

}