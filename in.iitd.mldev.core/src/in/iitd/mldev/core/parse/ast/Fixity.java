package in.iitd.mldev.core.parse.ast;

public class Fixity extends AST {
	public static final int LEFT = -1, RIGHT = 1, NONE = 0;
	public int assoc, prec;

	public Fixity(int a, Integer p) {
		assoc = a;
		prec = p.intValue();
	}

	public Fixity(int a) {
		assoc = a;
		prec = 0;
	}
}
