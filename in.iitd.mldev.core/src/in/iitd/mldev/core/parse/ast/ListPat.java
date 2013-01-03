package in.iitd.mldev.core.parse.ast;

import java.util.Collections;
import java.util.List;

public class ListPat extends Pat {
	public final List<Pat> pats;

	public ListPat(List<Pat> l) {
		pats = copyList(l);
	}

	public ListPat() {
		this(Collections.<Pat> emptyList());
	}
}
