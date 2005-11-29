package in.iitd.mldev.core.parse.ast;

public class FlatConPat extends Pat {
	public Pat[] pats;
	public FlatConPat (java.util.List ps) {pats = (Pat[])ps.toArray(new Pat[0]);}
}
