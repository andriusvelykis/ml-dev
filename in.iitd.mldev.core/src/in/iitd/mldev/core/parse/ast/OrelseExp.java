package in.iitd.mldev.core.parse.ast;

public class OrelseExp extends Exp {
	public final Exp exp1, exp2;

	public OrelseExp(Exp e1, Exp e2) {
		exp1 = e1;
		exp2 = e2;
	}
}
