package ast;

import SymboleTable.SymboleTable;
import types.Type;
import types.TypeFactory;
import types.RecordType;

public class LValueDot extends LValueExp{

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public LValueDot(Ast accessed, Ast exp) {
        super(accessed, exp);
    }

    @Override
    public String toString() {
        return (accessed != null ? accessed.toString() : "null") + "." + (exp != null ? exp.toString() : "null");
    }

    public Type getType(SymboleTable symboleTable, TypeFactory typeFactory) {
        // Retourne le type du champ accédé s'il existe
        RecordType accessedType = null;
        Type resType = null;
        try {
            accessedType = (RecordType) ((TypeExp) accessed).getType(symboleTable, typeFactory);
            resType = accessedType.getFields().get(exp.toString());
        } catch (Exception e) {
            System.out.println("[SEM] "+accessed.toString()+" is not a record");
        }
        if (accessedType != null) {
            Type fieldType = accessedType.getFields().get(exp.toString());
            if (fieldType != null) {
                return fieldType;
            } else {
                System.out.println("[SEM] Type "+accessed.toString()+" has no attribute "+exp.toString());
                return null;
            }
        }
        
        return resType;
    }
}