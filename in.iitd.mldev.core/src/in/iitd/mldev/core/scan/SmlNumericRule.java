package in.iitd.mldev.core.scan;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

/** A rule that matches an SML numeric literal (an integer or a real).
 * Used by SmlTokenScanner. */
public class SmlNumericRule implements IRule {
	private IToken intToken;
	private IToken realToken;
	public SmlNumericRule (IToken intToken, IToken realToken) {
		this.intToken = intToken;
		this.realToken = realToken;
	}
	public IToken evaluate (ICharacterScanner scanner) {
		boolean negative = false;
		if (scanner.read() == '~') negative = true; 
		else scanner.unread(); 
		int length = readDigits(scanner);
		if (length == 0) {
			if (negative) scanner.unread();
			return Token.UNDEFINED;
		}
		boolean real = false;
		if (scanner.read() == '.') {
			length = readDigits(scanner);
			if (length == 0) {
				scanner.unread();
				return intToken;
			}
			else real = true;
		} else scanner.unread();
		int c = scanner.read();
		if (c == 'e' || c == 'E') {
			length = readDigits(scanner);
			if (length == 0) {
				scanner.unread();
				return intToken;
			}
			else real = true;
		} else scanner.unread();
		if (real) return realToken;
		else return intToken;
	}
	private int readDigits (ICharacterScanner scanner) {
		int length = 0;
		while (isDigit(scanner.read())) length++;
		scanner.unread();
		return length;
	}
	private boolean isDigit (int c) {
		return (c >= '0' && c <= '9');
	}
}
