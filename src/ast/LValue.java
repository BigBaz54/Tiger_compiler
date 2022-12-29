package ast;

public class LValue implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast right;

    public LValue(Ast right){
        this.right=right;
    }
    
}
