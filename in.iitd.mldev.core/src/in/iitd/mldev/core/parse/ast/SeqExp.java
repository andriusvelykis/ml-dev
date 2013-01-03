package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class SeqExp extends Exp {
	public final List<Exp> exps;

	public SeqExp(List<Exp> es) {
		exps = copyList(es);
	}
}
