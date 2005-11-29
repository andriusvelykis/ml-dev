package in.iitd.mldev.core.parse.ast;

public class OrPat extends Pat {
	public Pat[] pats;
	public OrPat (java.util.List l) {pats = (Pat[]) l.toArray(new Pat[0]);}
}
