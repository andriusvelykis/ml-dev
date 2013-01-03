package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class BaseStr extends Str {
	public final List<Dec> decs;

	public BaseStr(List<Dec> ds) {
		decs = copyList(ds);
	}
}
