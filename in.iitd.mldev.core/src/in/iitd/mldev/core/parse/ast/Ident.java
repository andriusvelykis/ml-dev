package in.iitd.mldev.core.parse.ast;

import java.util.Collections;
import java.util.List;

public class Ident extends AST {
	public final List<String> qualifier;
	public final String name;

	public Ident(String id) {
		this(Collections.<String> emptyList(), id);
	}

	public Ident(List<String> q, String id) {
		name = id;
		qualifier = copyList(q);
	}
}
