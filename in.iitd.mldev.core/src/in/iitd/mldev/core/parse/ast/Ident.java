package in.iitd.mldev.core.parse.ast;

import java.util.List;

public class Ident extends AST {
	public String[] qualifier; public String name;
	public Ident (String id) {name = id;}
	public Ident (List q, String id) {name = id; qualifier = (String[])q.toArray(new String[0]);}
	public Ident mark (int l, int r) {super.setPos(l,r); return this;}
}
