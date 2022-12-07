package ast;

public class Exit implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast intArg;
    public String functName = "exit";

    public Exit(Ast intArg) {
        this.intArg = intArg;
    }
    
}
