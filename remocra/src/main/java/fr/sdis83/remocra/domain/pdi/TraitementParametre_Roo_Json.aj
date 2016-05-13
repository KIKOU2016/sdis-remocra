// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.pdi;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import fr.sdis83.remocra.domain.pdi.TraitementParametre;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect TraitementParametre_Roo_Json {
    
    public String TraitementParametre.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String TraitementParametre.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static TraitementParametre TraitementParametre.fromJsonToTraitementParametre(String json) {
        return new JSONDeserializer<TraitementParametre>()
        .use(null, TraitementParametre.class).deserialize(json);
    }
    
    public static String TraitementParametre.toJsonArray(Collection<TraitementParametre> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String TraitementParametre.toJsonArray(Collection<TraitementParametre> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<TraitementParametre> TraitementParametre.fromJsonArrayToTraitementParametres(String json) {
        return new JSONDeserializer<List<TraitementParametre>>()
        .use("values", TraitementParametre.class).deserialize(json);
    }
    
}
