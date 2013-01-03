package in.iitd.mldev.core.parse.ast;

public class ParamDesc extends Desc {
	public final Ident ident;
	public final Sig sig;

	public ParamDesc(Ident id, Sig s) {
		ident = id;
		sig = s;
	}

	public ParamDesc(Sig s) {
		ident = null;
		sig = s;
	}
}
