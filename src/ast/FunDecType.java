package ast;

public class FunDecType implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast type;
    public Ast body;

    public FunDecType(Ast type, Ast body) {
        this.type = type;
        this.body = body;
    }
    
}
