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
public class TypeHydrantAnomalieNatureSaisies implements Serializable {

	private static final long serialVersionUID = -2144628110;

	private Long typeHydrantAnomalieNature;
	private Long saisies;

	public TypeHydrantAnomalieNatureSaisies() {}

	public TypeHydrantAnomalieNatureSaisies(TypeHydrantAnomalieNatureSaisies value) {
		this.typeHydrantAnomalieNature = value.typeHydrantAnomalieNature;
		this.saisies = value.saisies;
	}

	public TypeHydrantAnomalieNatureSaisies(
		Long typeHydrantAnomalieNature,
		Long saisies
	) {
		this.typeHydrantAnomalieNature = typeHydrantAnomalieNature;
		this.saisies = saisies;
	}

	public Long getTypeHydrantAnomalieNature() {
		return this.typeHydrantAnomalieNature;
	}

	public TypeHydrantAnomalieNatureSaisies setTypeHydrantAnomalieNature(Long typeHydrantAnomalieNature) {
		this.typeHydrantAnomalieNature = typeHydrantAnomalieNature;
		return this;
	}

	public Long getSaisies() {
		return this.saisies;
	}

	public TypeHydrantAnomalieNatureSaisies setSaisies(Long saisies) {
		this.saisies = saisies;
		return this;
	}
}
