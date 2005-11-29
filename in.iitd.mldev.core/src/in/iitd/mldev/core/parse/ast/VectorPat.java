package in.iitd.mldev.core.parse.ast;

public class VectorPat extends Pat {
    public Pat[] pats;
    public VectorPat (java.util.List l) {pats = (Pat[]) l.toArray(new Pat[0]);}
    public VectorPat () {pats = new Pat[0];}
}
