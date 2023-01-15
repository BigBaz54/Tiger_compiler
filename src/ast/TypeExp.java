package ast;

import SymboleTable.SymboleTable;
import types.Type;
import types.TypeFactory;

public interface TypeExp {
    
    public Type getType(SymboleTable symboleTable, TypeFactory typeFactory);
}
