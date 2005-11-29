package in.iitd.mldev.core.parse.ast;

public class FixityDec extends Dec {
	public Fixity fixity; public Ident[] idents;
	public FixityDec (Fixity f, java.util.List ids) {fixity = f; idents = (Ident[])ids.toArray(new Ident[0]);}
}
