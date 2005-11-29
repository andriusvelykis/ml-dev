package in.iitd.mldev.core.parse.ast;

public class LocalDec extends Dec {
	public Dec[] localdecs, decs;
	public LocalDec (java.util.List d1, java.util.List d2) {
		localdecs = (Dec[]) d1.toArray(new Dec[0]);
		decs = (Dec[]) d2.toArray(new Dec[0]);
	}
}
