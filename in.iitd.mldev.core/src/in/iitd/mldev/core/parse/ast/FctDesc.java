package in.iitd.mldev.core.parse.ast;

public class FctDesc extends Desc {
	public Ident ident; public ParamDesc[] params; public Ident sig;
	public FctDesc (Ident id1, Ident id2) {ident = id1; params = new ParamDesc[0]; sig = id2;}
	public FctDesc (Ident id1, java.util.List pd, Ident id2) {ident = id1; params = (ParamDesc[]) pd.toArray(new ParamDesc[0]); sig = id2;}
}
