package ast;

import java.util.ArrayList;

public class FunDec implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast id;
    public ArrayList<Param> params;
    public Ast right;

    public FunDec(Ast id,Ast right) {
        this.id = id;
        this.params = new ArrayList<Param>();
        this.right = right;
    }
    public void addParam(Ast id, Ast type) {
        params.add(new Param(id, type));
    }
    
}
