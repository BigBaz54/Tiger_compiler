package ast;

import java.util.ArrayList;

public class TyDecRecord implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public ArrayList<Param> fields;

    public TyDecRecord() {
        this.fields = new ArrayList<Param>();
    }
    public void addField(Ast id, Ast type) {
        fields.add(new Param(id, type));
    }
    
}
