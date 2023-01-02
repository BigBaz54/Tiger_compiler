package SymboleTable;


import types.Type;
import java.util.List;

public class FunctionEntry extends SymbolTableEntry {
    private List<Type> parameterTypes;
    private int numParameters;


    public FunctionEntry(String name, List<Type> parameterTypes, Type returnType, int numParameters, int regionNumber, int idNumber) {
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


}