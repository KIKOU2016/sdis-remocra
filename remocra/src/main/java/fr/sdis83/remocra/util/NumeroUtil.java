package fr.sdis83.remocra.util;

import fr.sdis83.remocra.domain.remocra.Hydrant;
import fr.sdis83.remocra.domain.remocra.HydrantPibi;
import fr.sdis83.remocra.domain.remocra.ParamConf;
import fr.sdis83.remocra.domain.remocra.ParamConf.ParamConfParam;
import fr.sdis83.remocra.domain.remocra.ZoneSpeciale;
import org.apache.commons.lang3.ArrayUtils;

import javax.persistence.Query;

public class NumeroUtil {

    public enum MethodeNumerotation {
        M_09, M_77, M_83, M_86, M_89, M_42, M_78
    }

    public static MethodeNumerotation getHydrantNumerotationMethode() {
        MethodeNumerotation m = null;
        try {
            ParamConf pc = ParamConf.findParamConfsByCleEquals(ParamConfParam.HYDRANT_NUMEROTATION_METHODE.getCle())
                    .getSingleResult();
            m = MethodeNumerotation.valueOf("M_" + pc.getValeur());
        } catch (Exception e) {
            System.err.println("HYDRANT_NUMEROTATION_METHODE non reconnu (-> 83). Valeurs autorisées (sans M_) : "
                    + ArrayUtils.toString(MethodeNumerotation.values()));
            m = MethodeNumerotation.M_83;
        }
        return m;
    }

    public enum MethodeNumerotationInterne {
        M_77, M_83, M_86, M_42, M_78
    }

    public static MethodeNumerotationInterne getHydrantNumerotationInterneMethode() {
        MethodeNumerotationInterne m = null;
        try {
            ParamConf pc = ParamConf.findParamConfsByCleEquals(ParamConfParam.HYDRANT_NUMEROTATION_INTERNE_METHODE.getCle())
                    .getSingleResult();
            m = MethodeNumerotationInterne.valueOf("M_" + pc.getValeur());
        } catch (Exception e) {
            System.err.println("HYDRANT_NUMEROTATION_METHODE non reconnu (-> 83). Valeurs autorisées (sans M_) : "
                    + ArrayUtils.toString(MethodeNumerotation.values()));
            m = MethodeNumerotationInterne.M_83;
        }
        return m;
    }

    // ******************************
    // ** Numéro
    // ******************************

    /**
     * Calcule le numéro de l'hydrant.
     *
     * @param hydrant
     * @return
     */
    public static String computeNumero(Hydrant hydrant) {
        switch (getHydrantNumerotationMethode()) {
            case M_09:
                return NumeroUtil.computeNumero09(hydrant);
            case M_77:
                return NumeroUtil.computeNumero77(hydrant);
            case M_86:
                return NumeroUtil.computeNumero86(hydrant);
            case M_89:
                return NumeroUtil.computeNumero89(hydrant);
            // même methode que 89
            case M_42:
                return NumeroUtil.computeNumero89(hydrant);
            case M_78:
                return NumeroUtil.computeNumero78(hydrant);
            default:
                return NumeroUtil.computeNumero83(hydrant);
        }
    }

    /**
     * <code insee commune><numéro interne> sans espace
     * <p>
     * Exemple : 09122012
     *
     * @param hydrant
     * @return
     */
    protected static String computeNumero09(Hydrant hydrant) {
        String codeZS = hydrant.getZoneSpeciale() == null ? null : hydrant.getZoneSpeciale().getCode();

        StringBuilder sb = new StringBuilder();

        sb.append(codeZS != null ? codeZS : hydrant.getCommune().getInsee());
        return sb.append(String.format("%03d", hydrant.getNumeroInterne())).toString();
    }

    /**
     * <code insee commune><numéro interne> sans espace
     * <p>
     * Exemple : 772880012
     *
     * @param hydrant
     * @return
     */
    protected static String computeNumero77(Hydrant hydrant) {
        String codeZS = hydrant.getZoneSpeciale() == null ? null : hydrant.getZoneSpeciale().getCode();

        StringBuilder sb = new StringBuilder();

        sb.append(codeZS != null ? codeZS : hydrant.getCommune().getInsee());
        return sb.append(String.format("%04d", hydrant.getNumeroInterne())).toString();
    }

    /**
     * <code insee commune>_<numéro interne>
     * <p>
     * Exemple : 89043_12
     *
     * @param hydrant
     * @return
     */
    protected static String computeNumero89(Hydrant hydrant) {
        StringBuilder sb = new StringBuilder();

        sb.append(hydrant.getCommune().getInsee());
        sb.append("_");
        return sb.append(hydrant.getNumeroInterne().toString()).toString();
    }

