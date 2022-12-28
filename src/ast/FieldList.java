package ast;

import java.util.ArrayList;

public class FieldList implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public ArrayList<Field> fields;
    public String name;

    public FieldList() {
        this.fields = new ArrayList<Field>();
        this.name="List of fields";
    }
    public void addField(Field field) {
        fields.add(field);
    }
    
}
