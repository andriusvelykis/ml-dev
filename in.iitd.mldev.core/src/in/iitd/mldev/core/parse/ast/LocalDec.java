package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class LocalDec extends Dec {
	public final List<Dec> localdecs, decs;

	public LocalDec(List<Dec> d1, List<Dec> d2) {
		localdecs = copyList(d1);
		decs = copyList(d2);
	}
}
