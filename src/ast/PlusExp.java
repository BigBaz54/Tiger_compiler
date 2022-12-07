package ast;

public class PlusExp implements Ast {
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast gauche;
    public Ast droite;

    public PlusExp(Ast gauche, Ast droite) {
        this.gauche = gauche;
        this.droite = droite;
    }
}
