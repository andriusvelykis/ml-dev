package in.iitd.mldev.core.parse.ast;

public class Match extends AST {
    public Rule[] rules;
    public Match (java.util.List rs) {rules = (Rule[]) rs.toArray(new Rule[0]);}
	public Match mark (int l, int r) {super.setPos(l,r); return this;}
}
