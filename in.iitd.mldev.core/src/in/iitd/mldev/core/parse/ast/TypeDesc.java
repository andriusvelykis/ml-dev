package in.iitd.mldev.core.parse.ast;

public class TypeDesc extends Desc {
	public Ident[] tyvars; public Ident ident; public Type equals;
	public TypeDesc (java.util.List tvs, Ident id) {tyvars = (Ident[]) tvs.toArray(new Ident[0]); ident = id; equals = null;}
	public TypeDesc (java.util.List tvs, Ident id, Type t) {tyvars = (Ident[]) tvs.toArray(new Ident[0]); ident = id; equals = t;}
}
