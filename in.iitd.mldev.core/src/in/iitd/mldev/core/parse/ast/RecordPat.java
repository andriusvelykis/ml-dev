package in.iitd.mldev.core.parse.ast;

public class RecordPat extends Pat {
    public Field[] fields;
    public RecordPat (java.util.List r) {fields = (Field[]) r.toArray(new Field[0]);}
	public RecordPat () {fields = new PatField[0];}
}
