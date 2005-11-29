package in.iitd.mldev.core.parse.ast;

public class ListExp extends Exp {
    public Exp[] exps;
    public ListExp (java.util.List l) {exps = (Exp[]) l.toArray(new Exp[0]);}
    public ListExp () {exps = new Exp[0];}
}
