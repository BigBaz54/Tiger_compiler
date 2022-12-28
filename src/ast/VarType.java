package ast;

public class VarType implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast id;
    public Ast type;
    
    public VarType(Ast id,Ast type) {
        this.id = id;
        this.type = type;
    }
    
}
