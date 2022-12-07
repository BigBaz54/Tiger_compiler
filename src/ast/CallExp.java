package ast;

import java.util.ArrayList;

public class CallExp implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Ast> expList;

    public CallExp() {
        this.expList = new ArrayList<Ast>();
    }
    public void addexp(Ast expList) {
        this.expList.add(expList);
    }
    
}
