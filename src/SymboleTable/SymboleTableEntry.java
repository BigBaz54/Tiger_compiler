package SymboleTable;

import types.Type;

public class SymboleTableEntry {
    private String name;
    private Type type;
    private Object value;
    private String scope;
    private int argCount;
    private int size;
    private boolean local;
    private int id;
    private int funcId;

    public SymboleTableEntry(String name, Type type, Object value, String scope, int argCount, int size, boolean local, int id, int funcId) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.scope = scope;
        this.argCount = argCount;
        this.size = size;
        this.local = local;
        this.id = id;
        this.funcId = funcId;  // set the funcId field
    }
    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }
    public String getScope() {
        return scope;
    }
    public int getArgCount() {
        return argCount;
    }public int getSize() {
        return size;
    }

    public boolean isLocal() {
        return local;
    }

    public int getId() {
        return id;
    }
    public int getFuncId() {
        return funcId;
    }

}
