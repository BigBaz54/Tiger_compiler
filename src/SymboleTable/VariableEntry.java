package SymboleTable;

import types.Type;

public class VariableEntry extends SymbolTableEntry {
    private int offset;
    private Object value;
    private int size;


    public VariableEntry(String name, Type type, int offset, int size, int regionNumber, int idNumber) {
        super(name, type);
        this.offset = offset;
        this.size = size;

    }

    public int getOffset() {
        return offset;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int getSize() {
        return size;
    }

}
