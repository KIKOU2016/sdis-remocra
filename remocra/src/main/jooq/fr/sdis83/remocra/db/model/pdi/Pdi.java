/**
 * This class is generated by jOOQ
 */
package fr.sdis83.remocra.db.model.pdi;


import fr.sdis83.remocra.db.model.pdi.Sequences;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Pdi extends SchemaImpl {

	private static final long serialVersionUID = 645814696;

	/**
	 * The reference instance of <code>pdi</code>
	 */
	public static final Pdi PDI = new Pdi();

	/**
	 * No further instances allowed
	 */
	private Pdi() {
		super("pdi");
	}

	@Override
	public final List<Sequence<?>> getSequences() {
		List result = new ArrayList();
		result.addAll(getSequences0());
		return result;
	}

	private final List<Sequence<?>> getSequences0() {
		return Arrays.<Sequence<?>>asList(
			Sequences.TRAITEMENT_IDTRAITEMENT_SEQ);
	}

	@Override
	public final List<Table<?>> getTables() {
		List result = new ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final List<Table<?>> getTables0() {
		return Arrays.<Table<?>>asList(
			ModeleMessage.MODELE_MESSAGE,
			ModeleTraitement.MODELE_TRAITEMENT,
			ModeleTraitementParametre.MODELE_TRAITEMENT_PARAMETRE,
			Statut.STATUT,
			Traitement.TRAITEMENT,
			TraitementCc.TRAITEMENT_CC,
			TraitementParametre.TRAITEMENT_PARAMETRE,
			VueCommuneOldeb.VUE_COMMUNE_OLDEB,
			VueCommuneOuIntercoOne.VUE_COMMUNE_OU_INTERCO_ONE,
			VueCommunes.VUE_COMMUNES,
			VueFamillesPromethee.VUE_FAMILLES_PROMETHEE,
			VueModeleCourrierHydrantsNonDispo.VUE_MODELE_COURRIER_HYDRANTS_NON_DISPO,
			VueModeleCourrierInformationTournee.VUE_MODELE_COURRIER_INFORMATION_TOURNEE,
			VueModeleCourrierRapportTournee.VUE_MODELE_COURRIER_RAPPORT_TOURNEE,
			VueModeleExport.VUE_MODELE_EXPORT,
			VueOrganisme.VUE_ORGANISME,
			VueOrganismeCis.VUE_ORGANISME_CIS,
			VuePermisEtats.VUE_PERMIS_ETATS,
			VueProfilSdis.VUE_PROFIL_SDIS,
			VueTelechargements.VUE_TELECHARGEMENTS,
			VueUtilisateurs.VUE_UTILISATEURS,
			VueZoneCompetence.VUE_ZONE_COMPETENCE);
	}
}
