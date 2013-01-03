package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class LetExp extends Exp {
	public final List<Dec> decs;
	public final Exp exp;

	public LetExp(List<Dec> ds, Exp e) {
		decs = copyList(ds);
		exp = e;
	}
}
