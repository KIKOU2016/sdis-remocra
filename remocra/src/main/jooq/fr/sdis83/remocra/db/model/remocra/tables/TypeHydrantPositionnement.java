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
public class TypeHydrantPositionnement extends TableImpl<Record> {

	private static final long serialVersionUID = 82408362;

	/**
	 * The reference instance of <code>remocra.type_hydrant_positionnement</code>
	 */
	public static final TypeHydrantPositionnement TYPE_HYDRANT_POSITIONNEMENT = new TypeHydrantPositionnement();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<Record> getRecordType() {
		return Record.class;
	}

	/**
	 * The column <code>remocra.type_hydrant_positionnement.id</code>.
	 */
	public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>remocra.type_hydrant_positionnement.actif</code>.
	 */
	public final TableField<Record, Boolean> ACTIF = createField("actif", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>remocra.type_hydrant_positionnement.code</code>.
	 */
	public final TableField<Record, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

	/**
	 * The column <code>remocra.type_hydrant_positionnement.nom</code>.
	 */
	public final TableField<Record, String> NOM = createField("nom", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

	/**
	 * The column <code>remocra.type_hydrant_positionnement.version</code>.
	 */
	public final TableField<Record, Integer> VERSION = createField("version", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this, "");

	/**
	 * Create a <code>remocra.type_hydrant_positionnement</code> table reference
	 */
	public TypeHydrantPositionnement() {
		this("type_hydrant_positionnement", null);
	}

	/**
	 * Create an aliased <code>remocra.type_hydrant_positionnement</code> table reference
	 */
	public TypeHydrantPositionnement(String alias) {
		this(alias, TYPE_HYDRANT_POSITIONNEMENT);
	}

	private TypeHydrantPositionnement(String alias, Table<Record> aliased) {
		this(alias, aliased, null);
	}

	private TypeHydrantPositionnement(String alias, Table<Record> aliased, Field<?>[] parameters) {
		super(alias, Remocra.REMOCRA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<Record, Long> getIdentity() {
		return Keys.IDENTITY_TYPE_HYDRANT_POSITIONNEMENT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<Record> getPrimaryKey() {
		return Keys.TYPE_HYDRANT_POSITIONNEMENT_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<Record>> getKeys() {
		return Arrays.<UniqueKey<Record>>asList(Keys.TYPE_HYDRANT_POSITIONNEMENT_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TypeHydrantPositionnement as(String alias) {
		return new TypeHydrantPositionnement(alias, this);
	}

	/**
	 * Rename this table
	 */
	public TypeHydrantPositionnement rename(String name) {
		return new TypeHydrantPositionnement(name, null);
	}
}
