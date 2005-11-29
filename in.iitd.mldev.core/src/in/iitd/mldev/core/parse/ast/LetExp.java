package in.iitd.mldev.core.parse.ast;

public class LetExp extends Exp {
    public Dec[] decs; public Exp exp;
    public LetExp (java.util.List ds, Exp e) {decs = (Dec[]) ds.toArray(new Dec[0]); exp = e;}
}
