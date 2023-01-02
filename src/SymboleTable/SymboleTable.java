package SymboleTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import types.TypeFactory;


public class SymboleTable {
    private HashMap<String, SymbolTableEntry> table;
    private int regionNumber;
    public static int region=0;
    private int id;
    public static int idNumber=0;
    private SymboleTable parent;

    public SymboleTable() {
        this.table = new HashMap<>();
        this.regionNumber = region;
        region ++;
        this.parent = null;
    }
    public SymboleTable(SymboleTable parent) {
        this.table = new HashMap<>();
        this.regionNumber = region;
        region ++;
        this.parent = parent;
        this.id = idNumber;
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
    public int getRegionNumber() {
        return regionNumber;
    }


    public void print() {
        System.out.println("Region " + regionNumber + ":");
        System.out.println("____________________________________________________");
        System.out.println("Id\tKind\tName\tType\tValue");
        for (SymbolTableEntry entry : getAllEntries()) {
            entry.print();
        }
        System.out.println("____________________________________________________");
        System.out.println();
    }

    public int getId() {
        return id;
    }
}

