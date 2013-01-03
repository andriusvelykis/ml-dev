package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class ExnDec extends Dec {
	public final List<ExnBind> bindings;

	public ExnDec(List<ExnBind> l) {
		bindings = copyList(l);
	}
}
