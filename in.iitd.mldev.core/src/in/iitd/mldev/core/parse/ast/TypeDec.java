package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class TypeDec extends Dec {
	public final List<TypeBind> bindings;

	public TypeDec(List<TypeBind> l) {
		bindings = copyList(l);
	}
}
