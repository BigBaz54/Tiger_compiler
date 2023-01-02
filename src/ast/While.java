package ast;

import types.*;

public class While implements Ast, TypeExp {
    
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    public Ast cond;
    public Ast body;

    public While(Ast cond, Ast body) {
        this.cond = cond;
        this.body = body;
    }
    public Type getType(){
        return new VoidType();
    }
       
}
