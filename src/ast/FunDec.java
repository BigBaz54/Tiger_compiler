package ast;


public class FunDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast id;
    public Ast astList;
    public Ast right;

    public FunDec(Ast id,Ast right) {
        this.id = id;
        this.astList = new FieldList();
        this.right = right;
    }
    
}
