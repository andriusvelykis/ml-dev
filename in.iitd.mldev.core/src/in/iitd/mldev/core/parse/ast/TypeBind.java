package in.iitd.mldev.core.parse.ast;

public class TypeBind extends Bind {
	public Ident[] tyvars; public Ident ident; public Type type;
	public TypeBind (java.util.List tvs, Ident id, Type t) {
		tyvars = (Ident[]) tvs.toArray(new Ident[0]);
		ident = id;
		type = t;
	}
}
