package in.iitd.mldev.core.parse.ast;

public class FnType extends Type {
	public Type arg, result;
	public FnType (Type t1, Type t2) {arg = t1; result = t2;}
}
