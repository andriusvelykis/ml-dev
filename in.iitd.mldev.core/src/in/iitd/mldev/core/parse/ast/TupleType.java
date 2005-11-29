package in.iitd.mldev.core.parse.ast;

public class TupleType extends Type {
	public Type[] types;
	public TupleType (java.util.List l) {types = (Type[])l.toArray(new Type[0]);}
}
