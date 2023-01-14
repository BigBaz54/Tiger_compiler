package SymboleTable;

import types.Type;

public abstract class SymboleTableEntry {
    protected String name;
    protected Type type;
    protected int offset;
    protected int idNumber;
    private static int id;

    public SymboleTableEntry(String name, Type type, int offset) {
        this.name = name;
        this.type = type;
        this.offset = offset;
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