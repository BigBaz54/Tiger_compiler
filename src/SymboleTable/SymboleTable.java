package SymboleTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import types.Type;
import types.TypeFactory;


public class SymboleTable {
    private HashMap<String, SymbolTableEntry> table;
    private int regionNumber;
    public static int region=0;
    private int idNumber;
    public static int id=0;
    private SymboleTable parent;

    public SymboleTable() {
        this.table = new HashMap<>();
        this.regionNumber = region;
        region ++;
        this.idNumber = id;
        id ++;
        this.parent = null;
    }
    public SymboleTable(SymboleTable parent) {
        this.table = new HashMap<>();
        this.regionNumber = region;
        region ++;
        this.parent = parent;
        this.idNumber = id;
        id++;
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
        if (parent != null) {
            System.out.println("Region " + regionNumber + "\t / \tId " + idNumber+ ": "+ "Paren " + parent.regionNumber+ " / " + parent.idNumber);
        }
        System.out.println("Region " + regionNumber + "\t / \tId " + idNumber+ ": ");
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

    public Type lookupType(String name) {
        SymbolTableEntry entry = lookup(name);
        if (entry != null) {
            return entry.getType();
        }
        while (this.parent != null){
            entry = parent.lookup(name);
            if (entry != null) {
                return entry.getType();
            }
            this.parent = parent.parent;
        }
        return null;
    }
}

