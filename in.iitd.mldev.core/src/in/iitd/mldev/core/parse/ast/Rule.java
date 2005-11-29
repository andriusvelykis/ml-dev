package in.iitd.mldev.core.parse.ast;

public class Rule extends AST {
    public Pat pat; public Exp exp;
    public Rule(Pat p, Exp e) {pat = p; exp = e;}
	public Rule mark (int l, int r) {super.setPos(l,r); return this;}
}
