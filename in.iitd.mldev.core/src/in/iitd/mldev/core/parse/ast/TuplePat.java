package in.iitd.mldev.core.parse.ast;

public class TuplePat extends Pat {
    public Pat[] pats;
    public TuplePat (java.util.List l) {pats = (Pat[]) l.toArray(new Pat[0]);}
}
