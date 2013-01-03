package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class Match extends AST {
	public final List<Rule> rules;

	public Match(List<Rule> rs) {
		rules = copyList(rs);
	}
}
