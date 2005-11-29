package in.iitd.mldev.core.parse.ast;

public abstract class Label extends AST {
	public Label mark (int l, int r) {super.setPos(l,r); return this;}
}
