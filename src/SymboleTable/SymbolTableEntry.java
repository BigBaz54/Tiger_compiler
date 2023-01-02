package SymboleTable;

import types.Type;

public abstract class SymbolTableEntry {
    protected String name;
    protected String type;
    protected int idNumber;

    public SymbolTableEntry(String name, String type, int idNumber) {
        this.name = name;
        this.type = type;
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }


    public abstract void print();
}