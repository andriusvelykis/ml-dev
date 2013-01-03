package in.iitd.mldev.core.parse.ast;

public class SelectorExp extends Exp {
	public final Label label;

	public SelectorExp(Label l) {
		label = l;
	}
}
