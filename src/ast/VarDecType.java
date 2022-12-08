package ast;

public class VarDecType implements Ast{
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    public Ast type;
    public Ast exp;
    
    public VarDecType(Ast type, Ast exp) {
        this.type = type;
        this.exp = exp;
    }
}
