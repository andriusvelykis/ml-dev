package in.iitd.mldev.core.parse.ast;

public class StrSpec extends Spec {
	public StrDesc[] descs;
	public StrSpec (java.util.List sd) {descs = (StrDesc[]) sd.toArray(new StrDesc[0]);}
}
