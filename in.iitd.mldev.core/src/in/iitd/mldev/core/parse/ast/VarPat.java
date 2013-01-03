package in.iitd.mldev.core.parse.ast;

public class VarPat extends Pat {
	public final Ident ident;
	public boolean nonfix;

	public VarPat(Ident id) {
		ident = id;
		nonfix = false;
	}

	public VarPat(Ident id, boolean nf) {
		ident = id;
		nonfix = nf;
	}
}
