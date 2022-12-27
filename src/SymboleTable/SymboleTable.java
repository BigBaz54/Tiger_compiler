package SymboleTable;

import java.util.HashMap;


public class SymboleTable {
    private HashMap<String, SymboleTableEntry> table;

    public SymboleTable() {
        this.table = new HashMap<>();
    }

    public void insert(SymboleTableEntry entry) {
        table.put(entry.getName(), entry);
    }

    public SymboleTableEntry lookup(String name) {
        return table.get(name);
    }

    public void delete(String name) {
        table.remove(name);
    }
}