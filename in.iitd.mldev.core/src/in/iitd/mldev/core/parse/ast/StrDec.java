package in.iitd.mldev.core.parse.ast;

public class StrDec extends Dec {
	public StrBind[] bindings;
	public StrDec (java.util.List sbs) {bindings = (StrBind[]) sbs.toArray(new StrBind[0]);}
}
