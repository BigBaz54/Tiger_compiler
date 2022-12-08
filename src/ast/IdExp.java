package ast;

public class IdExp implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast id;
    public Ast exp;
    public IdExp(Ast id) {
        this.id = id;
    }
    public IdExp(Ast id, Ast exp) {
        this.id = id;
        this.exp = exp;
    }
}
