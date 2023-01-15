package ast;

import SymboleTable.SymboleTable;
import types.Type;
import types.VoidType;

public class RecordExp extends IdExp {

    public RecordExp(Id id, Ast exp) {
        super(id, exp);
        name = "RecordExp";
    }

    @Override
    public Type getType(SymboleTable symboleTable){
        return new VoidType();
    }
}