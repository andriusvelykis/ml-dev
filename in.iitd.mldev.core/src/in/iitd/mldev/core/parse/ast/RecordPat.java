package in.iitd.mldev.core.parse.ast;

import java.util.Collections;
import java.util.List;

public class RecordPat extends Pat {
	public final List<Field> fields;

	public RecordPat(List<Field> r) {
		fields = copyList(r);
	}

	public RecordPat() {
		this(Collections.<Field> emptyList());
	}
}
