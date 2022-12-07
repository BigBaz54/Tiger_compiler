package ast;

public class Chr implements Ast {
    
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast intArg;
    public String functName = "chr";

    public Chr(Ast intArg) {
        this.intArg = intArg;
    }
    
}
