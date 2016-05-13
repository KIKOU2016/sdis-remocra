// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import fr.sdis83.remocra.domain.remocra.Thematique;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect Thematique_Roo_Json {
    
    public String Thematique.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String Thematique.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static Thematique Thematique.fromJsonToThematique(String json) {
        return new JSONDeserializer<Thematique>()
        .use(null, Thematique.class).deserialize(json);
    }
    
    public static String Thematique.toJsonArray(Collection<Thematique> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String Thematique.toJsonArray(Collection<Thematique> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<Thematique> Thematique.fromJsonArrayToThematiques(String json) {
        return new JSONDeserializer<List<Thematique>>()
        .use("values", Thematique.class).deserialize(json);
    }
    
}
