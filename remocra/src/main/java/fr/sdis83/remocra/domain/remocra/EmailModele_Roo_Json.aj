// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import fr.sdis83.remocra.domain.remocra.EmailModele;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect EmailModele_Roo_Json {
    
    public String EmailModele.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String EmailModele.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static EmailModele EmailModele.fromJsonToEmailModele(String json) {
        return new JSONDeserializer<EmailModele>()
        .use(null, EmailModele.class).deserialize(json);
    }
    
    public static String EmailModele.toJsonArray(Collection<EmailModele> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String EmailModele.toJsonArray(Collection<EmailModele> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<EmailModele> EmailModele.fromJsonArrayToEmailModeles(String json) {
        return new JSONDeserializer<List<EmailModele>>()
        .use("values", EmailModele.class).deserialize(json);
    }
    
}
