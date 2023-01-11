package SymboleTable;

import java.util.ArrayList;

import types.IntType;
import types.NilType;
import types.Type;
import types.TypeFactory;

public class SymboleTableList {
    private ArrayList<SymboleTable> symboleTableList;

    public SymboleTableList() {
        this.symboleTableList = new ArrayList<>();
    }

    public void add(SymboleTable symboleTable) {
        symboleTableList.add(symboleTable);
    }

    public SymboleTable get(int i) {
        return symboleTableList.get(i);
    }

    public ArrayList<SymboleTable> getSymboleTableList() {
        return symboleTableList;
    }

    public int size() {
        return symboleTableList.size();
    }

    public void print() {
        for (SymboleTable symboleTable : symboleTableList) {
            symboleTable.print();
        }
    }


}
