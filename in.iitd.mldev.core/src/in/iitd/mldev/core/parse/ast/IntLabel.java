package in.iitd.mldev.core.parse.ast;

public class IntLabel extends Label {
	public int value;

	public IntLabel(Integer i) {
		value = i.intValue();
	}
}
