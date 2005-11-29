package in.iitd.mldev.core.parse.ast;

public class WhereSig extends Sig {
	public Sig sig; public Whspec[] where;
	public WhereSig (Sig s, java.util.List ws) {sig = s; where = (Whspec[]) ws.toArray(new Whspec[0]);}
}
