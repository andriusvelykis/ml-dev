package in.iitd.mldev.core.parse.ast;

public class FctSpec extends Spec {
	public FctDesc[] descs;
	public FctSpec (java.util.List fd) {descs = (FctDesc[]) fd.toArray(new FctDesc[0]);}
}
