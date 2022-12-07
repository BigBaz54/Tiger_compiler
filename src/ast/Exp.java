package ast;

public class Exp implements Ast{
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast id;
    public Ast lvalue;
    public Ast orExp;

    public Exp(Ast id, Ast lvalue, Ast orExp) {
        this.id = id;
        this.lvalue = lvalue;
        this.orExp = orExp;
    }

    public Exp(Ast orExp) {
        this.orExp = orExp;
    }
    public Exp(Ast id, Ast orExp) {
        this.id = id;
        this.orExp = orExp;
    }


}
