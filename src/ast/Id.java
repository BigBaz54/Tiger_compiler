package ast;

public class Id implements Ast {
    
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    public String name;
    public boolean isArrayId;
    
    public Id(String name) {
        this.name = name;
        this.isArrayId = false;
    }

    public Id(String name, boolean isArrayId) {
        this.name = name;
        this.isArrayId = isArrayId;
    }
        
}
