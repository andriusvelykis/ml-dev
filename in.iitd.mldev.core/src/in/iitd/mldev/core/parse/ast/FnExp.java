package in.iitd.mldev.core.parse.ast;

public class FnExp extends Exp {
	public final Match match;

	public FnExp(Match m) {
		match = m;
	}
}
