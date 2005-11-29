package in.iitd.mldev.core.parse.ast;

public class DatatypeDec extends Dec {
	public DatatypeBind[] bindings; public TypeBind[] typebinds;
	public DatatypeDec (java.util.List dbs) {
		bindings = (DatatypeBind[]) dbs.toArray(new DatatypeBind[0]);
		typebinds = new TypeBind[0];
	}
	public DatatypeDec (java.util.List dbs, java.util.List tbs) {
		bindings = (DatatypeBind[]) dbs.toArray(new DatatypeBind[0]);
		typebinds = (TypeBind[])tbs.toArray(new TypeBind[0]);
	}
}
