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
public class VueUtilisateurs implements Serializable {

	private static final long serialVersionUID = -957755006;

	private Long   id;
	private String libelle;

	public VueUtilisateurs() {}

	public VueUtilisateurs(VueUtilisateurs value) {
		this.id = value.id;
		this.libelle = value.libelle;
	}

	public VueUtilisateurs(
		Long   id,
		String libelle
	) {
		this.id = id;
		this.libelle = libelle;
	}

	public Long getId() {
		return this.id;
	}

	public VueUtilisateurs setId(Long id) {
		this.id = id;
		return this;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public VueUtilisateurs setLibelle(String libelle) {
		this.libelle = libelle;
		return this;
	}
}
