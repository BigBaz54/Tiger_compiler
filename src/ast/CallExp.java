package ast;


public class CallExp extends IdExp{

    public CallExp(Id id, Ast paramList) {
        super(id,paramList);
        name = "CallExp";
    }
    
}
