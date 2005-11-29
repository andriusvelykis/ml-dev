package in.iitd.mldev.core.parse.ast;

public class RecordType extends Type {
    public TypeField[] fields;
    public RecordType (java.util.List r) {fields = (TypeField[]) r.toArray(new TypeField[0]);}
	public RecordType () {fields = new TypeField[0];}
}
