package in.iitd.mldev.core.parse.ast;

public class SignedStr extends Str {
	public final Str str;
	public final Sig sig;
	public boolean opaque = false;

	public SignedStr(Str s, Sig sg) {
		str = s;
		sig = sg;
	};

	public SignedStr(Str s, Sig sg, boolean o) {
		str = s;
		sig = sg;
		opaque = o;
	};
}
