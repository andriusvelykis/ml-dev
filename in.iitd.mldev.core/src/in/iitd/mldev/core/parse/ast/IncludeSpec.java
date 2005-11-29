package in.iitd.mldev.core.parse.ast;

public class IncludeSpec extends Spec {
	public Ident[] idents; public Sig sig;
	public IncludeSpec (java.util.List l) {idents = (Ident[]) l.toArray(new Ident[0]); sig = null;}
	public IncludeSpec (Sig s) {idents = null; sig = s;}
}
