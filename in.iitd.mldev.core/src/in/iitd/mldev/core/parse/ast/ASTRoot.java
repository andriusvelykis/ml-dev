package in.iitd.mldev.core.parse.ast;

/** The root of the parse tree.
 * Its children are the top-level declarations in the program. */
public class ASTRoot extends AST {
	public Dec[] decs;
	public ASTRoot () {decs = new Dec[0];}
	public ASTRoot (java.util.List ds) {decs = (Dec[]) ds.toArray(new Dec[0]);}
	public ASTRoot mark (int l, int r) {super.setPos(l,r); return this;}
}
