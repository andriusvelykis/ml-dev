package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class FunsigDec extends Dec {
	public final List<FunsigBind> bindings;

	public FunsigDec(List<FunsigBind> fsb) {
		bindings = copyList(fsb);
	}
}
