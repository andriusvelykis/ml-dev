package in.iitd.mldev.core.parse.ast;

public class RaiseExp extends Exp {
    public Exp exn;
    public RaiseExp (Exp e) {exn = e;}
}
