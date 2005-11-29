package in.iitd.mldev.core.parse.ast;

public class BaseSig extends Sig {
	public Spec[] specs;
	public BaseSig (java.util.List ss) {specs = (Spec[]) ss.toArray(new Spec[0]);}
}
