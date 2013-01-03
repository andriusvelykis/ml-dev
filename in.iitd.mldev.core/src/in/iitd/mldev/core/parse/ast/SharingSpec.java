package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class SharingSpec extends Spec {
	public final List<SharingDesc> descs;

	public SharingSpec(List<SharingDesc> sd) {
		descs = copyList(sd);
	}
}
