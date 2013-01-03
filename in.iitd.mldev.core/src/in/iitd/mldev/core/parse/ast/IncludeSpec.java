package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class IncludeSpec extends Spec {
	public final List<Ident> idents;
	public final Sig sig;

	public IncludeSpec(List<Ident> l) {
		idents = copyList(l);
		sig = null;
	}

	public IncludeSpec(Sig s) {
		idents = null;
		sig = s;
	}
}
