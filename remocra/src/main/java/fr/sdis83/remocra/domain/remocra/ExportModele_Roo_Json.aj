// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import fr.sdis83.remocra.domain.remocra.ExportModele;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect ExportModele_Roo_Json {

    public String ExportModele.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }

    public String ExportModele.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }

    public static ExportModele ExportModele.fromJsonToExportModele(String json) {
        return new JSONDeserializer<ExportModele>()
        .use(null, ExportModele.class).deserialize(json);
    }

    public static String ExportModele.toJsonArray(Collection<ExportModele> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }

    public static String ExportModele.toJsonArray(Collection<ExportModele> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }

    public static Collection<ExportModele> ExportModele.fromJsonArrayToExportModeles(String json) {
        return new JSONDeserializer<List<ExportModele>>()
        .use("values", ExportModele.class).deserialize(json);
    }

}