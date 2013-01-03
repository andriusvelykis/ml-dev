package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class FctBind extends Bind {
	public final Ident ident;
	public final List<ParamDesc> params;
	public final Sig sig;
	public final Str str;
	public final boolean opaque;

	public FctBind(Ident id, List<ParamDesc> pd, Str s) {
		this(id, pd, null, s);
	}

	public FctBind(Ident id, List<ParamDesc> pd, Sig sg, Str s) {
		this(id, pd, sg, s, false);
	}

	public FctBind(Ident id, List<ParamDesc> pd, Sig sg, Str s, boolean o) {
		ident = id;
		params = copyList(pd);
		str = s;
		sig = sg;
		opaque = o;
	}
}
