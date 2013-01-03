package in.iitd.mldev.core.parse.ast;

public class RecValBind extends Bind {
	public final Ident ident;
	public final Type constraint;
	public final Exp exp;
	public boolean lazy = false;

	public RecValBind(Ident id, Type c, Exp e) {
		ident = id;
		constraint = c;
		exp = e;
	}

	public RecValBind(Ident id, Type c, Exp e, boolean l) {
		ident = id;
		constraint = c;
		exp = e;
		lazy = l;
	}
}
