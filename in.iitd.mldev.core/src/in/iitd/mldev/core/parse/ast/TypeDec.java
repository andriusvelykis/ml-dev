package in.iitd.mldev.core.parse.ast;

public class TypeDec extends Dec {
	public TypeBind[] bindings;
	public TypeDec (java.util.List l) {bindings = (TypeBind[])l.toArray(new TypeBind[0]);}
}
