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
public class ZoneCompetence implements Serializable {

	private static final long serialVersionUID = -1335749603;

	private Long   id;
	private String code;
	private Object geometrie;
	private String nom;

	public ZoneCompetence() {}

	public ZoneCompetence(ZoneCompetence value) {
		this.id = value.id;
		this.code = value.code;
		this.geometrie = value.geometrie;
		this.nom = value.nom;
	}

	public ZoneCompetence(
		Long   id,
		String code,
		Object geometrie,
		String nom
	) {
		this.id = id;
		this.code = code;
		this.geometrie = geometrie;
		this.nom = nom;
	}

	public Long getId() {
		return this.id;
	}

	public ZoneCompetence setId(Long id) {
		this.id = id;
		return this;
	}

	public String getCode() {
		return this.code;
	}

	public ZoneCompetence setCode(String code) {
		this.code = code;
		return this;
	}

	public Object getGeometrie() {
		return this.geometrie;
	}

	public ZoneCompetence setGeometrie(Object geometrie) {
		this.geometrie = geometrie;
		return this;
	}

	public String getNom() {
		return this.nom;
	}

	public ZoneCompetence setNom(String nom) {
		this.nom = nom;
		return this;
	}
}
