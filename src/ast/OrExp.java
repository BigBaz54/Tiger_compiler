package ast;

import types.BoolType;
import types.IntType;
import types.Type;

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
