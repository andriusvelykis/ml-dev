package in.iitd.mldev.core.parse.ast;

import java.util.Collections;
import java.util.List;

public class DatatypeSpec extends Spec {
	public final List<DatatypeBind> bindings;
	public final List<TypeBind> typebinds;

	public DatatypeSpec(List<DatatypeBind> dbs) {
		this(dbs, Collections.<TypeBind> emptyList());
	}

	public DatatypeSpec(List<DatatypeBind> dbs, List<TypeBind> tbs) {
		bindings = copyList(dbs);
		typebinds = copyList(tbs);
	}
}
