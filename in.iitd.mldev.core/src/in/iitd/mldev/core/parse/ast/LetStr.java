package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class LetStr extends Str {
	public final List<Dec> decs;
	public final Str str;

	public LetStr(List<Dec> ds, Str s) {
		decs = copyList(ds);
		str = s;
	}
}
