package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class FlatConPat extends Pat {
	public final List<Pat> pats;

	public FlatConPat(List<Pat> ps) {
		pats = copyList(ps);
	}
}
