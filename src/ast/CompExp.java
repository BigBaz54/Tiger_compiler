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
        this.plusExpL = compExp1;
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
        } else if ((plusExpL instanceof Id) && (typeGauche==null)) {
            System.out.println("[SEM] var "+((Id) plusExpL).name+" is not defined");
            return null;
        } else if ((plusExpL instanceof Id) && (typeDroite==null)) {
            System.out.println("[SEM] var "+((Id) plusExpL).name+" is not defined");
            return null;
        } else{
            System.out.println("[SEM] Operator "+op+" can't be used with types "+((TypeExp) plusExpL).getType(symboleTable, typeFactory)+" and "+((TypeExp) plusExpR).getType(symboleTable, typeFactory));
            return null;
        }
    }

}

