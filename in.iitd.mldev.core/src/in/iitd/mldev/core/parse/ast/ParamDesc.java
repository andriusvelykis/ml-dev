package in.iitd.mldev.core.parse.ast;

public class ParamDesc extends Desc {
	public Ident ident; public Sig sig;
	public ParamDesc (Ident id, Sig s) {ident = id; sig = s;}
	public ParamDesc (Sig s) {ident = null; sig = s;}
}
