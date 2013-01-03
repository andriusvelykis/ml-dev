package in.iitd.mldev.core.parse.ast;

import java.util.Collections;
import java.util.List;

public class DatatypeBind extends Bind {
	public final List<Ident> tyvars;
	public final Ident ident;
	public final List<ConBind> cons;
	public final Ident equals;
	public final boolean isRep;
	public final boolean lazy;

	public DatatypeBind(List<Ident> tvs, Ident id, List<ConBind> cbs) {
		this(tvs, id, cbs, false);
	}

	public DatatypeBind(List<Ident> tvs, Ident id, List<ConBind> cbs, boolean l) {
		this(tvs, id, cbs, null, false, l);
	}

	public DatatypeBind(List<Ident> tvs, Ident id, Ident tc) {
		this(tvs, id, tc, false);
	}

	public DatatypeBind(List<Ident> tvs, Ident id, Ident tc, boolean l) {
		this(tvs, id, Collections.<ConBind> emptyList(), tc, true, l);
	}

	private DatatypeBind(List<Ident> tvs, Ident id, List<ConBind> cbs, Ident tc, boolean r,
			boolean l) {
		tyvars = copyList(tvs);
		ident = id;
		cons = copyList(cbs);
		equals = tc;
		isRep = r;
		lazy = l;
	}
}
