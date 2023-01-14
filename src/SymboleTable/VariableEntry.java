package SymboleTable;

import types.Type;

public class VariableEntry extends SymboleTableEntry {
    private int offset;
    private int size;

    public VariableEntry(String name, Type type, int offset, int size) {
        super(name, type, offset);
        this.size = size;
    }

    public int getOffset() {
        return offset;
    }

    public int getSize() {
        return size;
    }

    public void print() {
        System.out.println(idNumber+"\t"+"Var"+"\t"+ getName() + "\t" + type.toString() + "\t" + getOffset());
    }
}
