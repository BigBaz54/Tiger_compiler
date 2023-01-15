package ast;

import SymboleTable.SymboleTable;
import types.Type;
import types.ArrayType;
import types.TypeFactory;

public class LValueBrack extends LValueExp {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public LValueBrack(Ast accessed, Ast exp) {
        super(accessed, exp);
    }

    @Override
    public String toString() {
        return (accessed != null ? accessed.toString() : "null") + "[" + (exp != null ? exp.toString() : "null") + "]";
    }

    public Type getType(SymboleTable symboleTable, TypeFactory typeFactory) {
        // Retourne le type des éléments de l'array accédée s'il existe
        int i = Integer.parseInt(exp.toString());
        ArrayType array = ((ArrayType) (symboleTable.lookupTypeVar(((Id) accessed).name)));
        if ((i < array.getSize()) && (i >= 0)) {
            return (array.getElementType());
        } else {
            System.out.println("[SEM] Index "+i+" out of bounds while accessing "+((Id) accessed).name);
            return null;
        }
    }
}
