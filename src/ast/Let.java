package ast;

import java.util.ArrayList;

import SymboleTable.SymboleTable;
import types.*;

public class Let implements Ast, TypeExp {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public ArrayList<Ast> decs;
    public ArrayList<Ast> body;

    public Let() {
        this.decs = new ArrayList<Ast>();
        this.body = new ArrayList<Ast>();
    }
    public void addDec(Ast dec) {
        this.decs.add(dec);
    }
    public void addBody(Ast body) {
        this.body.add(body);
    }
    public Type getType(SymboleTable symboleTable, TypeFactory typeFactory) {
        return new VoidType();
    }
    
}
