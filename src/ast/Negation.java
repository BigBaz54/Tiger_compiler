package ast;

import types.*;

public class Negation implements Ast,TypeExp {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast exp;

    public Negation(Ast exp) {
        this.exp = exp;
    }
    public Type getType(){
        return new BoolType();
    }
}
