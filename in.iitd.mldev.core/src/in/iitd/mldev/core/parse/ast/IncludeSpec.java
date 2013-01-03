package in.iitd.mldev.core.parse.ast;

import java.util.Collections;
import java.util.List;

public class IncludeSpec extends Spec {
	public final List<Ident> idents;
	public final Sig sig;

	public IncludeSpec(List<Ident> l) {
		this(l, null);
	}

	public IncludeSpec(Sig s) {
		this(Collections.<Ident>emptyList(), s);
	}
	
	private IncludeSpec(List<Ident> l, Sig s) {
		idents = copyList(l);
		sig = s;
	}
}
