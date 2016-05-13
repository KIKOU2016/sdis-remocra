// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import fr.sdis83.remocra.domain.remocra.PermisDocument;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect PermisDocument_Roo_Json {
    
    public String PermisDocument.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String PermisDocument.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static PermisDocument PermisDocument.fromJsonToPermisDocument(String json) {
        return new JSONDeserializer<PermisDocument>()
        .use(null, PermisDocument.class).deserialize(json);
    }
    
    public static String PermisDocument.toJsonArray(Collection<PermisDocument> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String PermisDocument.toJsonArray(Collection<PermisDocument> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<PermisDocument> PermisDocument.fromJsonArrayToPermisDocuments(String json) {
        return new JSONDeserializer<List<PermisDocument>>()
        .use("values", PermisDocument.class).deserialize(json);
    }
    
}
