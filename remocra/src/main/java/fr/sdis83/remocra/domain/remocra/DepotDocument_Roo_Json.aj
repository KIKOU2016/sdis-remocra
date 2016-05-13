// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import fr.sdis83.remocra.domain.remocra.DepotDocument;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect DepotDocument_Roo_Json {
    
    public String DepotDocument.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String DepotDocument.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static DepotDocument DepotDocument.fromJsonToDepotDocument(String json) {
        return new JSONDeserializer<DepotDocument>()
        .use(null, DepotDocument.class).deserialize(json);
    }
    
    public static String DepotDocument.toJsonArray(Collection<DepotDocument> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String DepotDocument.toJsonArray(Collection<DepotDocument> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<DepotDocument> DepotDocument.fromJsonArrayToDepotDocuments(String json) {
        return new JSONDeserializer<List<DepotDocument>>()
        .use("values", DepotDocument.class).deserialize(json);
    }
    
}
