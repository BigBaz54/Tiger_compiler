package ast;

import SymboleTable.SymboleTable;
import types.*;

public class TimesExp implements Ast, TypeExp {
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast gauche;
    public Ast droite;
    public String op;

    public TimesExp(Ast gauche, Ast droite, String op) {
        this.gauche = gauche;
        this.droite = droite;
        this.op = op;
    }

    public Type getType(SymboleTable symboleTable) {
        Type typeGauche = ((TypeExp)gauche).getType(symboleTable);
        Type typeDroite = ((TypeExp)droite).getType(symboleTable);
        if(typeGauche instanceof IntType && typeDroite instanceof IntType){
            return new IntType();
        }
        else{
            return null;
        }
    }
}
