package ast;

public class VarDecNoType implements Ast {
    
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    public Ast exp;
    
    public VarDecNoType(Ast exp) {
        this.exp = exp;
    }
}
