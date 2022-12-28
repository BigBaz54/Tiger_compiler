package ast;

public class LValueDot implements Ast{
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast access;
    public Ast field;
    public LValueDot(Ast access, Ast field) {
        this.access = access;
        this.field = field;
    }
}