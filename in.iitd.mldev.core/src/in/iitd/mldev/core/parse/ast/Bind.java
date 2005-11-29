package in.iitd.mldev.core.parse.ast;

public abstract class Bind extends AST {
	public Bind mark (int l, int r) {super.setPos(l,r); return this;}
}
