package ast;

public class TyDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast id;
    public Ast ty;

    public TyDec(Ast id, Ast ty) {
        this.id = id;
        this.ty = ty;
    }
    
}
