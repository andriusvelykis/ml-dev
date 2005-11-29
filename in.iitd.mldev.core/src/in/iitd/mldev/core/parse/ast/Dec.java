package in.iitd.mldev.core.parse.ast;

public abstract class Dec extends AST {
	public Dec mark (int l, int r) {super.setPos(l,r); return this;}
}
