package ast;

import java.util.ArrayList;

public class AstList implements Ast{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Ast> list;
    public String name;

    public AstList() {
        this.list = new ArrayList<Ast>();
        this.name="List of parameters";
    }

    public void addParam(Ast a) {
        list.add(a);
    }
    
}
