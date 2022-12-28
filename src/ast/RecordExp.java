package ast;

public class RecordExp extends IdExp {

    public RecordExp(Ast id, Ast exp) {
        super(id, exp);
        name = "RecordExp";
    }
    
}
