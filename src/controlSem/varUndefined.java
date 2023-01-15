package controlSem;

import SymboleTable.SymboleTable;
import ast.Ast;
import ast.Id;

public class varUndefined {
    public varUndefined(Ast var, SymboleTable symboleTable) {
        if ((var instanceof Id)) {
            String name =  (((Id) var).name);
            if (symboleTable.lookupTypeVar(name)==null) {
                System.out.println("[SEM] var "+name+" is not defined");
            }
        }
    }
}
