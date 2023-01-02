package ast;

import java.util.ArrayList;

public class List implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public ArrayList<Binary> list;
    public String name;

    public List() {
        this.list = new ArrayList<Binary>();
    }
    public void add(Binary b) {
        list.add(b);
    }
    public int getSize() {
        return list.size();
    }
    
}
