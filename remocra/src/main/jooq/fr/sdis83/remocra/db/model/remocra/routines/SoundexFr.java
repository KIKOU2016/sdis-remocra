/**
 * This class is generated by jOOQ
 */
package fr.sdis83.remocra.db.model.remocra.routines;


import fr.sdis83.remocra.db.model.remocra.Remocra;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;


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
public class SoundexFr extends AbstractRoutine<String> {

	private static final long serialVersionUID = -216179174;

	/**
	 * The parameter <code>remocra.soundex_fr.RETURN_VALUE</code>.
	 */
	public static final Parameter<String> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.CLOB, false);

	/**
	 * The parameter <code>remocra.soundex_fr._1</code>.
	 */
	public static final Parameter<String> _1 = createParameter("_1", org.jooq.impl.SQLDataType.CLOB, false);

	/**
	 * Create a new routine call instance
	 */
	public SoundexFr() {
		super("soundex_fr", Remocra.REMOCRA, org.jooq.impl.SQLDataType.CLOB);

		setReturnParameter(RETURN_VALUE);
		addInParameter(_1);
	}

	/**
	 * Set the <code>_1</code> parameter IN value to the routine
	 */
	public void set__1(String value) {
		setValue(_1, value);
	}

	/**
	 * Set the <code>_1</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public SoundexFr set__1(Field<String> field) {
		setField(_1, field);
		return this;
	}
}
