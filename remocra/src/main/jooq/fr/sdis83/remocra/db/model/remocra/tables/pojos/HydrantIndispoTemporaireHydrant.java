/**
 * This class is generated by jOOQ
 */
package fr.sdis83.remocra.db.model.remocra.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * Indisponibilité temporaire lié à un hydrant
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class HydrantIndispoTemporaireHydrant implements Serializable {

	private static final long serialVersionUID = -607678940;

	private Long indisponibilite;
	private Long hydrant;

	public HydrantIndispoTemporaireHydrant() {}

	public HydrantIndispoTemporaireHydrant(HydrantIndispoTemporaireHydrant value) {
		this.indisponibilite = value.indisponibilite;
		this.hydrant = value.hydrant;
	}

	public HydrantIndispoTemporaireHydrant(
		Long indisponibilite,
		Long hydrant
	) {
		this.indisponibilite = indisponibilite;
		this.hydrant = hydrant;
	}

	public Long getIndisponibilite() {
		return this.indisponibilite;
	}

	public HydrantIndispoTemporaireHydrant setIndisponibilite(Long indisponibilite) {
		this.indisponibilite = indisponibilite;
		return this;
	}

	public Long getHydrant() {
		return this.hydrant;
	}

	public HydrantIndispoTemporaireHydrant setHydrant(Long hydrant) {
		this.hydrant = hydrant;
		return this;
	}
}
