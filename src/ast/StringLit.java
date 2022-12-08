package ast;

public class StringLit implements Ast {
    
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String value;

    public StringLit(String value) {
        this.value=value.split("\"")[1]; // remove the quotes
    }
    
}

