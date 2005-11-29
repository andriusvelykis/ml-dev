package in.iitd.mldev.core.parse.ast;

public class FunsigBind extends Bind {
	public Ident ident; public ParamDesc[] params; public Sig sig;
	public FunsigBind (Ident id, java.util.List pds, Sig s) {ident = id; params = (ParamDesc[]) pds.toArray(new ParamDesc[0]); sig = s;}
}
