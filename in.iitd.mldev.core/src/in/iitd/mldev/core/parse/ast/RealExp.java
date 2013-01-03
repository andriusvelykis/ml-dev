package in.iitd.mldev.core.parse.ast;

public class RealExp extends Exp {
	public float value;

	public RealExp(Float f) {
		value = f.floatValue();
	}
}
