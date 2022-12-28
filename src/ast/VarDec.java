package ast;

public class VarDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;

    public VarDec(Ast left, Ast right) {
        this.left = left;
        this.right = right;
    }
    
}
