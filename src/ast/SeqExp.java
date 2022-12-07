package ast;

import java.util.ArrayList;

public class SeqExp implements Ast {

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast exp;
    public ArrayList<Ast> seqExp1;

    public SeqExp(Ast exp) {
        this.exp = exp;
        this.seqExp1 = new ArrayList<Ast>();
    }
    public SeqExp(){}
    public void addseqExp(Ast seqExp1) {
        this.seqExp1.add(seqExp1);
    }
}
