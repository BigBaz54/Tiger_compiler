package ast;

import SymboleTable.SymboleTable;
import types.*;

public class IntLit implements Ast,TypeExp {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int value;

    public IntLit(int value) {
        this.value = value;
    }
    public Type getType(SymboleTable symboleTable, TypeFactory typeFactory){
        return new IntType();
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
