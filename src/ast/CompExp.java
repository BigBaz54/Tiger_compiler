package ast;

import java.util.ArrayList;

public class CompExp implements Ast {
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast plusExp;
    public ArrayList<Ast> plusExp1;

    public CompExp(Ast plusExp) {
        this.plusExp = plusExp;
        this.plusExp1 = new ArrayList<Ast>();
    }

    public void addCompExp(Ast plusExp) {
        this.plusExp1.add(plusExp);
    }
}

