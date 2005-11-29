package in.iitd.mldev.core.parse.ast;

public abstract class Exp extends AST {
	public Exp mark (int l, int r) {super.setPos(l,r); return this;}
}
