/**
 * This class is generated by jOOQ
 */
package fr.sdis83.remocra.db.model.remocra.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;

import org.joda.time.Instant;


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
public class SuiviPatches implements Serializable {

	private static final long serialVersionUID = -1271003494;

	private Long    numero;
	private String  description;
	private Instant application;

	public SuiviPatches() {}

	public SuiviPatches(SuiviPatches value) {
		this.numero = value.numero;
		this.description = value.description;
		this.application = value.application;
	}

	public SuiviPatches(
		Long    numero,
		String  description,
		Instant application
	) {
		this.numero = numero;
		this.description = description;
		this.application = application;
	}

	public Long getNumero() {
		return this.numero;
	}

	public SuiviPatches setNumero(Long numero) {
		this.numero = numero;
		return this;
	}

	public String getDescription() {
		return this.description;
	}

	public SuiviPatches setDescription(String description) {
		this.description = description;
		return this;
	}

	public Instant getApplication() {
		return this.application;
	}

	public SuiviPatches setApplication(Instant application) {
		this.application = application;
		return this;
	}
}
