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
public class ExportModele implements Serializable {

	private static final long serialVersionUID = 1922958392;

	private Long    id;
	private String  categorie;
	private String  code;
	private String  libelle;
	private String  description;
	private Boolean spatial;
	private String  sourceSql;

	public ExportModele() {}

	public ExportModele(ExportModele value) {
		this.id = value.id;
		this.categorie = value.categorie;
		this.code = value.code;
		this.libelle = value.libelle;
		this.description = value.description;
		this.spatial = value.spatial;
		this.sourceSql = value.sourceSql;
	}

	public ExportModele(
		Long    id,
		String  categorie,
		String  code,
		String  libelle,
		String  description,
		Boolean spatial,
		String  sourceSql
	) {
		this.id = id;
		this.categorie = categorie;
		this.code = code;
		this.libelle = libelle;
		this.description = description;
		this.spatial = spatial;
		this.sourceSql = sourceSql;
	}

	public Long getId() {
		return this.id;
	}

	public ExportModele setId(Long id) {
		this.id = id;
		return this;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public ExportModele setCategorie(String categorie) {
		this.categorie = categorie;
		return this;
	}

	public String getCode() {
		return this.code;
	}

	public ExportModele setCode(String code) {
		this.code = code;
		return this;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public ExportModele setLibelle(String libelle) {
		this.libelle = libelle;
		return this;
	}

	public String getDescription() {
		return this.description;
	}

	public ExportModele setDescription(String description) {
		this.description = description;
		return this;
	}

	public Boolean getSpatial() {
		return this.spatial;
	}

	public ExportModele setSpatial(Boolean spatial) {
		this.spatial = spatial;
		return this;
	}

	public String getSourceSql() {
		return this.sourceSql;
	}

	public ExportModele setSourceSql(String sourceSql) {
		this.sourceSql = sourceSql;
		return this;
	}
}