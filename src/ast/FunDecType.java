package ast;

public class FunDecType implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast type;
    public Ast right;

    public FunDecType(Ast type, Ast right) {
        this.type = type;
        this.right = right;
    }
    
}
