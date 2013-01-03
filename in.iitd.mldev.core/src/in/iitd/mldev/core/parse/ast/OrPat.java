package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class OrPat extends Pat {
	public final List<Pat> pats;

	public OrPat(List<Pat> l) {
		pats = copyList(l);
	}
}
