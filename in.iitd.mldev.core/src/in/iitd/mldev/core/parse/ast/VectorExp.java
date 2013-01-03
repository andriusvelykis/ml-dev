package in.iitd.mldev.core.parse.ast;

import java.util.Collections;
import java.util.List;

public class VectorExp extends Exp {
	public final List<Exp> exps;

	public VectorExp(List<Exp> l) {
		exps = copyList(l);
	}

	public VectorExp() {
		this(Collections.<Exp> emptyList());
	}
}
