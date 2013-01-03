package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class FunBind extends Bind {
	public final List<Clause> clauses;
	public boolean lazy = false;

	public FunBind(List<Clause> cs) {
		clauses = copyList(cs);
	}

	public FunBind(List<Clause> cs, boolean l) {
		clauses = copyList(cs);
		lazy = l;
	}
}
