package in.iitd.mldev.core.parse.ast;

public class RecValDec extends Dec {
	public RecValBind[] bindings; public Ident[] tyvars;
	public RecValDec (java.util.List rvbs) {
		bindings = (RecValBind[])rvbs.toArray(new RecValBind[0]);
		tyvars = null;
	}
	public RecValDec (java.util.List rvbs, java.util.List tvs) {
		bindings = (RecValBind[])rvbs.toArray(new RecValBind[0]);
		tyvars = (Ident[])tvs.toArray(new Ident[0]);
	}
}
