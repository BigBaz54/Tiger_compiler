package ast;

public class RecordValue extends Binary{

    public Ast id;
    public Ast value;

    public RecordValue(Ast id, Ast value) {
        super(id, value);
        this.name = "Field";
    }
    
}
