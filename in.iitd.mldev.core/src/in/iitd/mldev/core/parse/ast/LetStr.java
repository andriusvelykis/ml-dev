package in.iitd.mldev.core.parse.ast;

public class LetStr extends Str {
	public Dec[] decs; public Str str;
	public LetStr (java.util.List ds, Str s) {decs = (Dec[]) ds.toArray(new Dec[0]); str = s;}
}
