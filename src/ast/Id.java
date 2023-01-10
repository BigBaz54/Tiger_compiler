package ast;

import types.*;

public class Id implements Ast, TypeExp {
    
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    public String name;
    public boolean isArrayId;

    
    public Id(String name) {
        this.name = name;
        this.isArrayId = false;
    }

    public Id(String name, boolean isArrayId) {
        this.name = name;
        this.isArrayId = isArrayId;
    }

    public Type getType(){
        return new VoidType();
    }

    @Override
    public Type getType(TypeFactory f) {
        return f.getType(name);
    }

    @Override
    public String toString() {
        return name;
    }  
}
