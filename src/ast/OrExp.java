package ast;

import types.BoolType;
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
        return new BoolType();
    }
}
