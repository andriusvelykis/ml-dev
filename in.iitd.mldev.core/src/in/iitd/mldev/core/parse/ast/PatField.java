package in.iitd.mldev.core.parse.ast;

public class PatField extends Field {
	public Label label; public Pat pat;
	public PatField (Label l, Pat p) {label = l; pat = p;}
}
