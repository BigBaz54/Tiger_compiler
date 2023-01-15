package ast;

public abstract class LValueExp implements Ast, TypeExp{
    public Ast accessed;
    public Ast exp;

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public LValueExp(Ast accessed, Ast exp) {
        this.accessed = accessed;
        this.exp = exp;
    }

    public void setId(Ast id) {
        if (this.accessed == null) {
            this.accessed = id;
        } else {
            ((LValueExp) this.accessed).setId(id);
        }
    }
}
