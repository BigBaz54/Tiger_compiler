package ast;

public class Program implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast child;

    public Program(Ast child) {
        this.child = child;
    }

}
