package in.iitd.mldev.core.parse.ast;

public class BaseStr extends Str {
	public Dec[] decs;
	public BaseStr (java.util.List ds) {decs = (Dec[]) ds.toArray(new Dec[0]);}
}
