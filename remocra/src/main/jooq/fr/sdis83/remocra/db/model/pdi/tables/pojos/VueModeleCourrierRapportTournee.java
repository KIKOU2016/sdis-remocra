/**
 * This class is generated by jOOQ
 */
package fr.sdis83.remocra.db.model.pdi.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


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
public class VueModeleCourrierRapportTournee implements Serializable {

	private static final long serialVersionUID = 953714075;

	private Long   id;
	private String libelle;

	public VueModeleCourrierRapportTournee() {}

	public VueModeleCourrierRapportTournee(VueModeleCourrierRapportTournee value) {
		this.id = value.id;
		this.libelle = value.libelle;
	}

	public VueModeleCourrierRapportTournee(
		Long   id,
		String libelle
	) {
		this.id = id;
		this.libelle = libelle;
	}

	public Long getId() {
		return this.id;
	}

	public VueModeleCourrierRapportTournee setId(Long id) {
		this.id = id;
		return this;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public VueModeleCourrierRapportTournee setLibelle(String libelle) {
		this.libelle = libelle;
		return this;
	}
}
