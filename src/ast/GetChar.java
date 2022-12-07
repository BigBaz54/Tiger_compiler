package ast;

public class GetChar implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public GetChar() {
    }
    
}
