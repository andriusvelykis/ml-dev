package in.iitd.mldev.core.parse.ast;

public class TypeSpec extends Spec {
	public TypeDesc[] descs;
	public boolean eqtype = false;
	public TypeSpec (java.util.List td) {descs = (TypeDesc[]) td.toArray(new TypeDesc[0]);}
	public TypeSpec (java.util.List td, boolean e) {descs = (TypeDesc[]) td.toArray(new TypeDesc[0]); eqtype = e;}
}
