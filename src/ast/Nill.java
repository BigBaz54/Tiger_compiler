package ast;

public class Nill implements Ast {
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String value;

    public Nill(String value) {
        this.value = value;
    }

}
