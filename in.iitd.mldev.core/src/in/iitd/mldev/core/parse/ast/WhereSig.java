package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class WhereSig extends Sig {
	public final Sig sig;
	public final List<Whspec> where;

	public WhereSig(Sig s, List<Whspec> ws) {
		sig = s;
		where = copyList(ws);
	}
}
