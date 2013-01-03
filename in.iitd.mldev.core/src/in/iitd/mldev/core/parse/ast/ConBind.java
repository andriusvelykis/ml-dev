package in.iitd.mldev.core.parse.ast;

public class ConBind extends Bind {
	public final Ident ident;
	public final Type type;
	public boolean isOf = false;

	public ConBind(Ident id) {
		this(id, null);
	}

	public ConBind(Ident id, Type t) {
		ident = id;
		type = t;
		isOf = true;
	}
}
