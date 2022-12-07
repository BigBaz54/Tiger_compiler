package ast;

public class LValueBrack implements Ast{
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast exp;

    public LValueBrack(Ast exp) {
        this.exp = exp;
    }
}
