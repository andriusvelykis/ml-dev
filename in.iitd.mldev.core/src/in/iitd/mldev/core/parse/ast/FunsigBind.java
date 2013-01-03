package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class FunsigBind extends Bind {
	public final Ident ident;
	public final List<ParamDesc> params;
	public final Sig sig;

	public FunsigBind(Ident id, List<ParamDesc> pds, Sig s) {
		ident = id;
		params = copyList(pds);
		sig = s;
	}
}
