package ast;

import java.util.List;

import SymboleTable.SymboleTable;
import types.Type;
import types.VoidType;

public class IdExp implements Ast, TypeExp {
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

    public Type getType(SymboleTable symboleTable) {
        if (name == "Id") {
            return symboleTable.lookupTypeVar(id.name);
        } if (name == "CallExp") {
            return symboleTable.lookupTypeFun(id.name);
        } else {
            return new VoidType();
        }
    }
}
