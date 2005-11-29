package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class AbstypeDec extends Dec {
	public DatatypeBind[] bindings; public TypeBind[] typebinds; public Dec[] decs;
	public AbstypeDec (List dbs, List ds) {
		bindings = (DatatypeBind[]) dbs.toArray(new DatatypeBind[0]);
		typebinds = new TypeBind[0];
		decs = (Dec[]) ds.toArray(new Dec[0]);
	}
	public AbstypeDec (List dbs, List tbs, List ds) {
		bindings = (DatatypeBind[]) dbs.toArray(new DatatypeBind[0]);
		typebinds = (TypeBind[])tbs.toArray(new TypeBind[0]);
		decs = (Dec[]) ds.toArray(new Dec[0]);
	}
}
