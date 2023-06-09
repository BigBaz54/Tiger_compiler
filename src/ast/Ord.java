package ast;

public class Ord implements Ast {
        
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast stringArg;
    public String functName = "ord";

    public Ord(Ast stringArg) {
        this.stringArg = stringArg;
    }
    
}
