// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.BlocDocument;
import fr.sdis83.remocra.domain.remocra.Document;
import fr.sdis83.remocra.domain.remocra.ProfilDroit;
import fr.sdis83.remocra.domain.remocra.Thematique;
import java.util.Date;
import java.util.Set;

privileged aspect BlocDocument_Roo_JavaBean {
    
    public Long BlocDocument.getId() {
        return this.id;
    }
    
    public void BlocDocument.setId(Long id) {
        this.id = id;
    }
    
    public Document BlocDocument.getDocument() {
        return this.document;
    }
    
    public void BlocDocument.setDocument(Document document) {
        this.document = document;
    }
    
    public Set<Thematique> BlocDocument.getThematiques() {
        return this.thematiques;
    }
    
    public void BlocDocument.setThematiques(Set<Thematique> thematiques) {
        this.thematiques = thematiques;
    }
    
    public Set<ProfilDroit> BlocDocument.getProfilDroits() {
        return this.profilDroits;
    }
    
    public void BlocDocument.setProfilDroits(Set<ProfilDroit> profilDroits) {
        this.profilDroits = profilDroits;
    }
    
    public String BlocDocument.getTitre() {
        return this.titre;
    }
    
    public void BlocDocument.setTitre(String titre) {
        this.titre = titre;
    }
    
    public String BlocDocument.getDescription() {
        return this.description;
    }
    
    public void BlocDocument.setDescription(String description) {
        this.description = description;
    }
    
    public void BlocDocument.setDateDoc(Date dateDoc) {
        this.dateDoc = dateDoc;
    }
    
}
