package ast;

public class TimesExp implements Ast {
    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ast gauche;
    public Ast droite;

    public TimesExp(Ast gauche, Ast droite) {
        this.gauche = gauche;
        this.droite = droite;
    }
}
