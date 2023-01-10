package ast;

public class LValueBrack extends LValueExp {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public LValueBrack(Ast accessed, Ast exp) {
        super(accessed, exp);
    }

    @Override
    public String toString() {
        return (accessed != null ? accessed.toString() : "null") + "[" + (exp != null ? exp.toString() : "null") + "]";
    }
}
