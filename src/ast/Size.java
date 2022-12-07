package ast;

public class Size implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);

    }

    public Ast stringArg;
    public String functName = "size";

    public Size(Ast stringArg) {
        this.stringArg = stringArg;
    }
    
}
