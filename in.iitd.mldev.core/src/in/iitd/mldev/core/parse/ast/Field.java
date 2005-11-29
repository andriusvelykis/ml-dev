package in.iitd.mldev.core.parse.ast;

public abstract class Field extends AST {
	public Field mark (int l, int r) {super.setPos(l,r); return this;}
}
