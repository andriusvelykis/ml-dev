package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class OpenDec extends Dec {
	public final List<Ident> idents;

	public OpenDec(List<Ident> l) {
		idents = copyList(l);
	}
}
