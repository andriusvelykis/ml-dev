package in.iitd.mldev.core.parse.ast;

import java.util.Collections;
import java.util.List;

public class RecordExp extends Exp {
	public final List<ExpField> fields;

	public RecordExp(List<ExpField> r) {
		fields = copyList(r);
	}

	public RecordExp() {
		this(Collections.<ExpField> emptyList());
	}
}
