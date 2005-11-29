package in.iitd.mldev.core.parse.ast;

public class SigBind extends Bind {
	public Ident ident; public Sig sig;
	public SigBind (Ident id, Sig s) {ident = id; sig = s;}
}
