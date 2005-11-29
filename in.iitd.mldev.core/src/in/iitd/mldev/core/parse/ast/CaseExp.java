package in.iitd.mldev.core.parse.ast;

public class CaseExp extends Exp {
    public Exp exp; public Match match;
    public CaseExp (Exp e, Match m) {exp = e; match = m;}
}
