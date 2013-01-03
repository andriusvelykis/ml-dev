package in.iitd.mldev.core.parse.ast;

public class Rule extends AST {
	public final Pat pat;
	public final Exp exp;

	public Rule(Pat p, Exp e) {
		pat = p;
		exp = e;
	}
}
