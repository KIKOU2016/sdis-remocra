// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import fr.sdis83.remocra.domain.remocra.ZoneSpeciale;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect ZoneSpeciale_Roo_Json {
    
    public String ZoneSpeciale.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String ZoneSpeciale.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static ZoneSpeciale ZoneSpeciale.fromJsonToZoneSpeciale(String json) {
        return new JSONDeserializer<ZoneSpeciale>()
        .use(null, ZoneSpeciale.class).deserialize(json);
    }
    
    public static String ZoneSpeciale.toJsonArray(Collection<ZoneSpeciale> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String ZoneSpeciale.toJsonArray(Collection<ZoneSpeciale> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<ZoneSpeciale> ZoneSpeciale.fromJsonArrayToZoneSpeciales(String json) {
        return new JSONDeserializer<List<ZoneSpeciale>>()
        .use("values", ZoneSpeciale.class).deserialize(json);
    }
    
}
