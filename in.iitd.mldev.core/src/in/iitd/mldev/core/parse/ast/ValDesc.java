package in.iitd.mldev.core.parse.ast;

public class ValDesc extends Desc {
	public Ident ident; public Type type;
	public ValDesc (Ident id, Type t) {ident = id; type = t;}
}
