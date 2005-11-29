package in.iitd.mldev.core.parse.ast;

public abstract class Desc extends AST {
	public Desc mark (int l, int r) {super.setPos(l,r); return this;}
}
