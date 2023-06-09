package ast;

import SymboleTable.SymboleTable;
import types.*;

public class PlusExp implements Ast,TypeExp {
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast gauche;
    public Ast droite;
    public String op;
    public PlusExp(Ast gauche, Ast droite, String op) {
        this.gauche = gauche;
        this.droite = droite;
        this.op = op;
    }
    
    public Type getType(SymboleTable symboleTable, TypeFactory typeFactory){
        Type typeGauche = ((TypeExp)gauche).getType(symboleTable, typeFactory);
        Type typeDroite = ((TypeExp)droite).getType(symboleTable, typeFactory);
        if(typeGauche instanceof IntType && typeDroite instanceof IntType){
            return new IntType();
        } else if ((gauche instanceof Id) && (typeGauche==null) || (droite instanceof Id) && (typeDroite==null)) {
            if ((gauche instanceof Id) && (typeGauche==null)) {
                System.out.println("[SEM] Variable "+((Id) gauche).name+" is not defined");
            }
            if ((droite instanceof Id) && (typeDroite==null)) {
                System.out.println("[SEM] Variable "+((Id) droite).name+" is not defined");
            }
            return null;
        } else {
            System.out.println("[SEM] Operator "+op+" can't be used with types "+((TypeExp) gauche).getType(symboleTable, typeFactory)+" and "+((TypeExp) droite).getType(symboleTable, typeFactory));
            return null;
        }
    }
}
