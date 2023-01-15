package ast;

import SymboleTable.SymboleTable;
import types.IntType;
import types.Type;
import types.TypeFactory;

public class OrExp implements Ast, TypeExp{
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast gauche;
    public Ast droite;
    public OrExp(Ast gauche, Ast droite) {
        this.gauche = gauche;
        this.droite = droite;
    }

    public Type getType(SymboleTable symboleTable, TypeFactory typeFactory){
        Type typeGauche = ((TypeExp)gauche).getType(symboleTable, typeFactory);
        Type typeDroite = ((TypeExp)droite).getType(symboleTable, typeFactory);
        if(typeGauche instanceof IntType && typeDroite instanceof IntType){
            return new IntType();
        }
        else{
            return null;
        }
    }
}
