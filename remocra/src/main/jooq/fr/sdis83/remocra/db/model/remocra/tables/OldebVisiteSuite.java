/**
 * This class is generated by jOOQ
 */
package fr.sdis83.remocra.db.model.remocra.tables;


import fr.sdis83.remocra.db.converter.InstantConverter;
import fr.sdis83.remocra.db.model.remocra.Keys;
import fr.sdis83.remocra.db.model.remocra.Remocra;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.joda.time.Instant;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * Suite donnée à une visite liée à une obligation légale de débroussaillement
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OldebVisiteSuite extends TableImpl<Record> {

	private static final long serialVersionUID = 1975945654;

	/**
	 * The reference instance of <code>remocra.oldeb_visite_suite</code>
	 */
	public static final OldebVisiteSuite OLDEB_VISITE_SUITE = new OldebVisiteSuite();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<Record> getRecordType() {
		return Record.class;
	}

	/**
	 * The column <code>remocra.oldeb_visite_suite.id</code>.
	 */
	public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>remocra.oldeb_visite_suite.visite</code>.
	 */
	public final TableField<Record, Long> VISITE = createField("visite", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>remocra.oldeb_visite_suite.suite</code>.
	 */
	public final TableField<Record, Long> SUITE = createField("suite", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>remocra.oldeb_visite_suite.date_suite</code>.
	 */
	public final TableField<Record, Instant> DATE_SUITE = createField("date_suite", org.jooq.impl.SQLDataType.TIMESTAMP, this, "", new InstantConverter());

	/**
	 * The column <code>remocra.oldeb_visite_suite.observation</code>.
	 */
	public final TableField<Record, String> OBSERVATION = createField("observation", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * Create a <code>remocra.oldeb_visite_suite</code> table reference
	 */
	public OldebVisiteSuite() {
		this("oldeb_visite_suite", null);
	}

	/**
	 * Create an aliased <code>remocra.oldeb_visite_suite</code> table reference
	 */
	public OldebVisiteSuite(String alias) {
		this(alias, OLDEB_VISITE_SUITE);
	}

	private OldebVisiteSuite(String alias, Table<Record> aliased) {
		this(alias, aliased, null);
	}

	private OldebVisiteSuite(String alias, Table<Record> aliased, Field<?>[] parameters) {
		super(alias, Remocra.REMOCRA, aliased, parameters, "Suite donnée à une visite liée à une obligation légale de débroussaillement");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<Record, Long> getIdentity() {
		return Keys.IDENTITY_OLDEB_VISITE_SUITE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<Record> getPrimaryKey() {
		return Keys.OLDEB_VISITE_SUITE_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<Record>> getKeys() {
		return Arrays.<UniqueKey<Record>>asList(Keys.OLDEB_VISITE_SUITE_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<Record, ?>> getReferences() {
		return Arrays.<ForeignKey<Record, ?>>asList(Keys.OLDEB_VISITE_SUITE__OLDEB_VISITE_SUITE_VISITE, Keys.OLDEB_VISITE_SUITE__TYPE_OLDEB_VISITE_SUITE_SUITE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OldebVisiteSuite as(String alias) {
		return new OldebVisiteSuite(alias, this);
	}

	/**
	 * Rename this table
	 */
	public OldebVisiteSuite rename(String name) {
		return new OldebVisiteSuite(name, null);
	}
}
