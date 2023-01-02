package ast;

public class RecordExp extends IdExp {

    public RecordExp(Id id, Ast exp) {
        super(id, exp);
        name = "RecordExp";
    }

    public String getType(){
        return id.name;
    }
    
}
