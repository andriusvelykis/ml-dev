package in.iitd.mldev.core.parse.ast;

import java.util.Collections;
import java.util.List;

/**
 * The root of the parse tree. Its children are the top-level declarations in the program.
 */
public class ASTRoot extends AST {
	public final List<Dec> decs;

	public ASTRoot() {
		this(Collections.<Dec> emptyList());
	}

	public ASTRoot(List<Dec> ds) {
		decs = copyList(ds);
	}
}
