package ast;

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
    
    public Type getType(){

        Type typeGauche = ((TypeExp)gauche).getType();
        Type typeDroite = ((TypeExp)droite).getType();
        if(typeGauche instanceof IntType && typeDroite instanceof IntType){
            return new IntType();
        }
        else{
            System.out.println("Type error: "+typeGauche+" and "+typeDroite+" are not compatible");
            System.exit(1);
            return null;
        }

    }
}
