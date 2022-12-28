package ast;

public class ArrayExp extends IdExp{
    
    public ArrayExp(Ast id, Ast integer, Ast exp) {
        super(id, integer, exp);
        name = "ArrayExp";
    }
}
