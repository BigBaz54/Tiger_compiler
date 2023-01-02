package ast;

import types.*;

public class CompExp implements Ast {
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

    public Type getType(){
        Type typeGauche = ((TypeExp)plusExpL).getType();
        Type typeDroite = ((TypeExp)plusExpR).getType();
        if(typeGauche instanceof IntType && typeDroite instanceof IntType){
            return new IntType();
        }
        if (typeGauche instanceof StringType && typeDroite instanceof StringType){
            return new StringType();
        }
        else{
            System.out.println("Type error: "+typeGauche+" and "+typeDroite+" are not compatible");
            System.exit(1);
            return null;
        }
    }

}

