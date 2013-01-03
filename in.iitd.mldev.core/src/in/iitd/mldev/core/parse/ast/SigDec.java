package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class SigDec extends Dec {
	public final List<SigBind> bindings;

	public SigDec(List<SigBind> sbs) {
		bindings = copyList(sbs);
	}
}
