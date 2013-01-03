package in.iitd.mldev.core.parse.ast;

import java.util.Collections;
import java.util.List;

public class AbstypeDec extends Dec {

	public final List<DatatypeBind> bindings;
	public final List<TypeBind> typebinds;
	public final List<Dec> decs;

	public AbstypeDec(List<DatatypeBind> dbs, List<Dec> ds) {
		this(dbs, Collections.<TypeBind> emptyList(), ds);
	}

	public AbstypeDec(List<DatatypeBind> dbs, List<TypeBind> tbs, List<Dec> ds) {
		bindings = copyList(dbs);
		typebinds = copyList(tbs);
		decs = copyList(ds);
	}
}
