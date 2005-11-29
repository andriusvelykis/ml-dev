package in.iitd.mldev.core.parse.ast;

public class Clause extends AST {
	public Pat[] pats; public Type constraint; public Exp exp;
	public Clause (java.util.List ps, Type c, Exp e) {pats = (Pat[])ps.toArray(new Pat[0]); constraint = c; exp = e;}
	public Clause mark (int l, int r) {super.setPos(l,r); return this;}
}
