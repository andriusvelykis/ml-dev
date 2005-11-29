package in.iitd.mldev.core.parse.ast;

public class ConType extends Type {
	public Type[] types; public Ident ident;
	public ConType (java.util.List l, Ident id) {types = (Type[])l.toArray(new Type[0]); ident = id;}
	public ConType (Type t, Ident id) {types = new Type[]{t}; ident = id;}
	public ConType (Ident id) {types = new Type[0]; ident = id;}
}
