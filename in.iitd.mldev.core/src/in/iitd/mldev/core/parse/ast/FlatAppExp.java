package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class FlatAppExp extends Exp {
	public final List<Exp> exps;

	public FlatAppExp(List<Exp> es) {
		exps = copyList(es);
	}
}
