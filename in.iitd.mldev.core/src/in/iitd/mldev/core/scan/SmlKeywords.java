package in.iitd.mldev.core.scan;

import in.iitd.mldev.core.parse.SmlSymbols;

import java.util.HashMap;
import java.util.Map;

/** A utility class for recognizing SML keywords.
 * Used by the lexer and for syntax highlighting. */
public class SmlKeywords {

	/** Internal mapping from strings to Integers for getSym(). */
	private static Map symMap;
	
	/** Returns the symbol number that identifies what kind of token it is.
	 * Used by SmlLexer for passing to SmlParser. */
	public static int getSym (String word) {
		Integer sym = (Integer) getMap().get(word);
		if (sym == null) return SmlSymbols.ID;
		else return sym.intValue();
	}
	
	/** Returns the list of known SML keywords. */
	public static String[] getKeywords () {
		return (String[]) getMap().keySet().toArray(new String[0]);
	}
	
	private static Map getMap () {
		if (symMap == null)
			symMap = createMap();
		return symMap;
	}

	private static Map createMap () {
		Map map = new HashMap();
		
		map.put("abstype", new Integer(SmlSymbols.ABSTYPE));
		map.put("and", new Integer(SmlSymbols.AND));
		map.put("andalso", new Integer(SmlSymbols.ANDALSO));
		map.put("as", new Integer(SmlSymbols.AS));
		map.put("case", new Integer(SmlSymbols.CASE));
		map.put("datatype", new Integer(SmlSymbols.DATATYPE));
		map.put("do", new Integer(SmlSymbols.DO));
		map.put("else", new Integer(SmlSymbols.ELSE));
		map.put("end", new Integer(SmlSymbols.END));
		map.put("eqtype", new Integer(SmlSymbols.EQTYPE));
		map.put("exception", new Integer(SmlSymbols.EXCEPTION));
		map.put("fn", new Integer(SmlSymbols.FN));
		map.put("fun", new Integer(SmlSymbols.FUN));
		map.put("functor", new Integer(SmlSymbols.FUNCTOR));
		map.put("funsig", new Integer(SmlSymbols.FUNSIG));
		map.put("handle", new Integer(SmlSymbols.HANDLE));
		map.put("if", new Integer(SmlSymbols.IF));
		map.put("in", new Integer(SmlSymbols.IN));
		map.put("include", new Integer(SmlSymbols.INCLUDE));
		map.put("infix", new Integer(SmlSymbols.INFIX));
		map.put("infixr", new Integer(SmlSymbols.INFIXR));
		map.put("lazy", new Integer(SmlSymbols.LAZY));
		map.put("let", new Integer(SmlSymbols.LET));
		map.put("local", new Integer(SmlSymbols.LOCAL));
		map.put("nonfix", new Integer(SmlSymbols.NONFIX));
		map.put("of", new Integer(SmlSymbols.OF));
		map.put("op", new Integer(SmlSymbols.OP));
		map.put("open", new Integer(SmlSymbols.OPEN));
		map.put("orelse", new Integer(SmlSymbols.ORELSE));
		map.put("raise", new Integer(SmlSymbols.RAISE));
		map.put("rec", new Integer(SmlSymbols.REC));
		map.put("sharing", new Integer(SmlSymbols.SHARING));
		map.put("sig", new Integer(SmlSymbols.SIG));
		map.put("signature", new Integer(SmlSymbols.SIGNATURE));
		map.put("struct", new Integer(SmlSymbols.STRUCT));
		map.put("structure", new Integer(SmlSymbols.STRUCTURE));
		map.put("then", new Integer(SmlSymbols.THEN));
		map.put("type", new Integer(SmlSymbols.TYPE));
		map.put("val", new Integer(SmlSymbols.VAL));
		map.put("where", new Integer(SmlSymbols.WHERE));
		map.put("while", new Integer(SmlSymbols.WHILE));
		map.put("with", new Integer(SmlSymbols.WITH));
		map.put("withtype", new Integer(SmlSymbols.WITHTYPE));

		map.put("(", new Integer(SmlSymbols.LPAREN));
		map.put(")", new Integer(SmlSymbols.RPAREN));
		map.put("[", new Integer(SmlSymbols.LBRACKET));
		map.put("]", new Integer(SmlSymbols.RBRACKET));
		map.put("{", new Integer(SmlSymbols.LBRACE));
		map.put("}", new Integer(SmlSymbols.RBRACE));
		map.put(".", new Integer(SmlSymbols.DOT));
		map.put("...", new Integer(SmlSymbols.DOTDOTDOT));
		map.put(",", new Integer(SmlSymbols.COMMA));
		map.put(";", new Integer(SmlSymbols.SEMIC));
		map.put("_", new Integer(SmlSymbols.UNDER));
		map.put("|", new Integer(SmlSymbols.BAR));
		map.put("=", new Integer(SmlSymbols.EQUALS));
		map.put("=>", new Integer(SmlSymbols.DARROW));
		map.put("->", new Integer(SmlSymbols.ARROW));
		map.put("#", new Integer(SmlSymbols.HASH));
		map.put("*", new Integer(SmlSymbols.ASTERISK));
		map.put(":", new Integer(SmlSymbols.COLON));
		map.put(":>", new Integer(SmlSymbols.COLONGT));

		return map;
	}
	
	/** There's no point in instantiating this class. */
	private SmlKeywords () {}
	
}
