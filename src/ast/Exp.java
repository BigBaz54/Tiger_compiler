package ast;

import SymboleTable.SymboleTable;
import types.*;

public class Exp implements Ast, TypeExp{
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Id id;
    public Ast lvalue;
    public Ast orExp;

    public Exp(Id id, Ast lvalue, Ast orExp) {
        this.id = id;
        this.lvalue = lvalue;
        this.orExp = orExp;
    }

    public Exp(Ast orExp) {
        this.orExp = orExp;
    }
    public Exp(Id id, Ast orExp) {
        this.id = id;
        this.orExp = orExp;
    }
    public Type getType(SymboleTable symboleTable, TypeFactory typeFactory){
        if (id != null) {
            return new VoidType();
        } else {
            return ((TypeExp)orExp).getType(symboleTable, typeFactory);
        }
    }
}
