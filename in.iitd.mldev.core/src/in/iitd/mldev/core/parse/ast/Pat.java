package in.iitd.mldev.core.parse.ast;

public abstract class Pat extends AST {
	public Pat mark (int l, int r) {super.setPos(l,r); return this;}
}
