package ast;

import SymboleTable.SymboleTable;
import types.*;

public class AndExp implements Ast,TypeExp{
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast gauche;
    public Ast droite;
    public AndExp(Ast gauche, Ast droite) {
        this.gauche = gauche;
        this.droite = droite;
    }

    public Type getType(SymboleTable symboleTable){
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

