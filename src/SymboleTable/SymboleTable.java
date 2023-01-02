package SymboleTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SymboleTable {
    private HashMap<String, SymbolTableEntry> table;
    private int regionNumber;
    private static int region=0;

    public SymboleTable() {
        this.table = new HashMap<>();
        this.regionNumber = region;
        region ++;
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

    public void print() {
        System.out.println("Region " + regionNumber + ":");
        System.out.println("____________________________________________________");
        System.out.println("Name\tType\tKind\tValue");
        for (SymbolTableEntry entry : getAllEntries()) {
            entry.print();
        }
    }
}

