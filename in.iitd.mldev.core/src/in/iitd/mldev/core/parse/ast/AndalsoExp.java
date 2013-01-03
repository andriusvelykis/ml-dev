package in.iitd.mldev.core.parse.ast;

public class AndalsoExp extends Exp {
	public final Exp exp1, exp2;

	public AndalsoExp(Exp e1, Exp e2) {
		exp1 = e1;
		exp2 = e2;
	}
}
