package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class ValSpec extends Spec {
	public final List<ValDesc> descs;

	public ValSpec(List<ValDesc> vd) {
		descs = copyList(vd);
	}
}
