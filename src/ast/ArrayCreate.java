package ast;

public class ArrayCreate implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast integer;
    public Ast exp;
    
    public ArrayCreate(Ast integer, Ast exp) {
        this.integer = integer;
        this.exp = exp;
    }
}
