/**
 * This class is generated by jOOQ
 */
package fr.sdis83.remocra.db.model.pdi;


import fr.sdis83.remocra.db.model.pdi.tables.ModeleMessage;
import fr.sdis83.remocra.db.model.pdi.tables.ModeleTraitement;
import fr.sdis83.remocra.db.model.pdi.tables.ModeleTraitementParametre;
import fr.sdis83.remocra.db.model.pdi.tables.Statut;
import fr.sdis83.remocra.db.model.pdi.tables.Traitement;
import fr.sdis83.remocra.db.model.pdi.tables.TraitementCc;
import fr.sdis83.remocra.db.model.pdi.tables.TraitementParametre;
import fr.sdis83.remocra.db.model.pdi.tables.VueCommuneOldeb;
import fr.sdis83.remocra.db.model.pdi.tables.VueCommuneOuIntercoOne;
import fr.sdis83.remocra.db.model.pdi.tables.VueCommunes;
import fr.sdis83.remocra.db.model.pdi.tables.VueFamillesPromethee;
import fr.sdis83.remocra.db.model.pdi.tables.VueModeleCourrierHydrantsNonDispo;
import fr.sdis83.remocra.db.model.pdi.tables.VueModeleCourrierInformationTournee;
import fr.sdis83.remocra.db.model.pdi.tables.VueModeleCourrierRapportTournee;
import fr.sdis83.remocra.db.model.pdi.tables.VueModeleExport;
import fr.sdis83.remocra.db.model.pdi.tables.VueOrganisme;
import fr.sdis83.remocra.db.model.pdi.tables.VueOrganismeCis;
import fr.sdis83.remocra.db.model.pdi.tables.VuePermisEtats;
import fr.sdis83.remocra.db.model.pdi.tables.VueProfilSdis;
import fr.sdis83.remocra.db.model.pdi.tables.VueTelechargements;
import fr.sdis83.remocra.db.model.pdi.tables.VueUtilisateurs;
import fr.sdis83.remocra.db.model.pdi.tables.VueZoneCompetence;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in pdi
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

	/**
	 * The table pdi.modele_message
	 */
	public static final ModeleMessage MODELE_MESSAGE = fr.sdis83.remocra.db.model.pdi.tables.ModeleMessage.MODELE_MESSAGE;

	/**
	 * The table pdi.modele_traitement
	 */
	public static final ModeleTraitement MODELE_TRAITEMENT = fr.sdis83.remocra.db.model.pdi.tables.ModeleTraitement.MODELE_TRAITEMENT;

	/**
	 * The table pdi.modele_traitement_parametre
	 */
	public static final ModeleTraitementParametre MODELE_TRAITEMENT_PARAMETRE = fr.sdis83.remocra.db.model.pdi.tables.ModeleTraitementParametre.MODELE_TRAITEMENT_PARAMETRE;

	/**
	 * The table pdi.statut
	 */
	public static final Statut STATUT = fr.sdis83.remocra.db.model.pdi.tables.Statut.STATUT;

	/**
	 * The table pdi.traitement
	 */
	public static final Traitement TRAITEMENT = fr.sdis83.remocra.db.model.pdi.tables.Traitement.TRAITEMENT;

	/**
	 * The table pdi.traitement_cc
	 */
	public static final TraitementCc TRAITEMENT_CC = fr.sdis83.remocra.db.model.pdi.tables.TraitementCc.TRAITEMENT_CC;

	/**
	 * The table pdi.traitement_parametre
	 */
	public static final TraitementParametre TRAITEMENT_PARAMETRE = fr.sdis83.remocra.db.model.pdi.tables.TraitementParametre.TRAITEMENT_PARAMETRE;

	/**
	 * The table pdi.vue_commune_oldeb
	 */
	public static final VueCommuneOldeb VUE_COMMUNE_OLDEB = fr.sdis83.remocra.db.model.pdi.tables.VueCommuneOldeb.VUE_COMMUNE_OLDEB;

	/**
	 * The table pdi.vue_commune_ou_interco_one
	 */
	public static final VueCommuneOuIntercoOne VUE_COMMUNE_OU_INTERCO_ONE = fr.sdis83.remocra.db.model.pdi.tables.VueCommuneOuIntercoOne.VUE_COMMUNE_OU_INTERCO_ONE;

	/**
	 * The table pdi.vue_communes
	 */
	public static final VueCommunes VUE_COMMUNES = fr.sdis83.remocra.db.model.pdi.tables.VueCommunes.VUE_COMMUNES;

	/**
	 * The table pdi.vue_familles_promethee
	 */
	public static final VueFamillesPromethee VUE_FAMILLES_PROMETHEE = fr.sdis83.remocra.db.model.pdi.tables.VueFamillesPromethee.VUE_FAMILLES_PROMETHEE;

	/**
	 * The table pdi.vue_modele_courrier_hydrants_non_dispo
	 */
	public static final VueModeleCourrierHydrantsNonDispo VUE_MODELE_COURRIER_HYDRANTS_NON_DISPO = fr.sdis83.remocra.db.model.pdi.tables.VueModeleCourrierHydrantsNonDispo.VUE_MODELE_COURRIER_HYDRANTS_NON_DISPO;

	/**
	 * The table pdi.vue_modele_courrier_information_tournee
	 */
	public static final VueModeleCourrierInformationTournee VUE_MODELE_COURRIER_INFORMATION_TOURNEE = fr.sdis83.remocra.db.model.pdi.tables.VueModeleCourrierInformationTournee.VUE_MODELE_COURRIER_INFORMATION_TOURNEE;

	/**
	 * The table pdi.vue_modele_courrier_rapport_tournee
	 */
	public static final VueModeleCourrierRapportTournee VUE_MODELE_COURRIER_RAPPORT_TOURNEE = fr.sdis83.remocra.db.model.pdi.tables.VueModeleCourrierRapportTournee.VUE_MODELE_COURRIER_RAPPORT_TOURNEE;

	/**
	 * The table pdi.vue_modele_export
	 */
	public static final VueModeleExport VUE_MODELE_EXPORT = fr.sdis83.remocra.db.model.pdi.tables.VueModeleExport.VUE_MODELE_EXPORT;

	/**
	 * The table pdi.vue_organisme
	 */
	public static final VueOrganisme VUE_ORGANISME = fr.sdis83.remocra.db.model.pdi.tables.VueOrganisme.VUE_ORGANISME;

	/**
	 * The table pdi.vue_organisme_cis
	 */
	public static final VueOrganismeCis VUE_ORGANISME_CIS = fr.sdis83.remocra.db.model.pdi.tables.VueOrganismeCis.VUE_ORGANISME_CIS;

	/**
	 * The table pdi.vue_permis_etats
	 */
	public static final VuePermisEtats VUE_PERMIS_ETATS = fr.sdis83.remocra.db.model.pdi.tables.VuePermisEtats.VUE_PERMIS_ETATS;

	/**
	 * The table pdi.vue_profil_sdis
	 */
	public static final VueProfilSdis VUE_PROFIL_SDIS = fr.sdis83.remocra.db.model.pdi.tables.VueProfilSdis.VUE_PROFIL_SDIS;

	/**
	 * The table pdi.vue_telechargements
	 */
	public static final VueTelechargements VUE_TELECHARGEMENTS = fr.sdis83.remocra.db.model.pdi.tables.VueTelechargements.VUE_TELECHARGEMENTS;

	/**
	 * The table pdi.vue_utilisateurs
	 */
	public static final VueUtilisateurs VUE_UTILISATEURS = fr.sdis83.remocra.db.model.pdi.tables.VueUtilisateurs.VUE_UTILISATEURS;

	/**
	 * The table pdi.vue_zone_competence
	 */
	public static final VueZoneCompetence VUE_ZONE_COMPETENCE = fr.sdis83.remocra.db.model.pdi.tables.VueZoneCompetence.VUE_ZONE_COMPETENCE;
}
