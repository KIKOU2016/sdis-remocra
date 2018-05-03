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
 * Type de zone de la parcelle dans le document d'urbanisme lié à la commune
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TypeOldebZoneUrbanisme extends TableImpl<Record> {

	private static final long serialVersionUID = -74776029;

	/**
	 * The reference instance of <code>remocra.type_oldeb_zone_urbanisme</code>
	 */
	public static final TypeOldebZoneUrbanisme TYPE_OLDEB_ZONE_URBANISME = new TypeOldebZoneUrbanisme();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<Record> getRecordType() {
		return Record.class;
	}

	/**
	 * The column <code>remocra.type_oldeb_zone_urbanisme.id</code>.
	 */
	public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>remocra.type_oldeb_zone_urbanisme.actif</code>.
	 */
	public final TableField<Record, Boolean> ACTIF = createField("actif", org.jooq.impl.SQLDataType.BOOLEAN.defaulted(true), this, "");

	/**
	 * The column <code>remocra.type_oldeb_zone_urbanisme.code</code>.
	 */
	public final TableField<Record, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

	/**
	 * The column <code>remocra.type_oldeb_zone_urbanisme.nom</code>.
	 */
	public final TableField<Record, String> NOM = createField("nom", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

	/**
	 * Create a <code>remocra.type_oldeb_zone_urbanisme</code> table reference
	 */
	public TypeOldebZoneUrbanisme() {
		this("type_oldeb_zone_urbanisme", null);
	}

	/**
	 * Create an aliased <code>remocra.type_oldeb_zone_urbanisme</code> table reference
	 */
	public TypeOldebZoneUrbanisme(String alias) {
		this(alias, TYPE_OLDEB_ZONE_URBANISME);
	}

	private TypeOldebZoneUrbanisme(String alias, Table<Record> aliased) {
		this(alias, aliased, null);
	}

	private TypeOldebZoneUrbanisme(String alias, Table<Record> aliased, Field<?>[] parameters) {
		super(alias, Remocra.REMOCRA, aliased, parameters, "Type de zone de la parcelle dans le document d'urbanisme lié à la commune");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<Record, Long> getIdentity() {
		return Keys.IDENTITY_TYPE_OLDEB_ZONE_URBANISME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<Record> getPrimaryKey() {
		return Keys.TYPE_OLDEB_ZONE_URBANISME_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<Record>> getKeys() {
		return Arrays.<UniqueKey<Record>>asList(Keys.TYPE_OLDEB_ZONE_URBANISME_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TypeOldebZoneUrbanisme as(String alias) {
		return new TypeOldebZoneUrbanisme(alias, this);
	}

	/**
	 * Rename this table
	 */
	public TypeOldebZoneUrbanisme rename(String name) {
		return new TypeOldebZoneUrbanisme(name, null);
	}
}