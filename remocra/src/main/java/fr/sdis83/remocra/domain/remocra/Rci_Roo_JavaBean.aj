// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import com.vividsolutions.jts.geom.Point;
import fr.sdis83.remocra.domain.remocra.Commune;
import fr.sdis83.remocra.domain.remocra.Rci;
import fr.sdis83.remocra.domain.remocra.RciDocument;
import fr.sdis83.remocra.domain.remocra.TypeRciDegreCertitude;
import fr.sdis83.remocra.domain.remocra.TypeRciOrigineAlerte;
import fr.sdis83.remocra.domain.remocra.TypeRciPromCategorie;
import fr.sdis83.remocra.domain.remocra.TypeRciPromFamille;
import fr.sdis83.remocra.domain.remocra.TypeRciPromPartition;
import fr.sdis83.remocra.domain.remocra.Utilisateur;
import java.util.Date;
import java.util.Set;

privileged aspect Rci_Roo_JavaBean {
    
    public Long Rci.getId() {
        return this.id;
    }
    
    public void Rci.setId(Long id) {
        this.id = id;
    }
    
    public Date Rci.getDateModification() {
        return this.dateModification;
    }
    
    public void Rci.setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }
    
    public Utilisateur Rci.getUtilisateur() {
        return this.utilisateur;
    }
    
    public void Rci.setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    public Date Rci.getDateIncendie() {
        return this.dateIncendie;
    }
    
    public void Rci.setDateIncendie(Date dateIncendie) {
        this.dateIncendie = dateIncendie;
    }
    
    public TypeRciOrigineAlerte Rci.getOrigineAlerte() {
        return this.origineAlerte;
    }
    
    public void Rci.setOrigineAlerte(TypeRciOrigineAlerte origineAlerte) {
        this.origineAlerte = origineAlerte;
    }
    
    public Commune Rci.getCommune() {
        return this.commune;
    }
    
    public void Rci.setCommune(Commune commune) {
        this.commune = commune;
    }
    
    public String Rci.getVoie() {
        return this.voie;
    }
    
    public void Rci.setVoie(String voie) {
        this.voie = voie;
    }
    
    public String Rci.getComplement() {
        return this.complement;
    }
    
    public void Rci.setComplement(String complement) {
        this.complement = complement;
    }
    
    public Point Rci.getGeometrie() {
        return this.geometrie;
    }
    
    public void Rci.setGeometrie(Point geometrie) {
        this.geometrie = geometrie;
    }
    
    public String Rci.getJsonGeometrie() {
        return this.jsonGeometrie;
    }
    
    public void Rci.setJsonGeometrie(String jsonGeometrie) {
        this.jsonGeometrie = jsonGeometrie;
    }
    
    public String Rci.getCoordDFCI() {
        return this.coordDFCI;
    }
    
    public void Rci.setCoordDFCI(String coordDFCI) {
        this.coordDFCI = coordDFCI;
    }
    
    public Utilisateur Rci.getArriveeDdtmOnf() {
        return this.arriveeDdtmOnf;
    }
    
    public void Rci.setArriveeDdtmOnf(Utilisateur arriveeDdtmOnf) {
        this.arriveeDdtmOnf = arriveeDdtmOnf;
    }
    
    public Utilisateur Rci.getArriveeSdis() {
        return this.arriveeSdis;
    }
    
    public void Rci.setArriveeSdis(Utilisateur arriveeSdis) {
        this.arriveeSdis = arriveeSdis;
    }
    
    public Utilisateur Rci.getArriveeGendarmerie() {
        return this.arriveeGendarmerie;
    }
    
    public void Rci.setArriveeGendarmerie(Utilisateur arriveeGendarmerie) {
        this.arriveeGendarmerie = arriveeGendarmerie;
    }
    
    public Utilisateur Rci.getArriveePolice() {
        return this.arriveePolice;
    }
    
    public void Rci.setArriveePolice(Utilisateur arriveePolice) {
        this.arriveePolice = arriveePolice;
    }
    
    public String Rci.getPointEclosion() {
        return this.pointEclosion;
    }
    
    public void Rci.setPointEclosion(String pointEclosion) {
        this.pointEclosion = pointEclosion;
    }
    
    public Date Rci.getGdh() {
        return this.gdh;
    }
    
    public void Rci.setGdh(Date gdh) {
        this.gdh = gdh;
    }
    
    public Boolean Rci.getVentLocal() {
        return this.ventLocal;
    }
    
    public void Rci.setVentLocal(Boolean ventLocal) {
        this.ventLocal = ventLocal;
    }
    
    public Integer Rci.getHygrometrie() {
        return this.hygrometrie;
    }
    
    public void Rci.setHygrometrie(Integer hygrometrie) {
        this.hygrometrie = hygrometrie;
    }
    
    public DirectionVent Rci.getDirectionVent() {
        return this.directionVent;
    }
    
    public void Rci.setDirectionVent(DirectionVent directionVent) {
        this.directionVent = directionVent;
    }
    
    public Double Rci.getTemperature() {
        return this.temperature;
    }
    
    public void Rci.setTemperature(Double temperature) {
        this.temperature = temperature;
    }
    
    public Integer Rci.getForceVent() {
        return this.forceVent;
    }
    
    public void Rci.setForceVent(Integer forceVent) {
        this.forceVent = forceVent;
    }
    
    public Integer Rci.getIndiceRothermel() {
        return this.indiceRothermel;
    }
    
    public void Rci.setIndiceRothermel(Integer indiceRothermel) {
        this.indiceRothermel = indiceRothermel;
    }
    
    public Double Rci.getSuperficieSecours() {
        return this.superficieSecours;
    }
    
    public void Rci.setSuperficieSecours(Double superficieSecours) {
        this.superficieSecours = superficieSecours;
    }
    
    public Double Rci.getSuperficieReferent() {
        return this.superficieReferent;
    }
    
    public void Rci.setSuperficieReferent(Double superficieReferent) {
        this.superficieReferent = superficieReferent;
    }
    
    public Double Rci.getSuperficieFinale() {
        return this.superficieFinale;
    }
    
    public void Rci.setSuperficieFinale(Double superficieFinale) {
        this.superficieFinale = superficieFinale;
    }
    
    public String Rci.getPremierEngin() {
        return this.premierEngin;
    }
    
    public void Rci.setPremierEngin(String premierEngin) {
        this.premierEngin = premierEngin;
    }
    
    public String Rci.getPremierCos() {
        return this.premierCos;
    }
    
    public void Rci.setPremierCos(String premierCos) {
        this.premierCos = premierCos;
    }
    
    public String Rci.getForcesOrdre() {
        return this.forcesOrdre;
    }
    
    public void Rci.setForcesOrdre(String forcesOrdre) {
        this.forcesOrdre = forcesOrdre;
    }
    
    public Boolean Rci.getGelLieux() {
        return this.gelLieux;
    }
    
    public void Rci.setGelLieux(Boolean gelLieux) {
        this.gelLieux = gelLieux;
    }
    
    public TypeRciPromCategorie Rci.getCategoriePromethee() {
        return this.categoriePromethee;
    }
    
    public void Rci.setCategoriePromethee(TypeRciPromCategorie categoriePromethee) {
        this.categoriePromethee = categoriePromethee;
    }
    
    public TypeRciPromPartition Rci.getPartitionPromethee() {
        return this.partitionPromethee;
    }
    
    public void Rci.setPartitionPromethee(TypeRciPromPartition partitionPromethee) {
        this.partitionPromethee = partitionPromethee;
    }
    
    public TypeRciPromFamille Rci.getFamillePromethee() {
        return this.famillePromethee;
    }
    
    public void Rci.setFamillePromethee(TypeRciPromFamille famillePromethee) {
        this.famillePromethee = famillePromethee;
    }
    
    public TypeRciDegreCertitude Rci.getDegreCertitude() {
        return this.degreCertitude;
    }
    
    public void Rci.setDegreCertitude(TypeRciDegreCertitude degreCertitude) {
        this.degreCertitude = degreCertitude;
    }
    
    public String Rci.getCommentaireConclusions() {
        return this.commentaireConclusions;
    }
    
    public void Rci.setCommentaireConclusions(String commentaireConclusions) {
        this.commentaireConclusions = commentaireConclusions;
    }
    
    public Set<RciDocument> Rci.getRciDocuments() {
        return this.rciDocuments;
    }
    
    public void Rci.setRciDocuments(Set<RciDocument> rciDocuments) {
        this.rciDocuments = rciDocuments;
    }
    
}
