package in.iitd.mldev.core.parse.ast;

import java.util.Collections;
import java.util.List;

public class ConType extends Type {
	public final List<Type> types;
	public final Ident ident;

	public ConType(List<Type> l, Ident id) {
		types = copyList(l);
		ident = id;
	}

	public ConType(Type t, Ident id) {
		this(Collections.singletonList(t), id);
	}

	public ConType(Ident id) {
		this(Collections.<Type> emptyList(), id);
	}
}
