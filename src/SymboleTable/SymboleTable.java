package SymboleTable;

import java.util.ArrayList;

import types.Type;

public class SymboleTable {
    private ArrayList<SymboleTableEntry> symboleTable;
    private int regionNumber;
    public static int region = 0;
    private int idNumber;
    public static int id = 0;
    private SymboleTable parent;
    private int childrenRegion;

    public SymboleTable() {
        this.symboleTable = new ArrayList<>();
        this.regionNumber = region;
        region++;
        this.childrenRegion = region;
        region++;
        this.idNumber = id;
        id++;
        this.parent = null;
    }

    public SymboleTable(SymboleTable parent) {
        this.symboleTable = new ArrayList<>();
        this.regionNumber = parent.childrenRegion;
        this.childrenRegion = region;
        region++;
        this.idNumber = id;
        id++;
        this.parent = parent;
    }

    public void insert(SymboleTableEntry entry) {
        symboleTable.add(entry);
    }

    public SymboleTableEntry lookup(String name, boolean isFunction) {
        for (SymboleTableEntry entry : symboleTable) {
            if ((entry.getName() == name) && ((entry instanceof FunctionEntry) == isFunction)) {
                return entry;
            }
        }
        return null;
    }

    public ArrayList<SymboleTableEntry> getSymbolTable() {
        return symboleTable;
    }

    public int getRegionNumber() {
        return regionNumber;
    }

    public void print() {
        System.out.println("\n\n____________________________________________________");
        if (parent != null) {
            System.out.println("Region " + regionNumber + "\t / \tId " + idNumber+ ": "+ "Paren " + parent.regionNumber+ " / " + parent.idNumber);
        } else {
            System.out.println("Region " + regionNumber + "\t / \tId " + idNumber+ ": ");
        }
        System.out.println("____________________________________________________");
        System.out.println("Id\tKind\tName\tType\tValue");
        for (SymboleTableEntry entry : symboleTable) {
            entry.print();
        }
        System.out.println("____________________________________________________");
        System.out.println();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Type> lookupType(String name) {
        SymboleTableEntry entry;
        Type funcType = null;
        Type varType = null;
        SymboleTable curr = this;

        entry = curr.lookup(name, true);
        if (entry != null) {
            funcType = entry.getType();
        }
        entry = curr.lookup(name, false);
        if (entry != null) {
            varType = entry.getType();
        }

        while ((curr.parent != null) && (funcType == null || varType == null)){
            curr = curr.parent;
            entry = curr.lookup(name, true);
            if (entry != null) {
                funcType = entry.getType();
            }
            entry = curr.lookup(name, false);
            if (entry != null) {
                varType = entry.getType();
            }
        }

        ArrayList<Type> res = new ArrayList<>();
        if (funcType != null) {
            res.add(funcType);
        }
        if (varType != null) {
            res.add(varType);
        }
        return res;
    }
}

