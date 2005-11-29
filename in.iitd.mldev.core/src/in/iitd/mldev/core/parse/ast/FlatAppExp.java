package in.iitd.mldev.core.parse.ast;

public class FlatAppExp extends Exp {
    public Exp[] exps;
    public FlatAppExp (java.util.List es) {exps = (Exp[]) es.toArray(new Exp[0]);}
}
