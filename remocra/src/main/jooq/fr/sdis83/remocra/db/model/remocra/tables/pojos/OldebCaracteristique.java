/**
 * This class is generated by jOOQ
 */
package fr.sdis83.remocra.db.model.remocra.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * Caractéristique liée à une parcelle soumise à une obligation légale de 
 * débroussaillement
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OldebCaracteristique implements Serializable {

	private static final long serialVersionUID = 723734618;

	private Long oldeb;
	private Long caracteristique;

	public OldebCaracteristique() {}

	public OldebCaracteristique(OldebCaracteristique value) {
		this.oldeb = value.oldeb;
		this.caracteristique = value.caracteristique;
	}

	public OldebCaracteristique(
		Long oldeb,
		Long caracteristique
	) {
		this.oldeb = oldeb;
		this.caracteristique = caracteristique;
	}

	public Long getOldeb() {
		return this.oldeb;
	}

	public OldebCaracteristique setOldeb(Long oldeb) {
		this.oldeb = oldeb;
		return this;
	}

	public Long getCaracteristique() {
		return this.caracteristique;
	}

	public OldebCaracteristique setCaracteristique(Long caracteristique) {
		this.caracteristique = caracteristique;
		return this;
	}
}
