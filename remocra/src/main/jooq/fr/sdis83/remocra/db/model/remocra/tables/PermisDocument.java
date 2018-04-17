/**
 * This class is generated by jOOQ
 */
package fr.sdis83.remocra.db.model.remocra.tables;


import fr.sdis83.remocra.db.model.remocra.Keys;
import fr.sdis83.remocra.db.model.remocra.Remocra;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PermisDocument extends TableImpl<Record> {

	private static final long serialVersionUID = 486630679;

	/**
	 * The reference instance of <code>remocra.permis_document</code>
	 */
	public static final PermisDocument PERMIS_DOCUMENT = new PermisDocument();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<Record> getRecordType() {
		return Record.class;
	}

	/**
	 * The column <code>remocra.permis_document.id</code>.
	 */
	public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>remocra.permis_document.document</code>.
	 */
	public final TableField<Record, Long> DOCUMENT = createField("document", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>remocra.permis_document.permis</code>.
	 */
	public final TableField<Record, Long> PERMIS = createField("permis", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * Create a <code>remocra.permis_document</code> table reference
	 */
	public PermisDocument() {
		this("permis_document", null);
	}

	/**
	 * Create an aliased <code>remocra.permis_document</code> table reference
	 */
	public PermisDocument(String alias) {
		this(alias, PERMIS_DOCUMENT);
	}

	private PermisDocument(String alias, Table<Record> aliased) {
		this(alias, aliased, null);
	}

	private PermisDocument(String alias, Table<Record> aliased, Field<?>[] parameters) {
		super(alias, Remocra.REMOCRA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<Record, Long> getIdentity() {
		return Keys.IDENTITY_PERMIS_DOCUMENT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<Record> getPrimaryKey() {
		return Keys.PERMIS_DOCUMENT_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<Record>> getKeys() {
		return Arrays.<UniqueKey<Record>>asList(Keys.PERMIS_DOCUMENT_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<Record, ?>> getReferences() {
		return Arrays.<ForeignKey<Record, ?>>asList(Keys.PERMIS_DOCUMENT__FKF1087BA036F0130A, Keys.PERMIS_DOCUMENT__FKF1087BA08CB9E08);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PermisDocument as(String alias) {
		return new PermisDocument(alias, this);
	}

	/**
	 * Rename this table
	 */
	public PermisDocument rename(String name) {
		return new PermisDocument(name, null);
	}
}
