// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.pdi;

import fr.sdis83.remocra.domain.pdi.Telechargement;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect Telechargement_Roo_Jpa_Entity {
    
    declare @type: Telechargement: @Entity;
    
    declare @type: Telechargement: @Table(schema = "pdi", name = "vue_telechargements");
    
}
