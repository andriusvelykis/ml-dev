package in.iitd.mldev.core.parse.ast;

public class IfExp extends Exp {
	public final Exp ifexp, thenexp, elseexp;

	public IfExp(Exp e1, Exp e2, Exp e3) {
		ifexp = e1;
		thenexp = e2;
		elseexp = e3;
	}
}
