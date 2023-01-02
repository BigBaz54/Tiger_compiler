package ast;

import types.*;

public class IntLit implements Ast,TypeExp {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int value;

    public IntLit(int value) {
        this.value = value;
    }
    public Type getType(){
        return new IntType();
    }
    
}
