/**
 * This class is generated by jOOQ
 */
package fr.sdis83.remocra.db.model.pg_toast;


import javax.annotation.Generated;

import org.jooq.impl.SchemaImpl;


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
public class PgToast extends SchemaImpl {

	private static final long serialVersionUID = 2044863278;

	/**
	 * The reference instance of <code>pg_toast</code>
	 */
	public static final PgToast PG_TOAST = new PgToast();

	/**
	 * No further instances allowed
	 */
	private PgToast() {
		super("pg_toast");
	}
}
