package SymboleTable;

import types.Type;

public abstract class SymbolTableEntry {
    protected String name;
    protected String type;
    protected int idNumber;
    private int id;

    public SymbolTableEntry(String name, String type) {
        this.name = name;
        this.type = type;
        this.idNumber = id;
        id ++;
    }

    public String getName() {
        return name;
    }


    public abstract void print();
}