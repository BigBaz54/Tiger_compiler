package ast;

public class AndExp implements Ast{
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast gauche;
    public Ast droite;
    public AndExp(Ast gauche, Ast droite) {
        this.gauche = gauche;
        this.droite = droite;
    }
}

