package ast;

public class RecordValue extends Binary{


    public RecordValue(Id id, Ast value) {
        super(id, value);
        this.name = "Field";
    }
    
}
