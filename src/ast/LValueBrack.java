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
        // Retourne le type de l'élément de l'array accédé s'il existe
        int i = Integer.parseInt(exp.toString());
        Type resType = null;
        ArrayType accessedType = null;
        try {
            accessedType = (ArrayType) ((TypeExp) accessed).getType(symboleTable, typeFactory);
            resType = accessedType.getElementType();
        } catch (Exception e) {
            System.out.println("[SEM] "+accessed.toString()+" is not an array");
        }
        if (accessedType != null) {
            if ((i < accessedType.getSize()) && (i >= 0)) {
                    return (accessedType.getElementType());
                } else {
                    System.out.println("[SEM] Index "+i+" out of bounds while accessing "+accessed.toString());
                    return null;
                }
        }
        
        return resType;
    }
}
