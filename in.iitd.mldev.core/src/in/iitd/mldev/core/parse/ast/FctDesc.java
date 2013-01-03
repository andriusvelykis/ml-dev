package in.iitd.mldev.core.parse.ast;

import java.util.Collections;
import java.util.List;

public class FctDesc extends Desc {
	public final Ident ident;
	public final List<ParamDesc> params;
	public final Ident sig;

	public FctDesc(Ident id1, Ident id2) {
		this(id1, Collections.<ParamDesc> emptyList(), id2);
	}

	public FctDesc(Ident id1, List<ParamDesc> pd, Ident id2) {
		ident = id1;
		params = copyList(pd);
		sig = id2;
	}
}
