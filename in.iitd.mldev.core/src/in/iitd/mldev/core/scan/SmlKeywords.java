package in.iitd.mldev.core.scan;

import in.iitd.mldev.core.parse.SmlSymbols;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/** A utility class for recognizing SML keywords.
 * Used by the lexer and for syntax highlighting. */
public class SmlKeywords {

	/** Internal mapping from strings to Integers for getSym(). */
	private static Map<String, Integer> symMap;
	
	/** Returns the symbol number that identifies what kind of token it is.
	 * Used by SmlLexer for passing to SmlParser. */
	public static int getSym (String word) {
		Integer sym = getMap().get(word);
		if (sym == null) return SmlSymbols.ID;
		else return sym.intValue();
	}
	
	/** Returns the list of known SML keywords. */
	public static Set<String> getKeywords () {
		return Collections.unmodifiableSet(getMap().keySet());
	}
	
	private static Map<String, Integer> getMap () {
		if (symMap == null) {
			symMap = createMap();
		}
		return symMap;
	}

	private static Map<String, Integer> createMap () {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("abstype", SmlSymbols.ABSTYPE);
		map.put("and", SmlSymbols.AND);
		map.put("andalso", SmlSymbols.ANDALSO);
		map.put("as", SmlSymbols.AS);
		map.put("case", SmlSymbols.CASE);
		map.put("datatype", SmlSymbols.DATATYPE);
		map.put("do", SmlSymbols.DO);
		map.put("else", SmlSymbols.ELSE);
		map.put("end", SmlSymbols.END);
		map.put("eqtype", SmlSymbols.EQTYPE);
		map.put("exception", SmlSymbols.EXCEPTION);
		map.put("fn", SmlSymbols.FN);
		map.put("fun", SmlSymbols.FUN);
		map.put("functor", SmlSymbols.FUNCTOR);
		map.put("funsig", SmlSymbols.FUNSIG);
		map.put("handle", SmlSymbols.HANDLE);
		map.put("if", SmlSymbols.IF);
		map.put("in", SmlSymbols.IN);
		map.put("include", SmlSymbols.INCLUDE);
		map.put("infix", SmlSymbols.INFIX);
		map.put("infixr", SmlSymbols.INFIXR);
		map.put("lazy", SmlSymbols.LAZY);
		map.put("let", SmlSymbols.LET);
		map.put("local", SmlSymbols.LOCAL);
		map.put("nonfix", SmlSymbols.NONFIX);
		map.put("of", SmlSymbols.OF);
		map.put("op", SmlSymbols.OP);
		map.put("open", SmlSymbols.OPEN);
		map.put("orelse", SmlSymbols.ORELSE);
		map.put("raise", SmlSymbols.RAISE);
		map.put("rec", SmlSymbols.REC);
		map.put("sharing", SmlSymbols.SHARING);
		map.put("sig", SmlSymbols.SIG);
		map.put("signature", SmlSymbols.SIGNATURE);
		map.put("struct", SmlSymbols.STRUCT);
		map.put("structure", SmlSymbols.STRUCTURE);
		map.put("then", SmlSymbols.THEN);
		map.put("type", SmlSymbols.TYPE);
		map.put("val", SmlSymbols.VAL);
		map.put("where", SmlSymbols.WHERE);
		map.put("while", SmlSymbols.WHILE);
		map.put("with", SmlSymbols.WITH);
		map.put("withtype", SmlSymbols.WITHTYPE);

		map.put("(", SmlSymbols.LPAREN);
		map.put(")", SmlSymbols.RPAREN);
		map.put("[", SmlSymbols.LBRACKET);
		map.put("]", SmlSymbols.RBRACKET);
		map.put("{", SmlSymbols.LBRACE);
		map.put("}", SmlSymbols.RBRACE);
		map.put(".", SmlSymbols.DOT);
		map.put("...", SmlSymbols.DOTDOTDOT);
		map.put(",", SmlSymbols.COMMA);
		map.put(";", SmlSymbols.SEMIC);
		map.put("_", SmlSymbols.UNDER);
		map.put("|", SmlSymbols.BAR);
		map.put("=", SmlSymbols.EQUALS);
		map.put("=>", SmlSymbols.DARROW);
		map.put("->", SmlSymbols.ARROW);
		map.put("#", SmlSymbols.HASH);
		map.put("*", SmlSymbols.ASTERISK);
		map.put(":", SmlSymbols.COLON);
		map.put(":>", SmlSymbols.COLONGT);

		return map;
	}
	
	/** There's no point in instantiating this class. */
	private SmlKeywords () {}
	
}
