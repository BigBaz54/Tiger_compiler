package ast;


public class FunDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast id;
    public ParamList params;
    public Ast body;
    public Ast returnType;

    public FunDec(Ast id, ParamList params, Ast body) {
        this.id = id;
        this.params = params;
        this.body = body;
        this.returnType = null;
    }

    public FunDec(Ast id, ParamList params, Ast body, Ast returnType) {
        this.id = id;
        this.params = params;
        this.body = body;
        this.returnType = returnType;
    }
    
}
