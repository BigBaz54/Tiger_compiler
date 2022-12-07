package ast;

public class OrExp implements Ast{
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public Ast gauche;
    public Ast droite;
    public OrExp(Ast gauche, Ast droite) {
        this.gauche = gauche;
        this.droite = droite;
    }
}
