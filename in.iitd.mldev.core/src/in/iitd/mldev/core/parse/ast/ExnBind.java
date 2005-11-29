package in.iitd.mldev.core.parse.ast;

public class ExnBind extends Bind {
	public Ident ident; public Type type; public Ident equals;
	public boolean isNew;
	public ExnBind (Ident id) {ident = id; type = null; equals = null; isNew = true;}
	public ExnBind (Ident id, Type t) {ident = id; type = t; equals = null; isNew = true;}
	public ExnBind (Ident id, Ident id2) {ident = id; type = null; equals = id2; isNew = false;}
}
