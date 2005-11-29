package in.iitd.mldev.core.parse.ast;

public class OpenDec extends Dec {
	public Ident[] idents;
	public OpenDec (java.util.List l) {idents = (Ident[])l.toArray(new Ident[0]);}
}
