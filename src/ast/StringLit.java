package ast;

public class StringLit implements Ast {
    
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String value;

    public StringLit(String value) {
        String[] temp = value.split("\"");
        this.value = temp.length < 1 ? "" : temp[1];
    }
}

