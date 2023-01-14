package SymboleTable;

import types.Type;

import java.util.ArrayList;

public class FunctionEntry extends SymboleTableEntry {
    private ArrayList<Type> parameterTypes;
    private int numParameters;

    public FunctionEntry(String name, ArrayList<Type> parameterTypes, Type returnType, int numParameters) {
        super(name, returnType);
        this.parameterTypes = parameterTypes;
        this.numParameters = numParameters;
    }

    public ArrayList<Type> getParameterTypes() {
        return parameterTypes;
    }

    public int getNumParameters() {
        return numParameters;
    }

    public void print() {
        System.out.println(idNumber + "\t" + "Func" + "\t" + getName() + "\t" + type.toString() + "\t" + "Function" + "\t" + getParameterTypes() + "\t" + getNumParameters());
    }
}