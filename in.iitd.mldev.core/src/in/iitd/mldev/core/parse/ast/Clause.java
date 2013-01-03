package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class Clause extends AST {
	public final List<Pat> pats;
	public final Type constraint;
	public final Exp exp;

	public Clause(List<Pat> ps, Type c, Exp e) {
		pats = copyList(ps);
		constraint = c;
		exp = e;
	}
}
