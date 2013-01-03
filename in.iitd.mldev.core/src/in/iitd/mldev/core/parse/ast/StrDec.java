package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class StrDec extends Dec {
	public final List<StrBind> bindings;

	public StrDec(List<StrBind> sbs) {
		bindings = copyList(sbs);
	}
}
