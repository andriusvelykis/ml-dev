package in.iitd.mldev.core.parse.ast;

public class HandleExp extends Exp {
	public final Exp exp;
	public final Match match;

	public HandleExp(Exp e, Match m) {
		exp = e;
		match = m;
	}
}
