package fr.sdis83.remocra.xml;

import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({ HydrantCiterneEnterre.class, HydrantCoursEau.class, HydrantPlanEau.class, HydrantPuisard.class, HydrantRetenue.class })
public abstract class HydrantPena extends Hydrant {

    public static final String CODE_NATURE_CI_FIXE = "CI_FIXE";
    public static final String CODE_NATURE_CI_ENTERRE = "CI_ENTERRE";
    public static final String CODE_NATURE_CE = "CE";
    public static final String CODE_NATURE_PE = "PE";
    public static final String CODE_NATURE_PU = "PU";
    public static final String CODE_NATURE_RE = "RE";

    private String coordDFCI;

    private String dispoHbe;

    private boolean hbe;
    
    private String capacite;
    
    public HydrantPena() {
        //
    }

    public String getCoordDFCI() {
        return coordDFCI;
    }

    public void setCoordDFCI(String coordDFCI) {
        this.coordDFCI = coordDFCI;
    }
    
    public String getDispoHbe() {
        return dispoHbe;
    }

    public void setDispoHbe(String dispoHbe) {
        this.dispoHbe = dispoHbe;
    }

    public boolean isHbe() {
        return hbe;
    }

    public void setHbe(boolean hbe) {
        this.hbe = hbe;
    }
    
    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }
}
