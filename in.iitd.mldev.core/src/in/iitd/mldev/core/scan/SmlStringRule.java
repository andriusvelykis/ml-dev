package in.iitd.mldev.core.scan;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

/** A rule that matches an SML string literal. Used by SmlTokenScanner. */
public class SmlStringRule implements IRule {
	private IToken token;
	public SmlStringRule (IToken successToken) {token = successToken;}
	public IToken evaluate (ICharacterScanner scanner) {
		if (scanner.read() != '"') {scanner.unread(); return Token.UNDEFINED;}
		boolean done = false;
		do {
			switch (scanner.read()) {
				case '"':
				case '\n':
				case '\r':
				case ICharacterScanner.EOF:
					done = true;
					break;
				case '\\':
					readEscSeq(scanner);
					break;
			}
		} while (!done);
		return token;
	}
	private void readEscSeq (ICharacterScanner scanner) {
		if (isWhitespace(scanner.read())) {
			while (isWhitespace(scanner.read())) {};
			scanner.unread();
		}
	}
	private boolean isWhitespace (int c) {return (c==' ' || c=='\t' || c=='\n' || c=='\r' || c=='\f');}
}