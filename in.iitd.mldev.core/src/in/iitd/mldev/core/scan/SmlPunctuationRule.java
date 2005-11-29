package in.iitd.mldev.core.scan;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

/** A rule that matches SML punctuation which does not fall into any other rule.
 * Used by SmlTokenScanner. */
public class SmlPunctuationRule implements IRule {
	private String[] punct = {"(", ")", "[", "#[", "]", "{", "}", ".", "...", ",", ";", "_"};
	private IToken token;
	public SmlPunctuationRule (IToken successToken) {token = successToken;}
	public IToken evaluate (ICharacterScanner scanner) {
		for (int i = 0; i < punct.length; i++)
			if (readString(punct[i], scanner)) return token;
		return Token.UNDEFINED;
	}
	private boolean readString (String string, ICharacterScanner scanner) {
		for (int i = 0; i < string.length(); i++) {
			if (scanner.read() != string.charAt(i)) {
				scanner.unread();
				for (int j = 0; j < i; j++) scanner.unread();
				return false;
			}
		}
		return true;
	}
}
