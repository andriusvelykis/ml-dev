package in.iitd.mldev.core.parse.ast;

public class TupleExp extends Exp {
    public Exp[] exps;
    public TupleExp (java.util.List l) {exps = (Exp[]) l.toArray(new Exp[0]);}
}
