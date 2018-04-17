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
public class TypeRciPromCategorie implements Serializable {

	private static final long serialVersionUID = 174587595;

	private Long    id;
	private Boolean actif;
	private String  code;
	private String  nom;
	private Integer version;
	private Long    partition;

	public TypeRciPromCategorie() {}

	public TypeRciPromCategorie(TypeRciPromCategorie value) {
		this.id = value.id;
		this.actif = value.actif;
		this.code = value.code;
		this.nom = value.nom;
		this.version = value.version;
		this.partition = value.partition;
	}

	public TypeRciPromCategorie(
		Long    id,
		Boolean actif,
		String  code,
		String  nom,
		Integer version,
		Long    partition
	) {
		this.id = id;
		this.actif = actif;
		this.code = code;
		this.nom = nom;
		this.version = version;
		this.partition = partition;
	}

	public Long getId() {
		return this.id;
	}

	public TypeRciPromCategorie setId(Long id) {
		this.id = id;
		return this;
	}

	public Boolean getActif() {
		return this.actif;
	}

	public TypeRciPromCategorie setActif(Boolean actif) {
		this.actif = actif;
		return this;
	}

	public String getCode() {
		return this.code;
	}

	public TypeRciPromCategorie setCode(String code) {
		this.code = code;
		return this;
	}

	public String getNom() {
		return this.nom;
	}

	public TypeRciPromCategorie setNom(String nom) {
		this.nom = nom;
		return this;
	}

	public Integer getVersion() {
		return this.version;
	}

	public TypeRciPromCategorie setVersion(Integer version) {
		this.version = version;
		return this;
	}

	public Long getPartition() {
		return this.partition;
	}

	public TypeRciPromCategorie setPartition(Long partition) {
		this.partition = partition;
		return this;
	}
}
