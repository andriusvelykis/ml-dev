package in.iitd.mldev.core.parse.ast;

public class PatField extends Field {
	public final Label label;
	public final Pat pat;

	public PatField(Label l, Pat p) {
		label = l;
		pat = p;
	}
}
