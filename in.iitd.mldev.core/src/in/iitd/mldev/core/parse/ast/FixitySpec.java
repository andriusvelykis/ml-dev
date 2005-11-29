package in.iitd.mldev.core.parse.ast;

public class FixitySpec extends Spec {
	public Fixity fixity; public Ident[] idents;
	public FixitySpec (Fixity f, java.util.List ids) {fixity = f; idents = (Ident[])ids.toArray(new Ident[0]);}

}
