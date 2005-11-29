package in.iitd.mldev.core.parse.ast;

public abstract class Str extends AST {
	public Str mark (int l, int r) {super.setPos(l,r); return this;}
}
