package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class ValDec extends Dec {
	public final List<ValBind> bindings;
	public final List<Ident> tyvars;

	public ValDec(List<ValBind> vbs) {
		bindings = copyList(vbs);
		tyvars = null;
	}

	public ValDec(List<ValBind> vbs, List<Ident> tvs) {
		bindings = copyList(vbs);
		tyvars = copyList(tvs);
	}
}
