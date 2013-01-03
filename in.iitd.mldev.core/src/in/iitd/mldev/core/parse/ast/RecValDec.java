package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class RecValDec extends Dec {
	public final List<RecValBind> bindings;
	public final List<Ident> tyvars;

	public RecValDec(List<RecValBind> rvbs) {
		bindings = copyList(rvbs);
		tyvars = null;
	}

	public RecValDec(List<RecValBind> rvbs, List<Ident> tvs) {
		bindings = copyList(rvbs);
		tyvars = copyList(tvs);
	}
}
