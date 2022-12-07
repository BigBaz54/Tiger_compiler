package ast;

public class Not implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast intArg;
    public String functName = "not";

    public Not(Ast intArg) {
        this.intArg = intArg;
    }
    
}
