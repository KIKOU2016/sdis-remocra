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
public class JaroWinkler extends AbstractRoutine<Double> {

	private static final long serialVersionUID = 663170763;

	/**
	 * The parameter <code>remocra.jaro_winkler.RETURN_VALUE</code>.
	 */
	public static final Parameter<Double> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.DOUBLE, false);

	/**
	 * The parameter <code>remocra.jaro_winkler.str1_in</code>.
	 */
	public static final Parameter<String> STR1_IN = createParameter("str1_in", org.jooq.impl.SQLDataType.CLOB, false);

	/**
	 * The parameter <code>remocra.jaro_winkler.str2_in</code>.
	 */
	public static final Parameter<String> STR2_IN = createParameter("str2_in", org.jooq.impl.SQLDataType.CLOB, false);

	/**
	 * Create a new routine call instance
	 */
	public JaroWinkler() {
		super("jaro_winkler", Remocra.REMOCRA, org.jooq.impl.SQLDataType.DOUBLE);

		setReturnParameter(RETURN_VALUE);
		addInParameter(STR1_IN);
		addInParameter(STR2_IN);
	}

	/**
	 * Set the <code>str1_in</code> parameter IN value to the routine
	 */
	public void setStr1In(String value) {
		setValue(STR1_IN, value);
	}

	/**
	 * Set the <code>str1_in</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public JaroWinkler setStr1In(Field<String> field) {
		setField(STR1_IN, field);
		return this;
	}

	/**
	 * Set the <code>str2_in</code> parameter IN value to the routine
	 */
	public void setStr2In(String value) {
		setValue(STR2_IN, value);
	}

	/**
	 * Set the <code>str2_in</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public JaroWinkler setStr2In(Field<String> field) {
		setField(STR2_IN, field);
		return this;
	}
}
