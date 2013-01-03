package in.iitd.mldev.core.parse.ast;

import java.util.Collections;
import java.util.List;

public class RecordType extends Type {
	public final List<TypeField> fields;

	public RecordType(List<TypeField> r) {
		fields = copyList(r);
	}

	public RecordType() {
		this(Collections.<TypeField> emptyList());
	}
}
