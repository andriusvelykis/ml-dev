package in.iitd.mldev.core.scan;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

/** A rule that matches an SML comment, which may be nested.
 * Used by SmlTokenScanner. */
public class SmlCommentRule implements IRule {
	private IToken token;
	public SmlCommentRule (IToken successToken) {token = successToken;}
	public IToken evaluate (ICharacterScanner scanner) {
		if (scanner.read() != '(') {scanner.unread(); return Token.UNDEFINED;}
		if (scanner.read() != '*') {scanner.unread(); scanner.unread(); return Token.UNDEFINED;}
		int depth = 1;
		while (depth > 0) {
			switch (scanner.read()) {
			case '(':
				if (scanner.read()=='*') depth++;
				else scanner.unread();
				break;
			case '*':
				if (scanner.read()==')') depth--;
				else scanner.unread();
				break;
			case ICharacterScanner.EOF:
				depth = 0;
			}
		}
		return token;
	}
}