package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class TypeSpec extends Spec {
	public final List<TypeDesc> descs;
	public boolean eqtype = false;

	public TypeSpec(List<TypeDesc> td) {
		descs = copyList(td);
	}

	public TypeSpec(List<TypeDesc> td, boolean e) {
		descs = copyList(td);
		eqtype = e;
	}
}
