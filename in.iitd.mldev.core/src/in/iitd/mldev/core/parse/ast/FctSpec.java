package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class FctSpec extends Spec {
	public final List<FctDesc> descs;

	public FctSpec(List<FctDesc> fd) {
		descs = copyList(fd);
	}
}
