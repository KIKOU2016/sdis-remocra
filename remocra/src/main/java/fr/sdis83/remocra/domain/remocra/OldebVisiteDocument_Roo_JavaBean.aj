// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package main.java.fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.Document;
import fr.sdis83.remocra.domain.remocra.OldebVisite;
import fr.sdis83.remocra.domain.remocra.OldebVisiteDocument;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

privileged aspect OldebVisiteDocument_Roo_JavaBean {
   
    
    public Long OldebVisiteDocument.getId() {
        return this.id;
    }
    
    public void OldebVisiteDocument.setId(Long id) {
        this.id = id;
    }
    
    public Document OldebVisiteDocument.getDocument() {
        return document;
    }
    
    public void OldebVisiteDocument.setDocument(Document document) {
        this.document = document;
    }
    
    public OldebVisite OldebVisiteDocument.getVisite() {
        return visite;
    }
    
    public void OldebVisiteDocument.setVisite(OldebVisite visite) {
        this.visite = visite;
    }
    
}