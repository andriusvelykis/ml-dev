package in.iitd.mldev.core.parse.ast;

public class ExnSpec extends Spec {
	public ExnDesc[] descs;
	public ExnSpec (java.util.List ed) {descs = (ExnDesc[]) ed.toArray(new ExnDesc[0]);}
}
