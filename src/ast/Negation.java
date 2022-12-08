package ast;

public class Negation implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast exp;

    public Negation(Ast exp) {
        this.exp = exp;
    }
}
