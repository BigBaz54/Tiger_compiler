package ast;

public class FunDecNoType implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast exp;

    public FunDecNoType(Ast exp) {
        this.exp = exp;
    }
    
}
