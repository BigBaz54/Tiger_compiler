package SymboleTable;


import types.Type;
import java.util.List;

public class FunctionEntry extends SymbolTableEntry {
    private List<Type> parameterTypes;
    private int numParameters;

    public FunctionEntry(String name, List<Type> parameterTypes, String returnType, int numParameters, int idNumber) {
        super(name, returnType, idNumber);
        this.parameterTypes = parameterTypes;
        this.numParameters = numParameters;
    }

    public List<Type> getParameterTypes() {
        return parameterTypes;
    }

    public int getNumParameters() {
        return numParameters;
    }


    public void print() {
        System.out.println(getName() + "\t" + type + "\t" + "Function" + "\t" + getParameterTypes() + "\t" + getNumParameters());
    }
}