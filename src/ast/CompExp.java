package ast;

import SymboleTable.SymboleTable;
import types.*;

public class CompExp implements Ast, TypeExp {
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast plusExpL;
    public Ast plusExpR;

    public String op;

    public CompExp(Ast compExp) {
        this.plusExpL = compExp;
    }
    public CompExp(Ast compExp, Ast compExp1, String op) {
        this.plusExpL = compExp;
        this.plusExpR = compExp1;
        this.op = op;
    }

    public Type getType(SymboleTable symboleTable, TypeFactory typeFactory){
        Type typeGauche = ((TypeExp)plusExpL).getType(symboleTable, typeFactory);
        Type typeDroite = ((TypeExp)plusExpR).getType(symboleTable, typeFactory);
        if(typeGauche instanceof IntType && typeDroite instanceof IntType){
            return new IntType();
        }
        if (typeGauche instanceof StringType && typeDroite instanceof StringType){
            return new IntType();
        }
        else{
            return null;
        }
    }

}

