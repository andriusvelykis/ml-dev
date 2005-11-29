package in.iitd.mldev.core.parse.ast;

public abstract class Sig extends AST {
	public Sig mark (int l, int r) {super.setPos(l,r); return this;}
}
