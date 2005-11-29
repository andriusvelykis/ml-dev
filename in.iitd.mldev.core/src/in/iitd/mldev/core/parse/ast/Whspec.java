package in.iitd.mldev.core.parse.ast;

public abstract class Whspec extends AST {
	public Whspec mark (int l, int r) {super.setPos(l,r); return this;}
}
