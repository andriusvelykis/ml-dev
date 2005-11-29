package in.iitd.mldev.core.parse.ast;

public class DatatypeBind extends Bind {
	public Ident[] tyvars; public Ident ident; public ConBind[] cons; public Ident equals;
	public boolean isRep = false, lazy;
	private void initialise (java.util.List tvs, Ident id) {
		tyvars = (Ident[]) tvs.toArray(new Ident[0]);
		ident = id;
	}
	public DatatypeBind (java.util.List tvs, Ident id, java.util.List cbs) {initialise(tvs,id); cons = (ConBind[]) cbs.toArray(new ConBind[0]);}
	public DatatypeBind (java.util.List tvs, Ident id, java.util.List cbs, boolean l) {initialise(tvs,id); cons = (ConBind[]) cbs.toArray(new ConBind[0]); lazy = l;}
	public DatatypeBind (java.util.List tvs, Ident id, Ident tc) {initialise(tvs,id); equals = tc; isRep = true;}
	public DatatypeBind (java.util.List tvs, Ident id, Ident tc, boolean l) {initialise(tvs,id); equals = tc; isRep = true; lazy = l;}
}
