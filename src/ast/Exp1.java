package ast;

public class Exp1 implements Ast {
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast child;

    public Exp1(Ast child) {
        this.child = child;
    }
}
