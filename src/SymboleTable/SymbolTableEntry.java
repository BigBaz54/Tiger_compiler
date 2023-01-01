package SymboleTable;

import types.Type;

public abstract class SymbolTableEntry {
    private String name;
    private Type type;

    public SymbolTableEntry(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}