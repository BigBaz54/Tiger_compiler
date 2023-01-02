package ast;

import types.*;

public class IfThenElse implements Ast , TypeExp{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast condition;
    public Ast thenBlock;
    public Ast elseBlock;

    public IfThenElse(Ast condition, Ast thenBlock, Ast elseBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }
    public IfThenElse(Ast condition, Ast thenBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
    }
    public Type getType(){
        return new VoidType();
    }
    
}
