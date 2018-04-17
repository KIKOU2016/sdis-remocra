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
public class DdeMdp implements Serializable {

	private static final long serialVersionUID = -1972860970;

	private Long    id;
	private String  code;
	private Instant dateDemande;
	private Long    utilisateur;

	public DdeMdp() {}

	public DdeMdp(DdeMdp value) {
		this.id = value.id;
		this.code = value.code;
		this.dateDemande = value.dateDemande;
		this.utilisateur = value.utilisateur;
	}

	public DdeMdp(
		Long    id,
		String  code,
		Instant dateDemande,
		Long    utilisateur
	) {
		this.id = id;
		this.code = code;
		this.dateDemande = dateDemande;
		this.utilisateur = utilisateur;
	}

	public Long getId() {
		return this.id;
	}

	public DdeMdp setId(Long id) {
		this.id = id;
		return this;
	}

	public String getCode() {
		return this.code;
	}

	public DdeMdp setCode(String code) {
		this.code = code;
		return this;
	}

	public Instant getDateDemande() {
		return this.dateDemande;
	}

	public DdeMdp setDateDemande(Instant dateDemande) {
		this.dateDemande = dateDemande;
		return this;
	}

	public Long getUtilisateur() {
		return this.utilisateur;
	}

	public DdeMdp setUtilisateur(Long utilisateur) {
		this.utilisateur = utilisateur;
		return this;
	}
}
