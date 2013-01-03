package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class TupleExp extends Exp {
	public final List<Exp> exps;

	public TupleExp(List<Exp> l) {
		exps = copyList(l);
	}
}
