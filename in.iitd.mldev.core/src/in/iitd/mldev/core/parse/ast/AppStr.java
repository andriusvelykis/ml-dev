package in.iitd.mldev.core.parse.ast;

public class AppStr extends Str {
	public Ident functor; public Str[] args;
	public AppStr (Ident id, java.util.List fas) {functor = id; args = (Str[]) fas.toArray(new Str[0]);}
}
