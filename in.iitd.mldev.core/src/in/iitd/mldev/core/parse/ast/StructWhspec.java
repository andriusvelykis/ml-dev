package in.iitd.mldev.core.parse.ast;

public class StructWhspec extends Whspec {
	public final Ident ident, equals;

	public StructWhspec(Ident id1, Ident id2) {
		ident = id1;
		equals = id2;
	}
}
