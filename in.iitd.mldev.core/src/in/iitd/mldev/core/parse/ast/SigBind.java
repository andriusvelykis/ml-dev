package in.iitd.mldev.core.parse.ast;

public class SigBind extends Bind {
	public final Ident ident;
	public final Sig sig;

	public SigBind(Ident id, Sig s) {
		ident = id;
		sig = s;
	}
}
