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
public class ModeleTraitementParametre implements Serializable {

	private static final long serialVersionUID = 134670450;

	private Integer idparametre;
	private String  formEtiquette;
	private Integer formNumOrdre;
	private Boolean formObligatoire;
	private String  formSourceDonnee;
	private String  formTypeValeur;
	private String  formValeurDefaut;
	private String  nom;
	private Integer idmodele;

	public ModeleTraitementParametre() {}

	public ModeleTraitementParametre(ModeleTraitementParametre value) {
		this.idparametre = value.idparametre;
		this.formEtiquette = value.formEtiquette;
		this.formNumOrdre = value.formNumOrdre;
		this.formObligatoire = value.formObligatoire;
		this.formSourceDonnee = value.formSourceDonnee;
		this.formTypeValeur = value.formTypeValeur;
		this.formValeurDefaut = value.formValeurDefaut;
		this.nom = value.nom;
		this.idmodele = value.idmodele;
	}

	public ModeleTraitementParametre(
		Integer idparametre,
		String  formEtiquette,
		Integer formNumOrdre,
		Boolean formObligatoire,
		String  formSourceDonnee,
		String  formTypeValeur,
		String  formValeurDefaut,
		String  nom,
		Integer idmodele
	) {
		this.idparametre = idparametre;
		this.formEtiquette = formEtiquette;
		this.formNumOrdre = formNumOrdre;
		this.formObligatoire = formObligatoire;
		this.formSourceDonnee = formSourceDonnee;
		this.formTypeValeur = formTypeValeur;
		this.formValeurDefaut = formValeurDefaut;
		this.nom = nom;
		this.idmodele = idmodele;
	}

	public Integer getIdparametre() {
		return this.idparametre;
	}

	public ModeleTraitementParametre setIdparametre(Integer idparametre) {
		this.idparametre = idparametre;
		return this;
	}

	public String getFormEtiquette() {
		return this.formEtiquette;
	}

	public ModeleTraitementParametre setFormEtiquette(String formEtiquette) {
		this.formEtiquette = formEtiquette;
		return this;
	}

	public Integer getFormNumOrdre() {
		return this.formNumOrdre;
	}

	public ModeleTraitementParametre setFormNumOrdre(Integer formNumOrdre) {
		this.formNumOrdre = formNumOrdre;
		return this;
	}

	public Boolean getFormObligatoire() {
		return this.formObligatoire;
	}

	public ModeleTraitementParametre setFormObligatoire(Boolean formObligatoire) {
		this.formObligatoire = formObligatoire;
		return this;
	}

	public String getFormSourceDonnee() {
		return this.formSourceDonnee;
	}

	public ModeleTraitementParametre setFormSourceDonnee(String formSourceDonnee) {
		this.formSourceDonnee = formSourceDonnee;
		return this;
	}

	public String getFormTypeValeur() {
		return this.formTypeValeur;
	}

	public ModeleTraitementParametre setFormTypeValeur(String formTypeValeur) {
		this.formTypeValeur = formTypeValeur;
		return this;
	}

	public String getFormValeurDefaut() {
		return this.formValeurDefaut;
	}

	public ModeleTraitementParametre setFormValeurDefaut(String formValeurDefaut) {
		this.formValeurDefaut = formValeurDefaut;
		return this;
	}

	public String getNom() {
		return this.nom;
	}

	public ModeleTraitementParametre setNom(String nom) {
		this.nom = nom;
		return this;
	}

	public Integer getIdmodele() {
		return this.idmodele;
	}

	public ModeleTraitementParametre setIdmodele(Integer idmodele) {
		this.idmodele = idmodele;
		return this;
	}
}
