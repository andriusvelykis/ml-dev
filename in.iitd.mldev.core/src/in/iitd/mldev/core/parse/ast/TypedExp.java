package in.iitd.mldev.core.parse.ast;

public class TypedExp extends Exp {
	public Exp exp; public Type type;
	public TypedExp (Exp e, Type t) {exp = e; type = t;}
}
