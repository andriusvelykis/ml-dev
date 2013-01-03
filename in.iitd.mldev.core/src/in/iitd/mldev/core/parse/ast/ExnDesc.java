package in.iitd.mldev.core.parse.ast;

public class ExnDesc extends Desc {
	public final Ident ident;
	public final Type type;

	public ExnDesc(Ident id) {
		ident = id;
		type = null;
	}

	public ExnDesc(Ident id, Type t) {
		ident = id;
		type = t;
	}
}
