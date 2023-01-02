package SymboleTable;


import types.Type;
import types.TypeFactory;

import java.util.List;

public class FunctionEntry extends SymbolTableEntry {
    private List<Type> parameterTypes;
    private int numParameters;

    public FunctionEntry(String name, List<Type> parameterTypes, Type returnType, int numParameters) {
        super(name, returnType);
        this.parameterTypes = parameterTypes;
        this.numParameters = numParameters;
    }

    public List<Type> getParameterTypes() {
        return parameterTypes;
    }

    public int getNumParameters() {
        return numParameters;
    }


    public void print(TypeFactory f) {
        System.out.println(getName() + "\t" + f.getType(type) + "\t" + "Function" + "\t" + getParameterTypes() + "\t" + getNumParameters());
    }
}