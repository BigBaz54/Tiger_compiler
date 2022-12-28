package ast;

import java.util.List;

public class IdExp implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast id;
    public List<Ast> expList;
    public String name;

    public IdExp(Ast id) {
        this.id = id;
        this.name = "Id";
    }
    public IdExp(Ast id, Ast... exp) {
        this.id = id;
        this.expList = List.of(exp);
        this.name = "Exp";
    }
}
