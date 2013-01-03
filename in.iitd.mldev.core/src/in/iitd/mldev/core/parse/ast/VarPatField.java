package in.iitd.mldev.core.parse.ast;

public class VarPatField extends Field {
	public final Ident ident;
	public final Type constraint;
	public final Pat aspat;
	public boolean layered = false;

	public VarPatField(Ident id, Type c) {
		ident = id;
		constraint = c;
		aspat = null;
		layered = false;
	}

	public VarPatField(Ident id, Type c, Pat p) {
		ident = id;
		constraint = c;
		aspat = p;
		layered = true;
	}
}
