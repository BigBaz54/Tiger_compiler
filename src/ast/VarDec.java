package ast;

public class VarDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast id;
    public Ast right;

    public VarDec(Ast id, Ast right) {
        this.id = id;
        this.right = right;
    }
    
}
