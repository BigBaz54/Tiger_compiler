package ast;

public class TyDec implements Ast{

    public Id id;
    public Ast right;
    public String name;

    public TyDec(Id id, Ast right) {
        this.id = id;
        this.right = right;
    }
    
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
}
