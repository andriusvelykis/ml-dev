package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class TuplePat extends Pat {
	public final List<Pat> pats;

	public TuplePat(List<Pat> l) {
		pats = copyList(l);
	}
}
