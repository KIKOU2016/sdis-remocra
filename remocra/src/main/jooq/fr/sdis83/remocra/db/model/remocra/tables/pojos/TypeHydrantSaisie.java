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
public class TypeHydrantSaisie implements Serializable {

	private static final long serialVersionUID = 1754353596;

	private Long    id;
	private Boolean actif;
	private String  code;
	private String  nom;
	private Integer version;

	public TypeHydrantSaisie() {}

	public TypeHydrantSaisie(TypeHydrantSaisie value) {
		this.id = value.id;
		this.actif = value.actif;
		this.code = value.code;
		this.nom = value.nom;
		this.version = value.version;
	}

	public TypeHydrantSaisie(
		Long    id,
		Boolean actif,
		String  code,
		String  nom,
		Integer version
	) {
		this.id = id;
		this.actif = actif;
		this.code = code;
		this.nom = nom;
		this.version = version;
	}

	public Long getId() {
		return this.id;
	}

	public TypeHydrantSaisie setId(Long id) {
		this.id = id;
		return this;
	}

	public Boolean getActif() {
		return this.actif;
	}

	public TypeHydrantSaisie setActif(Boolean actif) {
		this.actif = actif;
		return this;
	}

	public String getCode() {
		return this.code;
	}

	public TypeHydrantSaisie setCode(String code) {
		this.code = code;
		return this;
	}

	public String getNom() {
		return this.nom;
	}

	public TypeHydrantSaisie setNom(String nom) {
		this.nom = nom;
		return this;
	}

	public Integer getVersion() {
		return this.version;
	}

	public TypeHydrantSaisie setVersion(Integer version) {
		this.version = version;
		return this;
	}
}
