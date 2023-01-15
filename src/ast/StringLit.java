package ast;

import SymboleTable.SymboleTable;
import types.*;

public class StringLit implements Ast,TypeExp {
    
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String value;

    public StringLit(String value) {
        String[] temp = value.split("\"");
        this.value = temp.length < 1 ? "" : temp[1];
    }
    public Type getType(SymboleTable symboleTable){
        return new StringType();
    }

    @Override
    public String toString() {
        return "\"" + value + "\"";
    }
}

