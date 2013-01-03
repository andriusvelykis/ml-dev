package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class AppStr extends Str {
	public final Ident functor;
	public final List<Str> args;

	public AppStr(Ident id, List<Str> fas) {
		functor = id;
		args = copyList(fas);
	}
}
