package in.iitd.mldev.core.parse.ast;

public class FunsigDec extends Dec {
	public FunsigBind[] bindings;
	public FunsigDec (java.util.List fsb) {bindings = (FunsigBind[])fsb.toArray(new FunsigBind[0]);}
}
