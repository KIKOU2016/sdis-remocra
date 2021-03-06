/**
 * This class is generated by jOOQ
 */
package fr.sdis83.remocra.db.model.pdi.tables;


import fr.sdis83.remocra.db.model.pdi.Pdi;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.TableField;
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
public class VueProfilSdis extends TableImpl<Record> {

	private static final long serialVersionUID = -234925234;

	/**
	 * The reference instance of <code>pdi.vue_profil_sdis</code>
	 */
	public static final VueProfilSdis VUE_PROFIL_SDIS = new VueProfilSdis();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<Record> getRecordType() {
		return Record.class;
	}

	/**
	 * The column <code>pdi.vue_profil_sdis.id</code>.
	 */
	public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT, this, "");

	/**
	 * The column <code>pdi.vue_profil_sdis.libelle</code>.
	 */
	public final TableField<Record, String> LIBELLE = createField("libelle", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * Create a <code>pdi.vue_profil_sdis</code> table reference
	 */
	public VueProfilSdis() {
		this("vue_profil_sdis", null);
	}

	/**
	 * Create an aliased <code>pdi.vue_profil_sdis</code> table reference
	 */
	public VueProfilSdis(String alias) {
		this(alias, VUE_PROFIL_SDIS);
	}

	private VueProfilSdis(String alias, Table<Record> aliased) {
		this(alias, aliased, null);
	}

	private VueProfilSdis(String alias, Table<Record> aliased, Field<?>[] parameters) {
		super(alias, Pdi.PDI, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VueProfilSdis as(String alias) {
		return new VueProfilSdis(alias, this);
	}

	/**
	 * Rename this table
	 */
	public VueProfilSdis rename(String name) {
		return new VueProfilSdis(name, null);
	}
}
