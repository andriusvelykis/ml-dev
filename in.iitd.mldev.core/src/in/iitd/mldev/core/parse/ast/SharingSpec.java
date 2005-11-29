package in.iitd.mldev.core.parse.ast;

public class SharingSpec extends Spec {
	public SharingDesc[] descs;
	public SharingSpec (java.util.List sd) {descs = (SharingDesc[]) sd.toArray(new SharingDesc[0]);}
}
