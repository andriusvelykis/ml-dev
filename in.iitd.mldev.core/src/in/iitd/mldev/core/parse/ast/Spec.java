package in.iitd.mldev.core.parse.ast;

public abstract class Spec extends AST {
	public Spec mark (int l, int r) {super.setPos(l,r); return this;}
}
