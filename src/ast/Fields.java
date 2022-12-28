package ast;

import java.util.ArrayList;

public class Fields implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public ArrayList<Record> fields;
    public String name;

    public Fields() {
        this.fields = new ArrayList<Record>();
        this.name="List of fields";
    }
    public void addField(Ast id, Ast type) {
        fields.add(new Record(id, type));
    }
    
}
