package SymboleTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SymboleTable {
    private HashMap<String, SymbolTableEntry> table;

    private int regionNumber;
    private int idNumber;

    public SymboleTable(int regionNumber, int idNumber) {
        this.table = new HashMap<>();
        this.regionNumber = regionNumber;
        this.idNumber = idNumber;
    }

    public void insert(SymbolTableEntry entry) {
        table.put(entry.getName(), entry);
    }

    public SymbolTableEntry lookup(String name) {
        return table.get(name);
    }

    public void delete(String name) {
        table.remove(name);
    }

    public List<SymbolTableEntry> getAllEntries() {
        return new ArrayList<>(table.values());
    }
}

