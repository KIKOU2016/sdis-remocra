// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import java.util.Set;

privileged aspect TypeOldebAction_Roo_JavaBean {

    public Long TypeOldebAction.getId() {
        return this.id;
    }

    public void TypeOldebAction.setId(Long id) {
        this.id = id;
    }

    public Set<OldebVisite> TypeOldebAction.getOldebVisites() {
        return oldebVisites;
    }

    public void TypeOldebAction.setOldebVisites(Set<OldebVisite> oldebVisites) {
        this.oldebVisites = oldebVisites;
    }

    public Boolean TypeOldebAction.getActif() {
        return actif;
    }

    public void TypeOldebAction.setActif(Boolean actif) {
        this.actif = actif;
    }

    public String TypeOldebAction.getCode() {
        return code;
    }

    public void TypeOldebAction.setCode(String code) {
        this.code = code;
    }

    public String TypeOldebAction.getNom() {
        return nom;
    }

    public void TypeOldebAction.setNom(String nom) {
        this.nom = nom;
    }

}