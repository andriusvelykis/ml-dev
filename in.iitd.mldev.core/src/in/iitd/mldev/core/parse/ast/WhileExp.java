package in.iitd.mldev.core.parse.ast;

public class WhileExp extends Exp {
	public final Exp whileexp, doexp;

	public WhileExp(Exp e1, Exp e2) {
		whileexp = e1;
		doexp = e2;
	}
}
