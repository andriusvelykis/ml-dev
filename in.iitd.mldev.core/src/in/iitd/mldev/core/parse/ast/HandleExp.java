package in.iitd.mldev.core.parse.ast;

public class HandleExp extends Exp {
    public Exp exp; public Match match;
    public HandleExp (Exp e, Match m) {exp = e; match = m;}
}
