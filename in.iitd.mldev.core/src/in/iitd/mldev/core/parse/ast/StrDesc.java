package in.iitd.mldev.core.parse.ast;

public class StrDesc extends Desc {
	public Ident ident; public Sig sig; public Ident equals;
	public StrDesc (Ident id, Sig s) {ident = id; sig = s; equals = null;}
	public StrDesc (Ident id1, Sig s, Ident id2) {ident = id1; sig = s; equals = id2;}
}
