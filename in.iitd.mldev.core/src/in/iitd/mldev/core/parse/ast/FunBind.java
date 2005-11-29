package in.iitd.mldev.core.parse.ast;

public class FunBind extends Bind {
	public Clause[] clauses;
	public boolean lazy = false;
	public FunBind (java.util.List cs) {clauses = (Clause[])cs.toArray(new Clause[0]);}
	public FunBind (java.util.List cs, boolean l) {clauses = (Clause[])cs.toArray(new Clause[0]); lazy = l;}
}
