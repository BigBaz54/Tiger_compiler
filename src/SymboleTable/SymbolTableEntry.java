package SymboleTable;

import types.Type;
import types.TypeFactory;

public abstract class SymbolTableEntry {
    protected String name;
    protected Type type;
    protected int idNumber;
    private int id;

    public SymbolTableEntry(String name, Type type) {
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