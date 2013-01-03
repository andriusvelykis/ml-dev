package in.iitd.mldev.core.parse.ast;

public class IntExp extends Exp {
	public int value;

	public IntExp(Integer i) {
		value = i.intValue();
	}
}
