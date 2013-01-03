package in.iitd.mldev.core.parse.ast;

public class TypeField extends Field {
	public final Label label;
	public final Type type;

	public TypeField(Label l, Type t) {
		label = l;
		type = t;
	}
}
