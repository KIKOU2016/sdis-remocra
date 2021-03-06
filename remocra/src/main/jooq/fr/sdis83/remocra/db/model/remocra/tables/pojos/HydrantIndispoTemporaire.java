/**
 * This class is generated by jOOQ
 */
package fr.sdis83.remocra.db.model.remocra.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;

import org.joda.time.Instant;


/**
 * Indisponibilié temporaire d'hydrant
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class HydrantIndispoTemporaire implements Serializable {

	private static final long serialVersionUID = -1762605138;

	private Long    id;
	private Instant datePrevDebut;
	private Instant datePrevFin;
	private Instant dateDebut;
	private Instant dateFin;
	private String  motif;
	private Instant dateRappelDebut;
	private Instant dateRappelFin;
	private Long    statut;
	private Integer totalHydrants;

	public HydrantIndispoTemporaire() {}

	public HydrantIndispoTemporaire(HydrantIndispoTemporaire value) {
		this.id = value.id;
		this.datePrevDebut = value.datePrevDebut;
		this.datePrevFin = value.datePrevFin;
		this.dateDebut = value.dateDebut;
		this.dateFin = value.dateFin;
		this.motif = value.motif;
		this.dateRappelDebut = value.dateRappelDebut;
		this.dateRappelFin = value.dateRappelFin;
		this.statut = value.statut;
		this.totalHydrants = value.totalHydrants;
	}

	public HydrantIndispoTemporaire(
		Long    id,
		Instant datePrevDebut,
		Instant datePrevFin,
		Instant dateDebut,
		Instant dateFin,
		String  motif,
		Instant dateRappelDebut,
		Instant dateRappelFin,
		Long    statut,
		Integer totalHydrants
	) {
		this.id = id;
		this.datePrevDebut = datePrevDebut;
		this.datePrevFin = datePrevFin;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.motif = motif;
		this.dateRappelDebut = dateRappelDebut;
		this.dateRappelFin = dateRappelFin;
		this.statut = statut;
		this.totalHydrants = totalHydrants;
	}

	public Long getId() {
		return this.id;
	}

	public HydrantIndispoTemporaire setId(Long id) {
		this.id = id;
		return this;
	}

	public Instant getDatePrevDebut() {
		return this.datePrevDebut;
	}

	public HydrantIndispoTemporaire setDatePrevDebut(Instant datePrevDebut) {
		this.datePrevDebut = datePrevDebut;
		return this;
	}

	public Instant getDatePrevFin() {
		return this.datePrevFin;
	}

	public HydrantIndispoTemporaire setDatePrevFin(Instant datePrevFin) {
		this.datePrevFin = datePrevFin;
		return this;
	}

	public Instant getDateDebut() {
		return this.dateDebut;
	}

	public HydrantIndispoTemporaire setDateDebut(Instant dateDebut) {
		this.dateDebut = dateDebut;
		return this;
	}

	public Instant getDateFin() {
		return this.dateFin;
	}

	public HydrantIndispoTemporaire setDateFin(Instant dateFin) {
		this.dateFin = dateFin;
		return this;
	}

	public String getMotif() {
		return this.motif;
	}

	public HydrantIndispoTemporaire setMotif(String motif) {
		this.motif = motif;
		return this;
	}

	public Instant getDateRappelDebut() {
		return this.dateRappelDebut;
	}

	public HydrantIndispoTemporaire setDateRappelDebut(Instant dateRappelDebut) {
		this.dateRappelDebut = dateRappelDebut;
		return this;
	}

	public Instant getDateRappelFin() {
		return this.dateRappelFin;
	}

	public HydrantIndispoTemporaire setDateRappelFin(Instant dateRappelFin) {
		this.dateRappelFin = dateRappelFin;
		return this;
	}

	public Long getStatut() {
		return this.statut;
	}

	public HydrantIndispoTemporaire setStatut(Long statut) {
		this.statut = statut;
		return this;
	}

	public Integer getTotalHydrants() {
		return this.totalHydrants;
	}

	public HydrantIndispoTemporaire setTotalHydrants(Integer totalHydrants) {
		this.totalHydrants = totalHydrants;
		return this;
	}
}
