package in.iitd.mldev.core.parse.ast;

public class DatatypeSpec extends Spec {
	public DatatypeBind[] bindings; public TypeBind[] typebinds;
	public DatatypeSpec (java.util.List dbs) {
		bindings = (DatatypeBind[]) dbs.toArray(new DatatypeBind[0]);
		typebinds = new TypeBind[0];
	}
	public DatatypeSpec (java.util.List dbs, java.util.List tbs) {
		bindings = (DatatypeBind[]) dbs.toArray(new DatatypeBind[0]);
		typebinds = (TypeBind[])tbs.toArray(new TypeBind[0]);
	}
}
