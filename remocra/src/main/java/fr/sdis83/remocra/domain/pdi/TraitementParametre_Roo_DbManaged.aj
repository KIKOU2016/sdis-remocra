// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.pdi;

import fr.sdis83.remocra.domain.pdi.ModeleTraitementParametre;
import fr.sdis83.remocra.domain.pdi.Traitement;
import fr.sdis83.remocra.domain.pdi.TraitementParametre;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

privileged aspect TraitementParametre_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "idparametre", referencedColumnName = "idparametre", nullable = false, insertable = false, updatable = false)
    private ModeleTraitementParametre TraitementParametre.idparametre;
    
    @ManyToOne
    @JoinColumn(name = "idtraitement", referencedColumnName = "idtraitement", nullable = false, insertable = false, updatable = false)
    private Traitement TraitementParametre.idtraitement;
    
    @Column(name = "valeur")
    @NotNull
    private String TraitementParametre.valeur;
    
    public ModeleTraitementParametre TraitementParametre.getIdparametre() {
        return idparametre;
    }
    
    public void TraitementParametre.setIdparametre(ModeleTraitementParametre idparametre) {
        this.idparametre = idparametre;
    }
    
    public Traitement TraitementParametre.getIdtraitement() {
        return idtraitement;
    }
    
    public void TraitementParametre.setIdtraitement(Traitement idtraitement) {
        this.idtraitement = idtraitement;
    }
    
    public String TraitementParametre.getValeur() {
        return valeur;
    }
    
    public void TraitementParametre.setValeur(String valeur) {
        this.valeur = valeur;
    }
    
}
