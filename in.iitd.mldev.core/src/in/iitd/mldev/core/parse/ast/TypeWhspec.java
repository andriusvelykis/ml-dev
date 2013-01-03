package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class TypeWhspec extends Whspec {
	public final List<Ident> tyvars;
	public final Ident ident;
	public final Type type;

	public TypeWhspec(List<Ident> tvs, Ident id, Type t) {
		tyvars = copyList(tvs);
		ident = id;
		type = t;
	}
}