    /**
     * <code insee commune>0 ou A<numéro interne>
     * <p>
     * Exemple : 8904300012 ou  89043A0012 pour les Autoroutes
     *
     * @param hydrant
     * @return
     */
    protected static String computeNumero78(Hydrant hydrant) {
        StringBuilder sb = new StringBuilder();
        String codeDomaine = hydrant.getDomaine() == null ? null : hydrant.getDomaine().getCode();
        sb.append(hydrant.getCommune().getInsee());
        if("AUTOROUTE".equals(codeDomaine)){
            sb.append("A");
            return sb.append(String.format("%04d", hydrant.getNumeroInterne())).toString();
        }
        return sb.append(String.format("%05d", hydrant.getNumeroInterne())).toString();
    }

    /**
     * <Code nature pour les PIBI ou les RI, PN pour les autres> <code commune>
     * <numéro interne>
     * <p>
     * Exemple : PI TLN 12
     *
     * @param hydrant
     * @return
     */
    protected static String computeNumero83(Hydrant hydrant) {
        String codeZS = hydrant.getZoneSpeciale() == null ? null : hydrant.getZoneSpeciale().getCode();

        StringBuilder sb = new StringBuilder();
        if ("PIBI".equals(hydrant.getCode())) {
            sb.append(hydrant.getNature().getCode()).append(" ");
            HydrantPibi pibi = (HydrantPibi) hydrant;
            if (pibi.getPena() != null && !"PA".equals(pibi.getNature().getCode())) {
                // Pibi lié à un Pena : on double le code zone ou commune
                sb.append(codeZS != null ? codeZS : hydrant.getCommune().getCode()).append(" ");
            }
        } else if ("RI".equals(hydrant.getNature().getCode())) {
            sb.append("RI ");
        } else {
            sb.append("PN ");
        }

        sb.append(codeZS != null ? codeZS : hydrant.getCommune().getCode());
        return sb.append(" ").append(hydrant.getNumeroInterne()).toString();
    }

    /**
     * <code insee commune> <numéro interne>
     * <p>
     * Exemple : 86194 99947
     *
     * @param hydrant
     * @return
     */
    protected static String computeNumero86(Hydrant hydrant) {
        String codeZS = hydrant.getZoneSpeciale() == null ? null : hydrant.getZoneSpeciale().getCode();

        StringBuilder sb = new StringBuilder();
        sb.append(codeZS != null ? codeZS : hydrant.getCommune().getInsee());
        return sb.append(" ").append(hydrant.getNumeroInterne()).toString();
    }

    // ******************************
    // ** Zone spéciale
    // ******************************

