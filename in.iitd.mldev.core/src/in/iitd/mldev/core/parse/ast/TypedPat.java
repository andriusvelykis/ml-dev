package in.iitd.mldev.core.parse.ast;

public class TypedPat extends Pat {
	public final Pat pat;
	public final Type type;

	public TypedPat(Pat p, Type t) {
		pat = p;
		type = t;
	}
}
