package ast;

import java.util.ArrayList;

public class LValue implements Ast{
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public ArrayList<Ast> lValue1;
    public LValue() {
        this.lValue1 = new ArrayList<Ast>();
    }
    public void addlvalue(Ast lValue1) {
        this.lValue1.add(lValue1);
    }
}
