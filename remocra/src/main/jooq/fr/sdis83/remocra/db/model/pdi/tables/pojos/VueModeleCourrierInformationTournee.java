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
public class VueModeleCourrierInformationTournee implements Serializable {

	private static final long serialVersionUID = 995896377;

	private Long   id;
	private String libelle;

	public VueModeleCourrierInformationTournee() {}

	public VueModeleCourrierInformationTournee(VueModeleCourrierInformationTournee value) {
		this.id = value.id;
		this.libelle = value.libelle;
	}

	public VueModeleCourrierInformationTournee(
		Long   id,
		String libelle
	) {
		this.id = id;
		this.libelle = libelle;
	}

	public Long getId() {
		return this.id;
	}

	public VueModeleCourrierInformationTournee setId(Long id) {
		this.id = id;
		return this;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public VueModeleCourrierInformationTournee setLibelle(String libelle) {
		this.libelle = libelle;
		return this;
	}
}