    /**
     * Calcule la zone spéciale de l'hydrant.
     *
     * @param hydrant
     * @return
     */
    public static ZoneSpeciale computeZoneSpeciale(Hydrant hydrant) {
        try {
            String codeZS = (String) Hydrant.entityManager()
                    .createNativeQuery("select code from remocra.zone_speciale " + "where :geometrie && geometrie and "
                            + "st_distance(:geometrie, geometrie)<=0")
                    .setParameter("geometrie", hydrant.getGeometrie()).getSingleResult();
            return ZoneSpeciale.findZoneSpecialesByCode(codeZS).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    // ******************************
    // ** Zone spéciale et Numéro
    // ******************************

    /**
     * Redéfinit le code, la zone spéciale éventuelle, le numéro interne et le
     * numéro
     *
     * @param hydrant
     */
    public static void setCodeZoneSpecAndNumeros(Hydrant hydrant) {
        // Code
        hydrant.setCode(hydrant.getNature().getTypeHydrant().getCode());

        // Zone Spéciale
        hydrant.setZoneSpeciale(computeZoneSpeciale(hydrant));

        // Si création : attribution d'un nouveau numéro interne
        if (hydrant.getNumeroInterne() == null || hydrant.getNumeroInterne().intValue() < 1) {
            hydrant.setNumeroInterne(NumeroUtil.computeNumeroInterne(hydrant));
        }

        // Calcul du numéro
        hydrant.setNumero(NumeroUtil.computeNumero(hydrant));
    }

    // ******************************
    // ** Numéro interne
    // ******************************

    /**
     * Calcul le numéro interne de l'hydrant.
     *
     * @param hydrant
     * @return
     */
    public static Integer computeNumeroInterne(Hydrant hydrant) {
        switch (getHydrantNumerotationInterneMethode()) {
            case M_77:
                return NumeroUtil.computeNumeroInterne77(hydrant);
            case M_42:
                return NumeroUtil.computeNumeroInterne42(hydrant);
            case M_86:
                return NumeroUtil.computeNumeroInterne86(hydrant);
            case M_78:
                return NumeroUtil.computeNumeroInterne78(hydrant);
            default:
                return NumeroUtil.computeNumeroInterne83(hydrant);
        }
    }

    public static Integer computeNumeroInterne77(Hydrant hydrant) {
        // Retour du numéro interne s'il existe
        if (hydrant.getNumeroInterne() != null && hydrant.getId() != null) {
            return hydrant.getNumeroInterne();
        }
        Integer numInterne = null;
        try {
            // Premier numéro interne dispo pour la commune (ou de la zone spéciale)
            Long idZoneSpeciale = hydrant.getZoneSpeciale() != null ? hydrant.getZoneSpeciale().getId() : null;

            StringBuffer sb = new StringBuffer("select remocra.nextNumeroInterne(null, null, ");
            sb.append(idZoneSpeciale == null ? ":idcommune" : "null");
            sb.append(", ");
            sb.append(idZoneSpeciale == null ? "null" : ":idzonespeciale");
            sb.append(", true)");

            Query query = Hydrant.entityManager().createNativeQuery(sb.toString());
            if (idZoneSpeciale == null) {
                query.setParameter("idcommune", hydrant.getCommune().getId());
            } else {
                query.setParameter("idzonespeciale", idZoneSpeciale);
            }

            numInterne = Integer.valueOf(query.getSingleResult().toString());
        } catch (Exception e) {
            numInterne = 99999;
        }
        return numInterne;
    }

    public static Integer computeNumeroInterne42(Hydrant hydrant) {
        // Retour du numéro interne s'il existe
        if (hydrant.getNumeroInterne() != null && hydrant.getId() != null) {
            return hydrant.getNumeroInterne();
        }
        Integer numInterne = null;
        try {
            // Incrementation automatique de numero interne
            StringBuffer sb = new StringBuffer("select max(numero_interne)  from remocra.hydrant h where ");
            sb.append("h.commune = :idcommune order by 1 limit 1");

            Query query = Hydrant.entityManager().createNativeQuery(sb.toString());
            query.setParameter("idcommune", hydrant.getCommune().getId());

            numInterne = Integer.valueOf(query.getSingleResult().toString());
            // On prend le suivant
            numInterne ++;
        } catch (Exception e) {
            numInterne = 99999;
        }
        return numInterne  ;
    }

    public static Integer computeNumeroInterne78(Hydrant hydrant) {
        // Retour du numéro interne s'il existe
        if (hydrant.getNumeroInterne() != null && hydrant.getId() != null) {
            return hydrant.getNumeroInterne();
        }
        Integer numInterne = null;
        try {
            // Incrementation automatique de numero interne
            StringBuffer sb = new StringBuffer("select max(numero_interne)  from remocra.hydrant h where ");
            sb.append("h.commune = :idcommune order by 1 limit 1");

            Query query = Hydrant.entityManager().createNativeQuery(sb.toString());
            query.setParameter("idcommune", hydrant.getCommune().getId());

            numInterne = Integer.valueOf(query.getSingleResult().toString());
            // On prend le suivant
            numInterne ++;
        } catch (Exception e) {
            numInterne = 99999;
        }
        return numInterne  ;
    }

    public static Integer computeNumeroInterne83(Hydrant hydrant) {
        // Retour du numéro interne s'il existe
        if (hydrant.getNumeroInterne() != null && hydrant.getId() != null) {
            return hydrant.getNumeroInterne();
        }
        Integer numInterne = null;
        try {
            // Dernier numéro interne dispo pour le couple (type hydrant, commune) ou (type hydrant, zone spéciale)
            Long idZoneSpeciale = hydrant.getZoneSpeciale() != null ? hydrant.getZoneSpeciale().getId() : null;

            StringBuffer sb = new StringBuffer("select remocra.nextNumeroInterne(null, :idtypehydrant, ");
            sb.append(idZoneSpeciale == null ? ":idcommune" : "null");
            sb.append(", ");
            sb.append(idZoneSpeciale == null ? "null" : ":idzonespeciale");
            sb.append(", false)");

            Query query = Hydrant.entityManager().createNativeQuery(sb.toString())
                    .setParameter("idtypehydrant", hydrant.getNature().getTypeHydrant().getId());
            if (idZoneSpeciale == null) {
                query.setParameter("idcommune", hydrant.getCommune().getId());
            } else {
                query.setParameter("idzonespeciale", idZoneSpeciale);
            }

            numInterne = Integer.valueOf(query.getSingleResult().toString());
        } catch (Exception e) {
            numInterne = 99999;
        }
        return numInterne;
    }

    public static Integer computeNumeroInterne86(Hydrant hydrant) {
        // Retour du numéro interne s'il existe
        if (hydrant.getNumeroInterne() != null && hydrant.getId() != null) {
            return hydrant.getNumeroInterne();
        }
        Integer numInterne = null;
        try {
            // Dernier numéro interne dispo sans contrainte particulière
            Query query = Hydrant.entityManager().createNativeQuery("select remocra.nextNumeroInterne(null, null, null, null, false)");
            numInterne = Integer.valueOf(query.getSingleResult().toString());
        } catch (Exception e) {
            numInterne = 99999;
        }
        return numInterne;
    }
}
