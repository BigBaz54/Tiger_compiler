package ast;

public class TyDec implements Ast{

    public Ast id;
    public Ast right;
    public String name;

    public TyDec(Ast id, Ast right) {
        this.id = id;
        this.right = right;
    }
    
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
}
