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
public class VueOrganismeCis implements Serializable {

	private static final long serialVersionUID = -38263554;

	private Long   id;
	private String libelle;
	private String tricol;

	public VueOrganismeCis() {}

	public VueOrganismeCis(VueOrganismeCis value) {
		this.id = value.id;
		this.libelle = value.libelle;
		this.tricol = value.tricol;
	}

	public VueOrganismeCis(
		Long   id,
		String libelle,
		String tricol
	) {
		this.id = id;
		this.libelle = libelle;
		this.tricol = tricol;
	}

	public Long getId() {
		return this.id;
	}

	public VueOrganismeCis setId(Long id) {
		this.id = id;
		return this;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public VueOrganismeCis setLibelle(String libelle) {
		this.libelle = libelle;
		return this;
	}

	public String getTricol() {
		return this.tricol;
	}

	public VueOrganismeCis setTricol(String tricol) {
		this.tricol = tricol;
		return this;
	}
}
