package SymboleTable;

import java.util.ArrayList;

import types.TypeFactory;

public class SymboleTableList {
    private ArrayList<SymboleTable> symboleTableList;

    public SymboleTableList() {
        this.symboleTableList = new ArrayList<>();
    }

    public void add(SymboleTable symboleTable) {
        symboleTableList.add(symboleTable);
    }

    public SymboleTable get(int index) {
        return symboleTableList.get(index);
    }

    public ArrayList<SymboleTable> getSymboleTableList() {
        return symboleTableList;
    }

    public int size() {
        return symboleTableList.size();
    }

    public void print(TypeFactory f) {
        for (SymboleTable symboleTable : symboleTableList) {
            symboleTable.print(f);
        }
    }
}
