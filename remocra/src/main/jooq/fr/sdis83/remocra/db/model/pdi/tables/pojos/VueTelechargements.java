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
public class VueTelechargements implements Serializable {

	private static final long serialVersionUID = 2109867320;

	private Integer idtraitement;
	private String  code;
	private String  ressource;

	public VueTelechargements() {}

	public VueTelechargements(VueTelechargements value) {
		this.idtraitement = value.idtraitement;
		this.code = value.code;
		this.ressource = value.ressource;
	}

	public VueTelechargements(
		Integer idtraitement,
		String  code,
		String  ressource
	) {
		this.idtraitement = idtraitement;
		this.code = code;
		this.ressource = ressource;
	}

	public Integer getIdtraitement() {
		return this.idtraitement;
	}

	public VueTelechargements setIdtraitement(Integer idtraitement) {
		this.idtraitement = idtraitement;
		return this;
	}

	public String getCode() {
		return this.code;
	}

	public VueTelechargements setCode(String code) {
		this.code = code;
		return this;
	}

	public String getRessource() {
		return this.ressource;
	}

	public VueTelechargements setRessource(String ressource) {
		this.ressource = ressource;
		return this;
	}
}
