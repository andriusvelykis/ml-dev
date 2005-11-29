package in.iitd.mldev.core.scan;

import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

/**
 * This class performs the basic lexical analysis (scanning) of a document.
 * It expects to be run only on "plain" SML code without comments or strings,
 * since those should have been divided into separate partitions by an
 * SmlPartitionScanner. SmlLexer uses it in this manner to read
 * tokens from SML code.
 * <p>
 * The token scanner does not check for SML keywords. It returns all potential
 * identifiers and keywords as SmlTokenTypes.WORD.
 */
public class SmlTokenScanner extends BufferedRuleBasedScanner {

	public SmlTokenScanner () {
		super();
		
		IToken wordToken = new Token(SmlTokenTypes.WORD);
		IToken tyvarToken = new Token(SmlTokenTypes.TYVAR);
		IToken intToken = new Token(SmlTokenTypes.INT);
		IToken realToken = new Token(SmlTokenTypes.REAL);
		
		IRule whitespace = new WhitespaceRule(new WhitespaceDetector());
		IRule numeric = new SmlNumericRule(intToken, realToken);
		
		WordRule alphaWords = new WordRule(new AlphaWordDetector(), wordToken);
		WordRule symWords = new WordRule(new SymWordDetector(), wordToken);
		WordRule primedWords = new WordRule(new PrimedWordDetector(), tyvarToken);

		IRule punctuation = new SmlPunctuationRule(wordToken);
		
		setRules(new IRule[] {whitespace, numeric, alphaWords, symWords, primedWords, punctuation});
	}
	
	private static class WhitespaceDetector implements IWhitespaceDetector {
		public boolean isWhitespace (char c) {return (c==' ' || c=='\t' || c=='\f' || c=='\n' || c=='\r');}
	}
	private static class AlphaWordDetector implements IWordDetector {
		public boolean isWordStart (char c) {return ((c>='a' && c<='z') || (c>='A' && c<='Z'));}
		public boolean isWordPart (char c) {return ((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9') || c=='_' || c=='\'');}
	}
	private static class SymWordDetector implements IWordDetector {
		private char[] chars = "!%&$#+-/:<=>?@\\~`^|*".toCharArray();
		public boolean isWordStart (char c) {return isWordPart(c);}
		public boolean isWordPart (char c) {
			for (int i = 0; i < chars.length; i++)
				if (c == chars[i]) return true;
			return false;
		}
	}
	private static class PrimedWordDetector implements IWordDetector {
		public boolean isWordStart (char c) {return c=='\'';}
		public boolean isWordPart (char c) {return ((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9') || c=='_' || c=='\'');}
	}
	
}
