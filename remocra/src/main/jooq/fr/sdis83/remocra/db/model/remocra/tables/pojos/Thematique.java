/**
 * This class is generated by jOOQ
 */
package fr.sdis83.remocra.db.model.remocra.tables.pojos;


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
public class Thematique implements Serializable {

	private static final long serialVersionUID = 1331377582;

	private Long    id;
	private String  nom;
	private Integer version;
	private Boolean actif;
	private String  code;

	public Thematique() {}

	public Thematique(Thematique value) {
		this.id = value.id;
		this.nom = value.nom;
		this.version = value.version;
		this.actif = value.actif;
		this.code = value.code;
	}

	public Thematique(
		Long    id,
		String  nom,
		Integer version,
		Boolean actif,
		String  code
	) {
		this.id = id;
		this.nom = nom;
		this.version = version;
		this.actif = actif;
		this.code = code;
	}

	public Long getId() {
		return this.id;
	}

	public Thematique setId(Long id) {
		this.id = id;
		return this;
	}

	public String getNom() {
		return this.nom;
	}

	public Thematique setNom(String nom) {
		this.nom = nom;
		return this;
	}

	public Integer getVersion() {
		return this.version;
	}

	public Thematique setVersion(Integer version) {
		this.version = version;
		return this;
	}

	public Boolean getActif() {
		return this.actif;
	}

	public Thematique setActif(Boolean actif) {
		this.actif = actif;
		return this;
	}

	public String getCode() {
		return this.code;
	}

	public Thematique setCode(String code) {
		this.code = code;
		return this;
	}
}
