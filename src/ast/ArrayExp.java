package ast;

import types.*;

public class ArrayExp extends IdExp {
    
    public ArrayExp(Id id, Ast integer, Ast exp) {
        super(id, integer, exp);
        name = "ArrayExp";
    }

    public Type getType(){
        return new VoidType();
    }
    public Type getType(TypeFactory f){
        return f.getType(id.name);
    }
}
