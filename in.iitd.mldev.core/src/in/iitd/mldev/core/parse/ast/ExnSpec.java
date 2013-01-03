package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class ExnSpec extends Spec {
	public final List<ExnDesc> descs;

	public ExnSpec(List<ExnDesc> ed) {
		descs = copyList(ed);
	}
}
