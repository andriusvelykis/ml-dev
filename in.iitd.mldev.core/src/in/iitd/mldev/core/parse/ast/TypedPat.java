package in.iitd.mldev.core.parse.ast;

public class TypedPat extends Pat {
	public Pat pat; public Type type;
	public TypedPat (Pat p, Type t) {pat = p; type = t;}
}
