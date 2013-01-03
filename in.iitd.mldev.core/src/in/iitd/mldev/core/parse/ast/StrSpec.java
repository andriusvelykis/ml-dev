package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class StrSpec extends Spec {
	public final List<StrDesc> descs;

	public StrSpec(List<StrDesc> sd) {
		descs = copyList(sd);
	}
}
