package ast;

public class LValueDot implements Ast{
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast id;
    public LValueDot(Ast id) {
        this.id = id;
    }
}