package ast;

public class LValueDot extends LValueExp{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public LValueDot(Ast accessed, Ast exp) {
        super(accessed, exp);
    }

    @Override
    public String toString() {
        return (accessed != null ? accessed.toString() : "null") + "." + (exp != null ? exp.toString() : "null");
    }
}