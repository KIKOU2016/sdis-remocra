/**
 * This class is generated by jOOQ
 */
package fr.sdis83.remocra.db.model.remocra.routines;


import fr.sdis83.remocra.db.model.remocra.Remocra;

import javax.annotation.Generated;

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
public class TrgCalculDebitPression extends AbstractRoutine<Object> {

	private static final long serialVersionUID = 1146772102;

	/**
	 * The parameter <code>remocra.trg_calcul_debit_pression.RETURN_VALUE</code>.
	 */
	public static final Parameter<Object> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.DefaultDataType.getDefaultDataType("trigger"), false);

	/**
	 * Create a new routine call instance
	 */
	public TrgCalculDebitPression() {
		super("trg_calcul_debit_pression", Remocra.REMOCRA, org.jooq.impl.DefaultDataType.getDefaultDataType("trigger"));

		setReturnParameter(RETURN_VALUE);
	}
}
