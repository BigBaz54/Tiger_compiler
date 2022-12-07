package ast;

import java.util.ArrayList;

public class CompExp implements Ast {
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast plusExpL;
    public Ast plusExpR;

    public String op;

    public CompExp(Ast plusExp) {
        this.plusExpL = plusExp;
    }
    public CompExp(Ast plusExp, Ast plusExp1, String op) {
        this.plusExpL = plusExp;
        this.plusExpR = plusExp1;
        this.op = op;
    }

}

