package in.iitd.mldev.core.parse.ast;

import java.util.Collections;
import java.util.List;

public class ListExp extends Exp {
	public final List<Exp> exps;

	public ListExp(List<Exp> l) {
		exps = copyList(l);
	}

	public ListExp() {
		this(Collections.<Exp> emptyList());
	}
}
