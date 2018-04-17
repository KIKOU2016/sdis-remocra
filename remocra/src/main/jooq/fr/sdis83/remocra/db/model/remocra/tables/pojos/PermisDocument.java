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
public class PermisDocument implements Serializable {

	private static final long serialVersionUID = 191083688;

	private Long id;
	private Long document;
	private Long permis;

	public PermisDocument() {}

	public PermisDocument(PermisDocument value) {
		this.id = value.id;
		this.document = value.document;
		this.permis = value.permis;
	}

	public PermisDocument(
		Long id,
		Long document,
		Long permis
	) {
		this.id = id;
		this.document = document;
		this.permis = permis;
	}

	public Long getId() {
		return this.id;
	}

	public PermisDocument setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getDocument() {
		return this.document;
	}

	public PermisDocument setDocument(Long document) {
		this.document = document;
		return this;
	}

	public Long getPermis() {
		return this.permis;
	}

	public PermisDocument setPermis(Long permis) {
		this.permis = permis;
		return this;
	}
}
