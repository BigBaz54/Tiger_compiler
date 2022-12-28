package ast;


public class CallExp extends IdExp{

    public CallExp(Ast id, Ast paramList) {
        super(id,paramList);
        name = "CallExp";
    }
    
}
