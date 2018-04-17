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
public class AlerteEltAno extends TableImpl<Record> {

	private static final long serialVersionUID = 69042612;

	/**
	 * The reference instance of <code>remocra.alerte_elt_ano</code>
	 */
	public static final AlerteEltAno ALERTE_ELT_ANO = new AlerteEltAno();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<Record> getRecordType() {
		return Record.class;
	}

	/**
	 * The column <code>remocra.alerte_elt_ano.id</code>.
	 */
	public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>remocra.alerte_elt_ano.version</code>.
	 */
	public final TableField<Record, Integer> VERSION = createField("version", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>remocra.alerte_elt_ano.alerte_elt</code>.
	 */
	public final TableField<Record, Long> ALERTE_ELT = createField("alerte_elt", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>remocra.alerte_elt_ano.type_alerte_ano</code>.
	 */
	public final TableField<Record, Long> TYPE_ALERTE_ANO = createField("type_alerte_ano", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * Create a <code>remocra.alerte_elt_ano</code> table reference
	 */
	public AlerteEltAno() {
		this("alerte_elt_ano", null);
	}

	/**
	 * Create an aliased <code>remocra.alerte_elt_ano</code> table reference
	 */
	public AlerteEltAno(String alias) {
		this(alias, ALERTE_ELT_ANO);
	}

	private AlerteEltAno(String alias, Table<Record> aliased) {
		this(alias, aliased, null);
	}

	private AlerteEltAno(String alias, Table<Record> aliased, Field<?>[] parameters) {
		super(alias, Remocra.REMOCRA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<Record, Long> getIdentity() {
		return Keys.IDENTITY_ALERTE_ELT_ANO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<Record> getPrimaryKey() {
		return Keys.ALERTE_ELT_ANO_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<Record>> getKeys() {
		return Arrays.<UniqueKey<Record>>asList(Keys.ALERTE_ELT_ANO_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<Record, ?>> getReferences() {
		return Arrays.<ForeignKey<Record, ?>>asList(Keys.ALERTE_ELT_ANO__FKE5C4C39A52320D07, Keys.ALERTE_ELT_ANO__FKE5C4C39A5505297C);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AlerteEltAno as(String alias) {
		return new AlerteEltAno(alias, this);
	}

	/**
	 * Rename this table
	 */
	public AlerteEltAno rename(String name) {
		return new AlerteEltAno(name, null);
	}
}
