package in.iitd.mldev.core.parse.ast;

public class ExpField extends Field {
	public final Label label;
	public final Exp exp;

	public ExpField(Label l, Exp e) {
		label = l;
		exp = e;
	}
}
