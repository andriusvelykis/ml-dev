package in.iitd.mldev.core.parse.ast;

public class FctDec extends Dec {
	public FctBind[] bindings;
	public FctDec (java.util.List l) {bindings = (FctBind[])l.toArray(new FctBind[0]);}
}
