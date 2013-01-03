package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class FctDec extends Dec {
	public final List<FctBind> bindings;

	public FctDec(List<FctBind> l) {
		bindings = copyList(l);
	}
}
