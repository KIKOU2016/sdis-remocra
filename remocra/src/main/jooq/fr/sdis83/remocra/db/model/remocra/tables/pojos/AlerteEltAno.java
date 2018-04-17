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
public class AlerteEltAno implements Serializable {

	private static final long serialVersionUID = 1267257734;

	private Long    id;
	private Integer version;
	private Long    alerteElt;
	private Long    typeAlerteAno;

	public AlerteEltAno() {}

	public AlerteEltAno(AlerteEltAno value) {
		this.id = value.id;
		this.version = value.version;
		this.alerteElt = value.alerteElt;
		this.typeAlerteAno = value.typeAlerteAno;
	}

	public AlerteEltAno(
		Long    id,
		Integer version,
		Long    alerteElt,
		Long    typeAlerteAno
	) {
		this.id = id;
		this.version = version;
		this.alerteElt = alerteElt;
		this.typeAlerteAno = typeAlerteAno;
	}

	public Long getId() {
		return this.id;
	}

	public AlerteEltAno setId(Long id) {
		this.id = id;
		return this;
	}

	public Integer getVersion() {
		return this.version;
	}

	public AlerteEltAno setVersion(Integer version) {
		this.version = version;
		return this;
	}

	public Long getAlerteElt() {
		return this.alerteElt;
	}

	public AlerteEltAno setAlerteElt(Long alerteElt) {
		this.alerteElt = alerteElt;
		return this;
	}

	public Long getTypeAlerteAno() {
		return this.typeAlerteAno;
	}

	public AlerteEltAno setTypeAlerteAno(Long typeAlerteAno) {
		this.typeAlerteAno = typeAlerteAno;
		return this;
	}
}
