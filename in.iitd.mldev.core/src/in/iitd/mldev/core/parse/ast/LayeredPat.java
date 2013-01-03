package in.iitd.mldev.core.parse.ast;

public class LayeredPat extends Pat {
	public final Pat pat1, pat2;

	public LayeredPat(Pat p1, Pat p2) {
		pat1 = p1;
		pat2 = p2;
	}
}
