package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class TypeDesc extends Desc {
	public final List<Ident> tyvars;
	public final Ident ident;
	public final Type equals;

	public TypeDesc(List<Ident> tvs, Ident id) {
		tyvars = copyList(tvs);
		ident = id;
		equals = null;
	}

	public TypeDesc(List<Ident> tvs, Ident id, Type t) {
		tyvars = copyList(tvs);
		ident = id;
		equals = t;
	}
}
