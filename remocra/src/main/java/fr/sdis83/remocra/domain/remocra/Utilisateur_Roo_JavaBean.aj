// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.Organisme;
import fr.sdis83.remocra.domain.remocra.ProfilUtilisateur;
import fr.sdis83.remocra.domain.remocra.Utilisateur;

privileged aspect Utilisateur_Roo_JavaBean {
    
    public Integer Utilisateur.getVersion() {
        return this.version;
    }
    
    public void Utilisateur.setVersion(Integer version) {
        this.version = version;
    }
    
    public Long Utilisateur.getId() {
        return this.id;
    }
    
    public void Utilisateur.setId(Long id) {
        this.id = id;
    }
    
    public Organisme Utilisateur.getOrganisme() {
        return this.organisme;
    }
    
    public void Utilisateur.setOrganisme(Organisme organisme) {
        this.organisme = organisme;
    }
    
    public String Utilisateur.getNom() {
        return this.nom;
    }
    
    public void Utilisateur.setNom(String nom) {
        this.nom = nom;
    }
    
    public String Utilisateur.getPrenom() {
        return this.prenom;
    }
    
    public void Utilisateur.setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String Utilisateur.getTelephone() {
        return this.telephone;
    }
    
    public void Utilisateur.setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public String Utilisateur.getEmail() {
        return this.email;
    }
    
    public void Utilisateur.setEmail(String email) {
        this.email = email;
    }
    
    public String Utilisateur.getIdentifiant() {
        return this.identifiant;
    }
    
    public void Utilisateur.setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
    
    public String Utilisateur.getPassword() {
        return this.password;
    }
    
    public void Utilisateur.setPassword(String password) {
        this.password = password;
    }
    
    public String Utilisateur.getSalt() {
        return this.salt;
    }
    
    public void Utilisateur.setSalt(String salt) {
        this.salt = salt;
    }
    
    public boolean Utilisateur.isMessageRemocra() {
        return this.messageRemocra;
    }
    
    public void Utilisateur.setMessageRemocra(boolean messageRemocra) {
        this.messageRemocra = messageRemocra;
    }
    
    public ProfilUtilisateur Utilisateur.getProfilUtilisateur() {
        return this.profilUtilisateur;
    }
    
    public void Utilisateur.setProfilUtilisateur(ProfilUtilisateur profilUtilisateur) {
        this.profilUtilisateur = profilUtilisateur;
    }
    
    public Boolean Utilisateur.getActif() {
        return this.actif;
    }
    
    public void Utilisateur.setActif(Boolean actif) {
        this.actif = actif;
    }
    
}
