// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.pdi;

import fr.sdis83.remocra.domain.pdi.TraitementCc;
import fr.sdis83.remocra.domain.pdi.TraitementCcPK;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect TraitementCc_Roo_Jpa_Entity {
    
    declare @type: TraitementCc: @Entity;
    
    declare @type: TraitementCc: @Table(schema = "pdi", name = "traitement_cc");
    
    @EmbeddedId
    private TraitementCcPK TraitementCc.id;
    
    public TraitementCcPK TraitementCc.getId() {
        return this.id;
    }
    
    public void TraitementCc.setId(TraitementCcPK id) {
        this.id = id;
    }
    
}
