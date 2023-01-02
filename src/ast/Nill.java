package ast;

import types.*;

public class Nill implements Ast,TypeExp {
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String name = "nill";

    public Nill() {
    }
    public Type getType(){
        return new NilType();
    }

}
