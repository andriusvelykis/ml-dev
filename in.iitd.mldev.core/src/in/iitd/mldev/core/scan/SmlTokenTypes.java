package in.iitd.mldev.core.scan;

/** A utility class containing identifiers of the different kinds of tokens
 * that can be returned by an SmlTokenScanner or an SmlPartitionScanner. */
public class SmlTokenTypes {

	/** Identifies an SML identifier or keyword. */
	public static final String WORD = "in.iitd.mldev.smlWord";
	/** Identifies an SML type variable (the "'a" in "'a list"). */
	public static final String TYVAR = "in.iitd.mldev.smlTyvar";
	/** Identifies an SML integer literal. */
	public static final String INT = "in.iitd.mldev.smlInt";
	/** Identifies an SML real literal. */
	public static final String REAL = "in.iitd.mldev.smlReal";
	/** Identifies an SML string literal. */
	public static final String STRING = "in.iitd.mldev.smlString";
	/** Identifies an SML character literal. */
	public static final String CHAR = "in.iitd.mldev.smlChar";
	/** Identifies an SML comment. */
	public static final String COMMENT = "in.iitd.mldev.smlComment";

	/** There's no point in instantiating this class. */
	private SmlTokenTypes () {}

}
