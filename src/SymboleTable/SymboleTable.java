package SymboleTable;

import java.util.ArrayList;

import types.IntType;
import types.StringType;
import types.Type;
import types.VoidType;

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
            if ((entry.getName().equals(name)) && ((entry instanceof FunctionEntry) == isFunction)) {
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
        System.out.println("\n\n____________________________________________________________________");
        if (parent != null) {
            System.out.println("Region " + regionNumber + "\t / \tId " + idNumber+ "\t / \t "+ "Parent " + parent.regionNumber+ " / " + parent.idNumber);
        } else {
            System.out.println("Region " + regionNumber + "\t / \tId " + idNumber);
        }
        System.out.println("____________________________________________________________________");
        System.out.println("Id\tKind\tName\tType\tOffset\tArgs.");
        for (SymboleTableEntry entry : symboleTable) {
            entry.print();
        }
        System.out.println("____________________________________________________________________");
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

    public Type lookupTypeFun(String name) {
        switch (name) {
            case "print" -> {
                return new VoidType();
            }
            case "chr" -> {
                return new StringType();
            }
            case "flush" -> {
                return new VoidType();
            }
            case "concat" -> {
                return new StringType();
            }
            case "exit" -> {
                return new VoidType();
            }
            case "getchar" -> {
                return new StringType();
            }
            case "not" -> {
                return new IntType();
            }
            case "ord" -> {
                return new IntType();
            }
            case "size" -> {
                return new IntType();
            }
            case "substring" -> {
                return new StringType();
            }
        }
        SymboleTableEntry entry;
        SymboleTable curr = this;

        entry = curr.lookup(name, true);
        if (entry != null) {
            return entry.getType();
        }

        while (curr.parent != null){
            curr = curr.parent;
            entry = curr.lookup(name, true);
            if (entry != null) {
                return entry.getType();
            }
        }

        return null;
    }

    public Type lookupTypeVar(String name) {
        SymboleTableEntry entry;
        SymboleTable curr = this;

        entry = curr.lookup(name, false);
        if (entry != null) {
            return entry.getType();
        }

        while (curr.parent != null){
            curr = curr.parent;
            entry = curr.lookup(name, false);
            if (entry != null) {
                return entry.getType();
            }
        }
        
        return null;
    }

    public int getNbArg(String name) {
        SymboleTableEntry entry;
        SymboleTable curr = this;

        entry = curr.lookup(name, true);
        if (entry != null) {
            return ((FunctionEntry) entry).getNumParameters();
        }

        while (curr.parent != null){
            curr = curr.parent;
            entry = curr.lookup(name, true);
            if (entry != null) {
                return ((FunctionEntry) entry).getNumParameters();
            }
        }
        
        return -1;
    }
}

