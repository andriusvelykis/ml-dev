package in.iitd.mldev.core.parse.ast;

public class RecordExp extends Exp {
    public ExpField[] fields;
    public RecordExp (java.util.List r) {fields = (ExpField[]) r.toArray(new ExpField[0]);}
	public RecordExp () {fields = new ExpField[0];}
}
