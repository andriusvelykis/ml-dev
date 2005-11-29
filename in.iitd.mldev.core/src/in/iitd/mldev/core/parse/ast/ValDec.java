package in.iitd.mldev.core.parse.ast;

public class ValDec extends Dec {
	public ValBind[] bindings; public Ident[] tyvars;
	public ValDec (java.util.List vbs) {
		bindings = (ValBind[])vbs.toArray(new ValBind[0]);
		tyvars = null;
	}
	public ValDec (java.util.List vbs, java.util.List tvs) {
		bindings = (ValBind[])vbs.toArray(new ValBind[0]);
		tyvars = (Ident[])tvs.toArray(new Ident[0]);
	}
}
