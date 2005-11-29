package in.iitd.mldev.core.parse.ast;

public class ConBind extends Bind {
	public Ident ident; public Type type;
	public boolean isOf = false;
	public ConBind (Ident id) {ident = id;}
	public ConBind (Ident id, Type t) {ident = id; type = t; isOf = true;}
}
