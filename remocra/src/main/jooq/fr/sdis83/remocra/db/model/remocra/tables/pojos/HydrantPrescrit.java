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
public class HydrantPrescrit implements Serializable {

	private static final long serialVersionUID = 610890920;

	private Long    id;
	private Instant datePrescrit;
	private Integer debit;
	private Object  geometrie;
	private Integer nbPoteaux;
	private Long    organisme;

	public HydrantPrescrit() {}

	public HydrantPrescrit(HydrantPrescrit value) {
		this.id = value.id;
		this.datePrescrit = value.datePrescrit;
		this.debit = value.debit;
		this.geometrie = value.geometrie;
		this.nbPoteaux = value.nbPoteaux;
		this.organisme = value.organisme;
	}

	public HydrantPrescrit(
		Long    id,
		Instant datePrescrit,
		Integer debit,
		Object  geometrie,
		Integer nbPoteaux,
		Long    organisme
	) {
		this.id = id;
		this.datePrescrit = datePrescrit;
		this.debit = debit;
		this.geometrie = geometrie;
		this.nbPoteaux = nbPoteaux;
		this.organisme = organisme;
	}

	public Long getId() {
		return this.id;
	}

	public HydrantPrescrit setId(Long id) {
		this.id = id;
		return this;
	}

	public Instant getDatePrescrit() {
		return this.datePrescrit;
	}

	public HydrantPrescrit setDatePrescrit(Instant datePrescrit) {
		this.datePrescrit = datePrescrit;
		return this;
	}

	public Integer getDebit() {
		return this.debit;
	}

	public HydrantPrescrit setDebit(Integer debit) {
		this.debit = debit;
		return this;
	}

	public Object getGeometrie() {
		return this.geometrie;
	}

	public HydrantPrescrit setGeometrie(Object geometrie) {
		this.geometrie = geometrie;
		return this;
	}

	public Integer getNbPoteaux() {
		return this.nbPoteaux;
	}

	public HydrantPrescrit setNbPoteaux(Integer nbPoteaux) {
		this.nbPoteaux = nbPoteaux;
		return this;
	}

	public Long getOrganisme() {
		return this.organisme;
	}

	public HydrantPrescrit setOrganisme(Long organisme) {
		this.organisme = organisme;
		return this;
	}
}
