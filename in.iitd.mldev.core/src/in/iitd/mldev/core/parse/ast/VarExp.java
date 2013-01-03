package in.iitd.mldev.core.parse.ast;

public class VarExp extends Exp {
	public final Ident ident;
	public boolean nonfix;

	public VarExp(Ident id) {
		ident = id;
		nonfix = false;
	}

	public VarExp(Ident id, boolean nf) {
		ident = id;
		nonfix = nf;
	}
}
