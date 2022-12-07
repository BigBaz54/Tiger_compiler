package ast;

public class IntLit implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int value;

    public IntLit(int value) {
        this.value = value;
    }
    
}
