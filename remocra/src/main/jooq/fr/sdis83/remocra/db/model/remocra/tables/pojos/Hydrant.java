/**
 * This class is generated by jOOQ
 */
package fr.sdis83.remocra.db.model.remocra.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;

import org.joda.time.Instant;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Hydrant implements Serializable {

	private static final long serialVersionUID = 1475253742;

	private Long    id;
	private String  agent1;
	private String  agent2;
	private Integer anneeFabrication;
	private String  code;
	private String  complement;
	private Instant dateContr;
	private Instant dateRecep;
	private Instant dateReco;
	private Instant dateVerif;
	private String  dispoAdmin;
	private String  dispoHbe;
	private String  dispoTerrestre;
	private Object  geometrie;
	private String  lieuDit;
	private String  numero;
	private Integer numeroInterne;
	private String  observation;
	private Integer version;
	private String  voie;
	private String  voie2;
	private Long    commune;
	private Long    domaine;
	private Long    nature;
	private Long    tournee;
	private Instant dateModification;
	private String  courrier;
	private String  gestPointEau;
	private Long    organisme;
	private Instant dateGps;
	private Long    zoneSpeciale;
	private Instant dateAttestation;
	private Long    utilisateurModification;

	public Hydrant() {}

	public Hydrant(Hydrant value) {
		this.id = value.id;
		this.agent1 = value.agent1;
		this.agent2 = value.agent2;
		this.anneeFabrication = value.anneeFabrication;
		this.code = value.code;
		this.complement = value.complement;
		this.dateContr = value.dateContr;
		this.dateRecep = value.dateRecep;
		this.dateReco = value.dateReco;
		this.dateVerif = value.dateVerif;
		this.dispoAdmin = value.dispoAdmin;
		this.dispoHbe = value.dispoHbe;
		this.dispoTerrestre = value.dispoTerrestre;
		this.geometrie = value.geometrie;
		this.lieuDit = value.lieuDit;
		this.numero = value.numero;
		this.numeroInterne = value.numeroInterne;
		this.observation = value.observation;
		this.version = value.version;
		this.voie = value.voie;
		this.voie2 = value.voie2;
		this.commune = value.commune;
		this.domaine = value.domaine;
		this.nature = value.nature;
		this.tournee = value.tournee;
		this.dateModification = value.dateModification;
		this.courrier = value.courrier;
		this.gestPointEau = value.gestPointEau;
		this.organisme = value.organisme;
		this.dateGps = value.dateGps;
		this.zoneSpeciale = value.zoneSpeciale;
		this.dateAttestation = value.dateAttestation;
		this.utilisateurModification = value.utilisateurModification;
	}

	public Hydrant(
		Long    id,
		String  agent1,
		String  agent2,
		Integer anneeFabrication,
		String  code,
		String  complement,
		Instant dateContr,
		Instant dateRecep,
		Instant dateReco,
		Instant dateVerif,
		String  dispoAdmin,
		String  dispoHbe,
		String  dispoTerrestre,
		Object  geometrie,
		String  lieuDit,
		String  numero,
		Integer numeroInterne,
		String  observation,
		Integer version,
		String  voie,
		String  voie2,
		Long    commune,
		Long    domaine,
		Long    nature,
		Long    tournee,
		Instant dateModification,
		String  courrier,
		String  gestPointEau,
		Long    organisme,
		Instant dateGps,
		Long    zoneSpeciale,
		Instant dateAttestation,
		Long    utilisateurModification
	) {
		this.id = id;
		this.agent1 = agent1;
		this.agent2 = agent2;
		this.anneeFabrication = anneeFabrication;
		this.code = code;
		this.complement = complement;
		this.dateContr = dateContr;
		this.dateRecep = dateRecep;
		this.dateReco = dateReco;
		this.dateVerif = dateVerif;
		this.dispoAdmin = dispoAdmin;
		this.dispoHbe = dispoHbe;
		this.dispoTerrestre = dispoTerrestre;
		this.geometrie = geometrie;
		this.lieuDit = lieuDit;
		this.numero = numero;
		this.numeroInterne = numeroInterne;
		this.observation = observation;
		this.version = version;
		this.voie = voie;
		this.voie2 = voie2;
		this.commune = commune;
		this.domaine = domaine;
		this.nature = nature;
		this.tournee = tournee;
		this.dateModification = dateModification;
		this.courrier = courrier;
		this.gestPointEau = gestPointEau;
		this.organisme = organisme;
		this.dateGps = dateGps;
		this.zoneSpeciale = zoneSpeciale;
		this.dateAttestation = dateAttestation;
		this.utilisateurModification = utilisateurModification;
	}

	public Long getId() {
		return this.id;
	}

	public Hydrant setId(Long id) {
		this.id = id;
		return this;
	}

	public String getAgent1() {
		return this.agent1;
	}

	public Hydrant setAgent1(String agent1) {
		this.agent1 = agent1;
		return this;
	}

	public String getAgent2() {
		return this.agent2;
	}

	public Hydrant setAgent2(String agent2) {
		this.agent2 = agent2;
		return this;
	}

	public Integer getAnneeFabrication() {
		return this.anneeFabrication;
	}

	public Hydrant setAnneeFabrication(Integer anneeFabrication) {
		this.anneeFabrication = anneeFabrication;
		return this;
	}

	public String getCode() {
		return this.code;
	}

	public Hydrant setCode(String code) {
		this.code = code;
		return this;
	}

	public String getComplement() {
		return this.complement;
	}

	public Hydrant setComplement(String complement) {
		this.complement = complement;
		return this;
	}

	public Instant getDateContr() {
		return this.dateContr;
	}

	public Hydrant setDateContr(Instant dateContr) {
		this.dateContr = dateContr;
		return this;
	}

	public Instant getDateRecep() {
		return this.dateRecep;
	}

	public Hydrant setDateRecep(Instant dateRecep) {
		this.dateRecep = dateRecep;
		return this;
	}

	public Instant getDateReco() {
		return this.dateReco;
	}

	public Hydrant setDateReco(Instant dateReco) {
		this.dateReco = dateReco;
		return this;
	}

	public Instant getDateVerif() {
		return this.dateVerif;
	}

	public Hydrant setDateVerif(Instant dateVerif) {
		this.dateVerif = dateVerif;
		return this;
	}

	public String getDispoAdmin() {
		return this.dispoAdmin;
	}

	public Hydrant setDispoAdmin(String dispoAdmin) {
		this.dispoAdmin = dispoAdmin;
		return this;
	}

	public String getDispoHbe() {
		return this.dispoHbe;
	}

	public Hydrant setDispoHbe(String dispoHbe) {
		this.dispoHbe = dispoHbe;
		return this;
	}

	public String getDispoTerrestre() {
		return this.dispoTerrestre;
	}

	public Hydrant setDispoTerrestre(String dispoTerrestre) {
		this.dispoTerrestre = dispoTerrestre;
		return this;
	}

	public Object getGeometrie() {
		return this.geometrie;
	}

	public Hydrant setGeometrie(Object geometrie) {
		this.geometrie = geometrie;
		return this;
	}

	public String getLieuDit() {
		return this.lieuDit;
	}

	public Hydrant setLieuDit(String lieuDit) {
		this.lieuDit = lieuDit;
		return this;
	}

	public String getNumero() {
		return this.numero;
	}

	public Hydrant setNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public Integer getNumeroInterne() {
		return this.numeroInterne;
	}

	public Hydrant setNumeroInterne(Integer numeroInterne) {
		this.numeroInterne = numeroInterne;
		return this;
	}

	public String getObservation() {
		return this.observation;
	}

	public Hydrant setObservation(String observation) {
		this.observation = observation;
		return this;
	}

	public Integer getVersion() {
		return this.version;
	}

	public Hydrant setVersion(Integer version) {
		this.version = version;
		return this;
	}

	public String getVoie() {
		return this.voie;
	}

	public Hydrant setVoie(String voie) {
		this.voie = voie;
		return this;
	}

	public String getVoie2() {
		return this.voie2;
	}

	public Hydrant setVoie2(String voie2) {
		this.voie2 = voie2;
		return this;
	}

	public Long getCommune() {
		return this.commune;
	}

	public Hydrant setCommune(Long commune) {
		this.commune = commune;
		return this;
	}

	public Long getDomaine() {
		return this.domaine;
	}

	public Hydrant setDomaine(Long domaine) {
		this.domaine = domaine;
		return this;
	}

	public Long getNature() {
		return this.nature;
	}

	public Hydrant setNature(Long nature) {
		this.nature = nature;
		return this;
	}

	public Long getTournee() {
		return this.tournee;
	}

	public Hydrant setTournee(Long tournee) {
		this.tournee = tournee;
		return this;
	}

	public Instant getDateModification() {
		return this.dateModification;
	}

	public Hydrant setDateModification(Instant dateModification) {
		this.dateModification = dateModification;
		return this;
	}

	public String getCourrier() {
		return this.courrier;
	}

	public Hydrant setCourrier(String courrier) {
		this.courrier = courrier;
		return this;
	}

	public String getGestPointEau() {
		return this.gestPointEau;
	}

	public Hydrant setGestPointEau(String gestPointEau) {
		this.gestPointEau = gestPointEau;
		return this;
	}

	public Long getOrganisme() {
		return this.organisme;
	}

	public Hydrant setOrganisme(Long organisme) {
		this.organisme = organisme;
		return this;
	}

	public Instant getDateGps() {
		return this.dateGps;
	}

	public Hydrant setDateGps(Instant dateGps) {
		this.dateGps = dateGps;
		return this;
	}

	public Long getZoneSpeciale() {
		return this.zoneSpeciale;
	}

	public Hydrant setZoneSpeciale(Long zoneSpeciale) {
		this.zoneSpeciale = zoneSpeciale;
		return this;
	}

	public Instant getDateAttestation() {
		return this.dateAttestation;
	}

	public Hydrant setDateAttestation(Instant dateAttestation) {
		this.dateAttestation = dateAttestation;
		return this;
	}

	public Long getUtilisateurModification() {
		return this.utilisateurModification;
	}

	public Hydrant setUtilisateurModification(Long utilisateurModification) {
		this.utilisateurModification = utilisateurModification;
		return this;
	}
}
