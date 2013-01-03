package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class FixityDec extends Dec {
	public final Fixity fixity;
	public final List<Ident> idents;

	public FixityDec(Fixity f, List<Ident> ids) {
		fixity = f;
		idents = copyList(ids);
	}
}
