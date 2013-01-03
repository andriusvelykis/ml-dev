package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class TupleType extends Type {
	public final List<Type> types;

	public TupleType(List<Type> l) {
		types = copyList(l);
	}
}
