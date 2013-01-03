package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class SharingDesc extends Desc {
	public final List<Ident> idents;
	public boolean strs;

	public SharingDesc(List<Ident> ids, boolean s) {
		idents = copyList(ids);
		strs = s;
	}
}
