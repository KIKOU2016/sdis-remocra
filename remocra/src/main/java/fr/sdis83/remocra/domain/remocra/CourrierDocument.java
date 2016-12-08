package fr.sdis83.remocra.domain.remocra;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

import fr.sdis83.remocra.domain.utils.RemocraDateHourTransformer;

@RooJavaBean
@RooToString
@RooJson
@RooJpaActiveRecord(versionField = "", finders = { "findCourrierDocumentsByCodeEquals" })
public class CourrierDocument {

    public enum TypeDestinataire {
        ORGANISME, UTILISATEUR, AUTRE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Document document;

    @NotNull
    @Column(name = "code", columnDefinition = "character varying NOT NULL DEFAULT md5(((('courrier-destinataire-'::text || (now())::text) || '-'::text) || floor(((random() * (10000)::double precision) + (1)::double precision))))")
    private String code;

    private String nomDestinataire;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TypeDestinataire typeDestinataire;

    @NotNull
    private String idDestinataire;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = RemocraDateHourTransformer.FORMAT)
    @Column(name = "accuse", columnDefinition = "timestamp without time zone")
    private Date accuse;

    @DateTimeFormat(pattern = RemocraDateHourTransformer.FORMAT)
    Date getDateDoc() {
        return document.getDateDoc();
    }
}
