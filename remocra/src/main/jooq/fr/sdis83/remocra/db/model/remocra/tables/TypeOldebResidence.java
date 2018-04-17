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
 * Type de résidence pour le proprietaire d'une parcelle batie sousmise à 
 * une obligation légale de débroussaillement
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TypeOldebResidence extends TableImpl<Record> {

	private static final long serialVersionUID = -1622284422;

	/**
	 * The reference instance of <code>remocra.type_oldeb_residence</code>
	 */
	public static final TypeOldebResidence TYPE_OLDEB_RESIDENCE = new TypeOldebResidence();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<Record> getRecordType() {
		return Record.class;
	}

	/**
	 * The column <code>remocra.type_oldeb_residence.id</code>.
	 */
	public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>remocra.type_oldeb_residence.actif</code>.
	 */
	public final TableField<Record, Boolean> ACTIF = createField("actif", org.jooq.impl.SQLDataType.BOOLEAN.defaulted(true), this, "");

	/**
	 * The column <code>remocra.type_oldeb_residence.code</code>.
	 */
	public final TableField<Record, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

	/**
	 * The column <code>remocra.type_oldeb_residence.nom</code>.
	 */
	public final TableField<Record, String> NOM = createField("nom", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

	/**
	 * Create a <code>remocra.type_oldeb_residence</code> table reference
	 */
	public TypeOldebResidence() {
		this("type_oldeb_residence", null);
	}

	/**
	 * Create an aliased <code>remocra.type_oldeb_residence</code> table reference
	 */
	public TypeOldebResidence(String alias) {
		this(alias, TYPE_OLDEB_RESIDENCE);
	}

	private TypeOldebResidence(String alias, Table<Record> aliased) {
		this(alias, aliased, null);
	}

	private TypeOldebResidence(String alias, Table<Record> aliased, Field<?>[] parameters) {
		super(alias, Remocra.REMOCRA, aliased, parameters, "Type de résidence pour le proprietaire d'une parcelle batie sousmise à une obligation légale de débroussaillement");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<Record, Long> getIdentity() {
		return Keys.IDENTITY_TYPE_OLDEB_RESIDENCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<Record> getPrimaryKey() {
		return Keys.TYPE_OLDEB_RESIDENCE_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<Record>> getKeys() {
		return Arrays.<UniqueKey<Record>>asList(Keys.TYPE_OLDEB_RESIDENCE_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TypeOldebResidence as(String alias) {
		return new TypeOldebResidence(alias, this);
	}

	/**
	 * Rename this table
	 */
	public TypeOldebResidence rename(String name) {
		return new TypeOldebResidence(name, null);
	}
}
