package ast;

public class Print implements Ast {
    
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast arg;

    public Print(Ast arg) {
        this.arg = arg;
    }
    
}
