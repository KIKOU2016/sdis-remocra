// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import java.util.Date;
import java.util.Set;

privileged aspect OldebVisite_Roo_JavaBean {

    public Set<TypeOldebAnomalie> OldebVisite.getTypeOldebAnomalies() {
        return typeOldebAnomalies;
    }

    public void OldebVisite.setTypeOldebAnomalies(Set<TypeOldebAnomalie> typeOldebAnomalies) {
        this.typeOldebAnomalies = typeOldebAnomalies;
    }

    public Set<OldebVisiteDocument> OldebVisite.getOldebVisiteDocuments() {
        return oldebVisiteDocuments;
    }

    public void OldebVisite.setOldebVisiteDocuments(Set<OldebVisiteDocument> oldebVisiteDocuments) {
        this.oldebVisiteDocuments = oldebVisiteDocuments;
    }

    public Set<OldebVisiteSuite> OldebVisite.getOldebVisiteSuites() {
        return oldebVisiteSuites;
    }

    public void OldebVisite.setOldebVisiteSuites(Set<OldebVisiteSuite> oldebVisiteSuites) {
        this.oldebVisiteSuites = oldebVisiteSuites;
    }

    public Oldeb OldebVisite.getOldeb() {
        return oldeb;
    }

    public void OldebVisite.setOldeb(Oldeb oldeb) {
        this.oldeb = oldeb;
    }

    public TypeOldebAction OldebVisite.getAction() {
        return action;
    }

    public void OldebVisite.setAction(TypeOldebAction action) {
        this.action = action;
    }

    public TypeOldebAvis OldebVisite.getAvis() {
        return avis;
    }

    public void OldebVisite.setAvis(TypeOldebAvis avis) {
        this.avis = avis;
    }

    public TypeOldebDebroussaillement OldebVisite.getDebroussaillementParcelle() {
        return debroussaillementParcelle;
    }

    public void OldebVisite.setDebroussaillementParcelle(TypeOldebDebroussaillement debroussaillementParcelle) {
        this.debroussaillementParcelle = debroussaillementParcelle;
    }

    public TypeOldebDebroussaillement OldebVisite.getDebroussaillementAcces() {
        return debroussaillementAcces;
    }

    public void OldebVisite.setDebroussaillementAcces(TypeOldebDebroussaillement debroussaillementAcces) {
        this.debroussaillementAcces = debroussaillementAcces;
    }

    public Utilisateur OldebVisite.getUtilisateur() {
        return utilisateur;
    }

    public void OldebVisite.setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Date OldebVisite.getDateVisite() {
        return dateVisite;
    }

    public void OldebVisite.setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }

    public String OldebVisite.getAgent() {
        return agent;
    }

    public void OldebVisite.setAgent(String agent) {
        this.agent = agent;
    }

    public String OldebVisite.getObservation() {
        return observation;
    }

    public void OldebVisite.setObservation(String observation) {
        this.observation = observation;
    }

    public Long OldebVisite.getId() {
        return this.id;
    }

    public void OldebVisite.setId(Long id) {
        this.id = id;
    }
    
    public String OldebVisite.getCode() {
        return this.code;
    }

    public void OldebVisite.setCode(String code) {
        this.code = code;
    }
    
    public String OldebVisite.getNomAvis() {
        return nomAvis;
    }
    
    public String OldebVisite.getNomAction() {
        return nomAction;
    }
    
    public String OldebVisite.getNomDebAcces() {
        return nomDebAcces;
    }
    
    public String OldebVisite.getNomDebParcelle() {
        return nomDebParcelle;
    }
    
    public String OldebVisite.getTotalAnomalies() {
        return totalAnomalies;
    }
}
