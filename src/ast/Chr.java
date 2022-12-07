package ast;

public class Chr implements Ast {
    
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast intArg;

    public Chr(Ast intArg) {
        this.intArg = intArg;
    }
    
}
