package SymboleTable;

import types.Type;

public abstract class SymboleTableEntry {
    protected String name;
    protected Type type;
    protected int idNumber;
    private int id;

    public SymboleTableEntry(String name, Type type) {
        this.name = name;
        this.type = type;
        this.idNumber = id;
        id ++;
    }

    public String getName() {
        return name;
    }

    public abstract void print();
    public Type getType(){
        return this.type;
    }
}