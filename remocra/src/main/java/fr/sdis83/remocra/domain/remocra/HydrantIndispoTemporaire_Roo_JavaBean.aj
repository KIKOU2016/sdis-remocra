// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import java.util.Date;

import java.util.Set;
import fr.sdis83.remocra.domain.remocra.HydrantIndispoTemporaire;
import fr.sdis83.remocra.domain.remocra.Hydrant;

privileged aspect HydrantIndispoTemporaire_Roo_JavaBean {
    
    public Long HydrantIndispoTemporaire.getId() {
        return this.id;
    }
    
    public void HydrantIndispoTemporaire.setId(Long id) {
        this.id = id;
    }
    
    public Date HydrantIndispoTemporaire.getDateDebut() {
        return this.dateDebut;
    }
    
    public void HydrantIndispoTemporaire.setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date HydrantIndispoTemporaire.getDatePrevDebut() {
        return this.datePrevDebut;
    }

    public void HydrantIndispoTemporaire.setDatePrevDebut(Date datePrevDebut) {
        this.datePrevDebut = datePrevDebut;
    }

    public Date HydrantIndispoTemporaire.getDatePrevFin() {
        return this.datePrevFin;
    }

    public void HydrantIndispoTemporaire.setDatePrevFin(Date datePrevFin) {
        this.datePrevFin = datePrevFin;
    }

    public Date HydrantIndispoTemporaire.getDateFin() {
        return this.dateFin;
    }

    public void HydrantIndispoTemporaire.setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date HydrantIndispoTemporaire.getDateRappelDebut() {
        return this.dateRappelDebut;
    }

    public void HydrantIndispoTemporaire.setDateRappelDebut(Date dateRappelDebut) {
        this.dateRappelDebut = dateRappelDebut;
    }

    public Date HydrantIndispoTemporaire.getDateRappelFin() {
        return this.dateRappelFin;
    }

    public void HydrantIndispoTemporaire.setDateRappel(Date dateRappelFin) {
        this.dateRappelFin = dateRappelFin;
    }


    public String HydrantIndispoTemporaire.getMotif() {
        return this.motif;
    }

    public void HydrantIndispoTemporaire.setMotif(String motif) {
        this.motif = motif;
    }

    public Integer HydrantIndispoTemporaire.getTotalHydrants() {
        return totalHydrants;
    }

    public void HydrantIndispoTemporaire.setTotalHydrants(Integer totalHydrants) {
       this.totalHydrants = totalHydrants;
    }

    public TypeHydrantIndispoStatut HydrantIndispoTemporaire.getStatut() {
        return statut;
    }

    public void HydrantIndispoTemporaire.setStatut(TypeHydrantIndispoStatut statut) {
        this.statut = statut;
    }

    public Set<Hydrant> HydrantIndispoTemporaire.getHydrants() {
        return hydrants;
    }

    public void HydrantIndispoTemporaire.setHydrants(Set<Hydrant> hydrants) {
        this.hydrants = hydrants;
    }

}
