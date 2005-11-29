package in.iitd.mldev.core.parse.ast;

public class SigDec extends Dec {
	public SigBind[] bindings;
	public SigDec (java.util.List sbs) {bindings = (SigBind[]) sbs.toArray(new SigBind[0]);}
}
