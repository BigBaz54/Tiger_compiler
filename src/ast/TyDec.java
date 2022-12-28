package ast;

import java.util.List;

public class TyDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast id;
    public Ast right;
    public String name;

    public TyDec(String name, Ast id, Ast right) {
        this.id = id;
        this.right = right;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
