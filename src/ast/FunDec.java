package ast;


public class FunDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Id id;
    public ParamList params;
    public Ast body;
    public Id returnType;

    public FunDec(Id id, ParamList params, Ast body) {
        this.id = id;
        this.params = params;
        this.body = body;
        this.returnType = null;
    }

    public FunDec(Id id, ParamList params, Ast body, Id returnType) {
        this.id = id;
        this.params = params;
        this.body = body;
        this.returnType = returnType;
    }
    
}
