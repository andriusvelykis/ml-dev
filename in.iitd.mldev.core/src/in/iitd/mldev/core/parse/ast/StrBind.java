package in.iitd.mldev.core.parse.ast;

public class StrBind extends Bind {
	public Ident ident; public Str str; public Sig sig;
	public boolean signed = false, opaque = false;
	public StrBind (Ident id, Str s) {ident = id; str = s;}
	public StrBind (Ident id, Str s, Sig sg) {ident = id; sig = sg; str = s;}
	public StrBind (Ident id, Str s, Sig sg, boolean o) {ident = id; sig = sg; str = s; opaque = o;}
}
