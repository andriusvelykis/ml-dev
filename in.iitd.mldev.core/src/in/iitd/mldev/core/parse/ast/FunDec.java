package in.iitd.mldev.core.parse.ast;

public class FunDec extends Dec {
	public FunBind[] bindings;
	public FunDec (java.util.List l) {bindings = (FunBind[])l.toArray(new FunBind[0]);}
}
