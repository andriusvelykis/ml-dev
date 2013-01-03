package in.iitd.mldev.core.parse.ast;

public class ValDesc extends Desc {
	public final Ident ident;
	public final Type type;

	public ValDesc(Ident id, Type t) {
		ident = id;
		type = t;
	}
}
