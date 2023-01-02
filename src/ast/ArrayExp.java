package ast;

public class ArrayExp extends IdExp{
    
    public ArrayExp(Id id, Ast integer, Ast exp) {
        super(id, integer, exp);
        name = "ArrayExp";
    }
}
