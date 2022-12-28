package ast;

public class RecordValue extends Field{

    public Ast id;
    public Ast value;

    public RecordValue(Ast id, Ast value) {
        super(id, value);
    }
    
}
