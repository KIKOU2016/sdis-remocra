// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import com.vividsolutions.jts.geom.Geometry;
import fr.sdis83.remocra.domain.remocra.Hydrant;
import fr.sdis83.remocra.domain.remocra.Organisme;
import fr.sdis83.remocra.domain.remocra.Tournee;
import fr.sdis83.remocra.domain.remocra.Utilisateur;
import java.util.Date;
import java.util.Set;

privileged aspect Tournee_Roo_JavaBean {
    
    public Long Tournee.getId() {
        return this.id;
    }
    
    public void Tournee.setId(Long id) {
        this.id = id;
    }
    
    public Integer Tournee.getVersion() {
        return this.version;
    }
    
    public void Tournee.setVersion(Integer version) {
        this.version = version;
    }
    
    public Date Tournee.getDebSync() {
        return this.debSync;
    }
    
    public void Tournee.setDebSync(Date debSync) {
        this.debSync = debSync;
    }
    
    public Date Tournee.getLastSync() {
        return this.lastSync;
    }
    
    public void Tournee.setLastSync(Date lastSync) {
        this.lastSync = lastSync;
    }
    
    public Geometry Tournee.getGeometrie() {
        return this.geometrie;
    }
    
    public void Tournee.setGeometrie(Geometry geometrie) {
        this.geometrie = geometrie;
    }
    
    public Organisme Tournee.getAffectation() {
        return this.affectation;
    }
    
    public void Tournee.setAffectation(Organisme affectation) {
        this.affectation = affectation;
    }
    
    public Utilisateur Tournee.getReservation() {
        return this.reservation;
    }
    
    public void Tournee.setReservation(Utilisateur reservation) {
        this.reservation = reservation;
    }
    
    public Set<Hydrant> Tournee.getHydrants() {
        return this.hydrants;
    }
    
    public void Tournee.setHydrants(Set<Hydrant> hydrants) {
        this.hydrants = hydrants;
    }
    
    public Integer Tournee.getHydrantCount() {
        return this.hydrantCount;
    }
    
    public void Tournee.setHydrantCount(Integer hydrantCount) {
        this.hydrantCount = hydrantCount;
    }
    
    public Integer Tournee.getEtat() {
        return this.etat;
    }
    
    public void Tournee.setEtat(Integer etat) {
        this.etat = etat;
    }
    
}
