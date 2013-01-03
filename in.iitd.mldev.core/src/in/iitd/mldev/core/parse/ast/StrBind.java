package in.iitd.mldev.core.parse.ast;

public class StrBind extends Bind {
	public final Ident ident;
	public final Str str;
	public final Sig sig;
	public boolean signed = false;
	public final boolean opaque;

	public StrBind(Ident id, Str s) {
		this(id, s, null);
	}

	public StrBind(Ident id, Str s, Sig sg) {
		this(id, s, sg, false);
	}

	public StrBind(Ident id, Str s, Sig sg, boolean o) {
		ident = id;
		sig = sg;
		str = s;
		opaque = o;
	}
}
