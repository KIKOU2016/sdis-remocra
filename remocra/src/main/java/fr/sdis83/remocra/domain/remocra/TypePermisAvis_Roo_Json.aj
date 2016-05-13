// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import fr.sdis83.remocra.domain.remocra.TypePermisAvis;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect TypePermisAvis_Roo_Json {
    
    public String TypePermisAvis.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String TypePermisAvis.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static TypePermisAvis TypePermisAvis.fromJsonToTypePermisAvis(String json) {
        return new JSONDeserializer<TypePermisAvis>()
        .use(null, TypePermisAvis.class).deserialize(json);
    }
    
    public static String TypePermisAvis.toJsonArray(Collection<TypePermisAvis> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String TypePermisAvis.toJsonArray(Collection<TypePermisAvis> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<TypePermisAvis> TypePermisAvis.fromJsonArrayToTypePermisAvises(String json) {
        return new JSONDeserializer<List<TypePermisAvis>>()
        .use("values", TypePermisAvis.class).deserialize(json);
    }
    
}
