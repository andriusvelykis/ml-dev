package in.iitd.mldev.core.parse.ast;

public class ExnDec extends Dec {
	public ExnBind[] bindings;
	public ExnDec (java.util.List l) {bindings = (ExnBind[])l.toArray(new ExnBind[0]);}
}
