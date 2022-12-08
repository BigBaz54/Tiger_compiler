package ast;

public class PlusExp implements Ast {
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast gauche;
    public Ast droite;
    public String op;
    public PlusExp(Ast gauche, Ast droite, String op) {
        this.gauche = gauche;
        this.droite = droite;
        this.op = op;
    }
}