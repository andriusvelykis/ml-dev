package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class FunDec extends Dec {
	public final List<FunBind> bindings;

	public FunDec(List<FunBind> l) {
		bindings = copyList(l);
	}
}
