package in.iitd.mldev.core.parse.ast;

public class SharingDesc extends Desc {
	public Ident[] idents;
	public boolean strs;
	public SharingDesc (java.util.List ids, boolean s) {idents = (Ident[]) ids.toArray(new Ident[0]); strs = s;}
}
