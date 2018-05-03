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
public class BlocDocumentThematiques extends TableImpl<Record> {

	private static final long serialVersionUID = 1775987969;

	/**
	 * The reference instance of <code>remocra.bloc_document_thematiques</code>
	 */
	public static final BlocDocumentThematiques BLOC_DOCUMENT_THEMATIQUES = new BlocDocumentThematiques();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<Record> getRecordType() {
		return Record.class;
	}

	/**
	 * The column <code>remocra.bloc_document_thematiques.bloc_document</code>.
	 */
	public final TableField<Record, Long> BLOC_DOCUMENT = createField("bloc_document", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>remocra.bloc_document_thematiques.thematiques</code>.
	 */
	public final TableField<Record, Long> THEMATIQUES = createField("thematiques", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * Create a <code>remocra.bloc_document_thematiques</code> table reference
	 */
	public BlocDocumentThematiques() {
		this("bloc_document_thematiques", null);
	}

	/**
	 * Create an aliased <code>remocra.bloc_document_thematiques</code> table reference
	 */
	public BlocDocumentThematiques(String alias) {
		this(alias, BLOC_DOCUMENT_THEMATIQUES);
	}

	private BlocDocumentThematiques(String alias, Table<Record> aliased) {
		this(alias, aliased, null);
	}

	private BlocDocumentThematiques(String alias, Table<Record> aliased, Field<?>[] parameters) {
		super(alias, Remocra.REMOCRA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<Record> getPrimaryKey() {
		return Keys.BLOC_DOCUMENT_THEMATIQUES_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<Record>> getKeys() {
		return Arrays.<UniqueKey<Record>>asList(Keys.BLOC_DOCUMENT_THEMATIQUES_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<Record, ?>> getReferences() {
		return Arrays.<ForeignKey<Record, ?>>asList(Keys.BLOC_DOCUMENT_THEMATIQUES__FK140D14A94995249, Keys.BLOC_DOCUMENT_THEMATIQUES__FK140D14A9FDEC3D27);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlocDocumentThematiques as(String alias) {
		return new BlocDocumentThematiques(alias, this);
	}

	/**
	 * Rename this table
	 */
	public BlocDocumentThematiques rename(String name) {
		return new BlocDocumentThematiques(name, null);
	}
}