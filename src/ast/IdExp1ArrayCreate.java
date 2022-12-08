package ast;

public class IdExp1ArrayCreate implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast exp;
    public Ast exp1;
    public IdExp1ArrayCreate(Ast exp, Ast exp1) {
        this.exp = exp;
        this.exp1 = exp1;
    }
}
