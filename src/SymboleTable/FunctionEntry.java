package SymboleTable;


import types.Type;
import java.util.List;

public class FunctionEntry extends SymbolTableEntry {
    private List<Type> parameterTypes;
    private int numParameters;
    private int regionNumber;
    private int idNumber;

    public FunctionEntry(String name, List<Type> parameterTypes, Type returnType, int numParameters, int regionNumber, int idNumber) {
        super(name, returnType);
        this.parameterTypes = parameterTypes;
        this.numParameters = numParameters;
        this.regionNumber = regionNumber;
        this.idNumber = idNumber;
    }

    public List<Type> getParameterTypes() {
        return parameterTypes;
    }

    public int getNumParameters() {
        return numParameters;
    }

    public int getRegionNumber() {
        return regionNumber;
    }

    public int getIdNumber() {
        return idNumber;
    }
}