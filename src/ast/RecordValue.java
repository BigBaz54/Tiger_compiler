package ast;

public class RecordValue extends Tuple{


    public RecordValue(Id id, Ast value) {
        super(id, value);
        this.name = "Field";
    }
    
}
