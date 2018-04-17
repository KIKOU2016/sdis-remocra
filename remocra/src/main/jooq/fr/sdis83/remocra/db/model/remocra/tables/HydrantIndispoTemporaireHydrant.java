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
 * Indisponibilité temporaire lié à un hydrant
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class HydrantIndispoTemporaireHydrant extends TableImpl<Record> {

	private static final long serialVersionUID = -1308234787;

	/**
	 * The reference instance of <code>remocra.hydrant_indispo_temporaire_hydrant</code>
	 */
	public static final HydrantIndispoTemporaireHydrant HYDRANT_INDISPO_TEMPORAIRE_HYDRANT = new HydrantIndispoTemporaireHydrant();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<Record> getRecordType() {
		return Record.class;
	}

	/**
	 * The column <code>remocra.hydrant_indispo_temporaire_hydrant.indisponibilite</code>.
	 */
	public final TableField<Record, Long> INDISPONIBILITE = createField("indisponibilite", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>remocra.hydrant_indispo_temporaire_hydrant.hydrant</code>.
	 */
	public final TableField<Record, Long> HYDRANT = createField("hydrant", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * Create a <code>remocra.hydrant_indispo_temporaire_hydrant</code> table reference
	 */
	public HydrantIndispoTemporaireHydrant() {
		this("hydrant_indispo_temporaire_hydrant", null);
	}

	/**
	 * Create an aliased <code>remocra.hydrant_indispo_temporaire_hydrant</code> table reference
	 */
	public HydrantIndispoTemporaireHydrant(String alias) {
		this(alias, HYDRANT_INDISPO_TEMPORAIRE_HYDRANT);
	}

	private HydrantIndispoTemporaireHydrant(String alias, Table<Record> aliased) {
		this(alias, aliased, null);
	}

	private HydrantIndispoTemporaireHydrant(String alias, Table<Record> aliased, Field<?>[] parameters) {
		super(alias, Remocra.REMOCRA, aliased, parameters, "Indisponibilité temporaire lié à un hydrant");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<Record> getPrimaryKey() {
		return Keys.PK_INDISPONIBILITE_HYDRANT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<Record>> getKeys() {
		return Arrays.<UniqueKey<Record>>asList(Keys.PK_INDISPONIBILITE_HYDRANT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<Record, ?>> getReferences() {
		return Arrays.<ForeignKey<Record, ?>>asList(Keys.HYDRANT_INDISPO_TEMPORAIRE_HYDRANT__FK_HYDRANT_INDISPO_TEMPORAIRE_HYDRANT_INDISPONIBILITE, Keys.HYDRANT_INDISPO_TEMPORAIRE_HYDRANT__FK_HYDRANT_INDISPO_TEMPORAIRE_HYDRANT_HYDRANT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HydrantIndispoTemporaireHydrant as(String alias) {
		return new HydrantIndispoTemporaireHydrant(alias, this);
	}

	/**
	 * Rename this table
	 */
	public HydrantIndispoTemporaireHydrant rename(String name) {
		return new HydrantIndispoTemporaireHydrant(name, null);
	}
}
