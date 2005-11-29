package in.iitd.mldev.core.parse.ast;

public class FctBind extends Bind {
	public Ident ident; public ParamDesc[] params; public Sig sig; public Str str;
	public boolean opaque = false;
	private void initialise (Ident id, java.util.List pd, Str s) {ident = id; params = (ParamDesc[]) pd.toArray(new ParamDesc[0]); str = s;}
	public FctBind (Ident id, java.util.List pd, Str s) {initialise(id,pd,s);}
	public FctBind (Ident id, java.util.List pd, Sig sg, Str s) {initialise(id,pd,s); sig = sg;}
	public FctBind (Ident id, java.util.List pd, Sig sg, Str s, boolean o) {initialise(id,pd,s); sig = sg; opaque = o;}
}
