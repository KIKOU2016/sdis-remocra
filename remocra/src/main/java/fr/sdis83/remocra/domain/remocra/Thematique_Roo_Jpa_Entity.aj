// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.Thematique;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;

privileged aspect Thematique_Roo_Jpa_Entity {
    
    declare @type: Thematique: @Entity;
    
    @Version
    @Column(name = "version")
    private Integer Thematique.version;
    
    public Integer Thematique.getVersion() {
        return this.version;
    }
    
    public void Thematique.setVersion(Integer version) {
        this.version = version;
    }
    
}
