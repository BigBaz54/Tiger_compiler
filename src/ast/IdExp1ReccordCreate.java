package ast;

import java.util.ArrayList;

public class IdExp1ReccordCreate implements Ast {
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public ArrayList<Ast> feur;
    public IdExp1ReccordCreate() {
        this.feur = new ArrayList<Ast>();
    }
    public void addfeur(Ast feur) {
        this.feur.add(feur);
    }


}


