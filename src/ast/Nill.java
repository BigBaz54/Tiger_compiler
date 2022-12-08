package ast;

public class Nill implements Ast {
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String name = "nill";

    public Nill() {
    }

}
