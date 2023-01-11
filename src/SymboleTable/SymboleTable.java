package SymboleTable;

import java.util.ArrayList;

import types.Type;

public class SymboleTable {
    private ArrayList<SymbolTableEntry> symboleTable;
    private int regionNumber;
    public static int region = 0;
    private int idNumber;
    public static int id = 0;
    private SymboleTable parent;

    public SymboleTable() {
        this.symboleTable = new ArrayList<>();
        this.regionNumber = region;
        region ++;
        this.idNumber = id;
        id ++;
        this.parent = null;
    }

    public SymboleTable(SymboleTable parent) {
        this.symboleTable = new ArrayList<>();
        this.regionNumber = region;
        region ++;
        this.idNumber = id;
        id++;
        this.parent = parent;
    }

    public void insert(SymbolTableEntry entry) {
        symboleTable.add(entry);
    }

    public SymbolTableEntry lookup(String name) {
        for (SymbolTableEntry entry : symboleTable) {
            if (entry.getName() == name) {
                return entry;
            }
        }
        return null;
    }

    public ArrayList<SymbolTableEntry> getSymbolTable() {
        return symboleTable;
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
        for (SymbolTableEntry entry : symboleTable) {
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

