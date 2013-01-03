package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class BaseSig extends Sig {
	public final List<Spec> specs;

	public BaseSig(List<Spec> ss) {
		specs = copyList(ss);
	}
}
