package ast;

public class Break implements Ast {
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String functName = "break";

    public Break() {
    }

}
