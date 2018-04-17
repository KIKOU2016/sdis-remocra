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
public class TypeOrganisme extends TableImpl<Record> {

	private static final long serialVersionUID = -1889081443;

	/**
	 * The reference instance of <code>remocra.type_organisme</code>
	 */
	public static final TypeOrganisme TYPE_ORGANISME = new TypeOrganisme();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<Record> getRecordType() {
		return Record.class;
	}

	/**
	 * The column <code>remocra.type_organisme.id</code>.
	 */
	public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>remocra.type_organisme.code</code>.
	 */
	public final TableField<Record, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

	/**
	 * The column <code>remocra.type_organisme.nom</code>.
	 */
	public final TableField<Record, String> NOM = createField("nom", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

	/**
	 * The column <code>remocra.type_organisme.actif</code>.
	 */
	public final TableField<Record, Boolean> ACTIF = createField("actif", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaulted(true), this, "");

	/**
	 * Create a <code>remocra.type_organisme</code> table reference
	 */
	public TypeOrganisme() {
		this("type_organisme", null);
	}

	/**
	 * Create an aliased <code>remocra.type_organisme</code> table reference
	 */
	public TypeOrganisme(String alias) {
		this(alias, TYPE_ORGANISME);
	}

	private TypeOrganisme(String alias, Table<Record> aliased) {
		this(alias, aliased, null);
	}

	private TypeOrganisme(String alias, Table<Record> aliased, Field<?>[] parameters) {
		super(alias, Remocra.REMOCRA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<Record, Long> getIdentity() {
		return Keys.IDENTITY_TYPE_ORGANISME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<Record> getPrimaryKey() {
		return Keys.TYPE_ORGANISME_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<Record>> getKeys() {
		return Arrays.<UniqueKey<Record>>asList(Keys.TYPE_ORGANISME_PKEY, Keys.TYPE_ORGANISME_CODE_KEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TypeOrganisme as(String alias) {
		return new TypeOrganisme(alias, this);
	}

	/**
	 * Rename this table
	 */
	public TypeOrganisme rename(String name) {
		return new TypeOrganisme(name, null);
	}
}
