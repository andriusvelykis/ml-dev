package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class FixitySpec extends Spec {
	public final Fixity fixity;
	public final List<Ident> idents;

	public FixitySpec(Fixity f, List<Ident> ids) {
		fixity = f;
		idents = copyList(ids);
	}

}
