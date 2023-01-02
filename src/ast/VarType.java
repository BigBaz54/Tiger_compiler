package ast;

public class VarType implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Id id;
    public Id type;
    
    public VarType(Id id,Id type) {
        this.id = id;
        this.type = type;
    }
    
}
