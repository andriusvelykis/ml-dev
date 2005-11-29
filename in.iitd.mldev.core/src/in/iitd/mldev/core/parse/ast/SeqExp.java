package in.iitd.mldev.core.parse.ast;

public class SeqExp extends Exp {
    public Exp[] exps;
    public SeqExp (java.util.List es) {exps = (Exp[]) es.toArray(new Exp[0]);}
}
