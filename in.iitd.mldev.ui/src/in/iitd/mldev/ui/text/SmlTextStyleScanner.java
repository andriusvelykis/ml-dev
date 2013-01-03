package in.iitd.mldev.ui.text;

import in.iitd.mldev.core.scan.SmlKeywords;

import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;

/** A scanner which scans for SML keywords. It should be run only on
 * document partitions which do not contain comments or strings. */
public class SmlTextStyleScanner extends BufferedRuleBasedScanner {

	/** Creates a scanner that returns a token with the given data for
	 * SML keywords. */
	public SmlTextStyleScanner (Object data) {
		super();
		IToken keywordToken = new Token(data);
		WordRule alphaWords = new WordRule(new AlphaWordDetector(), new Token(null));
		
		for (String keyword : SmlKeywords.getKeywords()) {
			alphaWords.addWord(keyword, keywordToken);
		}
		setRules(new IRule[]{alphaWords});
	}

	/** A word detector which detects SML-style alphanumeric words. */
	private class AlphaWordDetector implements IWordDetector {
		public boolean isWordStart (char c) {return ((c>='a' && c<='z') || (c>='A' && c<='Z'));}
		public boolean isWordPart (char c) {return ((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9') || c=='_' || c=='\'');}
	}

}
