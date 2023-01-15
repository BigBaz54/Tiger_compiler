package ast;

import SymboleTable.SymboleTable;
import types.Type;

public interface TypeExp {
    
    public Type getType(SymboleTable symboleTable);
}
