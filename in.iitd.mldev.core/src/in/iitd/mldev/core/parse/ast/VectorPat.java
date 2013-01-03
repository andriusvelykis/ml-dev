package in.iitd.mldev.core.parse.ast;

import java.util.Collections;
import java.util.List;

public class VectorPat extends Pat {
	public final List<Pat> pats;

	public VectorPat(List<Pat> l) {
		pats = copyList(l);
	}

	public VectorPat() {
		this(Collections.<Pat> emptyList());
	}
}
