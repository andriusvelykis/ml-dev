package in.iitd.mldev.core.parse.ast;

public class IntPat extends Pat {
	public int value;

	public IntPat(Integer i) {
		value = i.intValue();
	}
}
