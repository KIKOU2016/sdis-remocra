// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import java.util.Set;

privileged aspect TypeOldebCategorieAnomalie_Roo_JavaBean {

    public Long TypeOldebCategorieAnomalie.getId() {
        return this.id;
    }

    public void TypeOldebCategorieAnomalie.setId(Long id) {
        this.id = id;
    }

    public Set<TypeOldebAnomalie> TypeOldebCategorieAnomalie.getTypeOldebAnomalies() {
        return typeOldebAnomalies;
    }

    public void TypeOldebCategorieAnomalie.setTypeOldebAnomalies(Set<TypeOldebAnomalie> typeOldebAnomalies) {
        this.typeOldebAnomalies = typeOldebAnomalies;
    }

    public Boolean TypeOldebCategorieAnomalie.getActif() {
        return actif;
    }

    public void TypeOldebCategorieAnomalie.setActif(Boolean actif) {
        this.actif = actif;
    }

    public String TypeOldebCategorieAnomalie.getCode() {
        return code;
    }

    public void TypeOldebCategorieAnomalie.setCode(String code) {
        this.code = code;
    }

    public String TypeOldebCategorieAnomalie.getNom() {
        return nom;
    }

    public void TypeOldebCategorieAnomalie.setNom(String nom) {
        this.nom = nom;
    }

}
