package ast;

import java.util.List;

public class IdExp implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Id id;
    public List<Ast> expList;
    public String name;

    public IdExp(Id id) {
        this.id = id;
        this.name = "Id";
    }
    public IdExp(Id id, Ast... exp) {
        this.id = id;
        this.expList = List.of(exp);
        this.name = "Exp";
    }
}
