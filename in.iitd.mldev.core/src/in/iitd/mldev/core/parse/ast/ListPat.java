package in.iitd.mldev.core.parse.ast;

public class ListPat extends Pat {
    public Pat[] pats;
    public ListPat (java.util.List l) {pats = (Pat[]) l.toArray(new Pat[0]);}
    public ListPat () {pats = new Pat[0];}
}
