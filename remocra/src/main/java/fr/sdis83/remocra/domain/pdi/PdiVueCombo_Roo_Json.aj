// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.pdi;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import fr.sdis83.remocra.domain.pdi.PdiVueCombo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect PdiVueCombo_Roo_Json {
    
    public String PdiVueCombo.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String PdiVueCombo.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static PdiVueCombo PdiVueCombo.fromJsonToPdiVueCombo(String json) {
        return new JSONDeserializer<PdiVueCombo>()
        .use(null, PdiVueCombo.class).deserialize(json);
    }
    
    public static String PdiVueCombo.toJsonArray(Collection<PdiVueCombo> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String PdiVueCombo.toJsonArray(Collection<PdiVueCombo> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<PdiVueCombo> PdiVueCombo.fromJsonArrayToPdiVueComboes(String json) {
        return new JSONDeserializer<List<PdiVueCombo>>()
        .use("values", PdiVueCombo.class).deserialize(json);
    }
    
}
