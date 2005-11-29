package in.iitd.mldev.core.parse.ast;

public class VectorExp extends Exp {
    public Exp[] exps;
    public VectorExp (java.util.List l) {exps = (Exp[]) l.toArray(new Exp[0]);}
    public VectorExp () {exps = new Exp[0];}
}
