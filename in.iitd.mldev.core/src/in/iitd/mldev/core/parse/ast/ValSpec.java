package in.iitd.mldev.core.parse.ast;

public class ValSpec extends Spec {
	public ValDesc[] descs;
	public ValSpec (java.util.List vd) {descs = (ValDesc[]) vd.toArray(new ValDesc[0]);}
}
