package ast;

public class FunDecType implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Id type;
    public Ast body;

    public FunDecType(Id type, Ast body) {
        this.type = type;
        this.body = body;
    }
    
}
