package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class TypeBind extends Bind {
	public final List<Ident> tyvars;
	public final Ident ident;
	public final Type type;

	public TypeBind(List<Ident> tvs, Ident id, Type t) {
		tyvars = copyList(tvs);
		ident = id;
		type = t;
	}
}
