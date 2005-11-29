package in.iitd.mldev.core.parse.ast;

public abstract class Type extends AST {
	public Type mark (int l, int r) {super.setPos(l,r); return this;}
}
