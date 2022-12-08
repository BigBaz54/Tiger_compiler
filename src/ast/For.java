package ast;

public class For implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast id;
    public Ast init;
    public Ast cond;
    public Ast body; 

    public For(Ast id, Ast init, Ast cond, Ast body) {
        this.id = id;
        this.init = init;
        this.cond = cond;
        this.body = body;
    }
}
