package ast;

import SymboleTable.SymboleTable;
import types.*;

public class Negation implements Ast,TypeExp {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast exp;

    public Negation(Ast exp) {
        this.exp = exp;
    }
    public Type getType(SymboleTable symboleTable, TypeFactory typeFactory){
        if (((TypeExp)exp).getType(symboleTable, typeFactory) instanceof IntType){
            return new IntType();
        }
        else{
            return null;
        }
    }
}
