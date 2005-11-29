package in.iitd.mldev.ui.text;

import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.Token;

/** A token scanner that returns a single token encompassing the entire range.
 * Used for colouring comment and string partitions in a single colour. */
public class SingleTokenScanner extends BufferedRuleBasedScanner {

	/** Creates a scanner that always returns a token with the given data. */
	public SingleTokenScanner (Object data) {
		setDefaultReturnToken(new Token(data));
	}
	
}