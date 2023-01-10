package SymboleTable;

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.misc.Pair;
import types.IntType;
import types.NilType;
import types.Type;
import types.TypeFactory;

public class SymboleTableList {
    private HashMap<Pair<Integer, Integer>, SymboleTable> symboleTableHash;

    public SymboleTableList() {
        this.symboleTableHash = new HashMap<>();
    }

    public void add(SymboleTable symboleTable) {
        int i = symboleTable.getRegionNumber();
        int j = symboleTable.getId();
        symboleTableHash.put(new Pair<>(i, j), symboleTable);
    }

    public SymboleTable get(int i, int j) {
        return symboleTableHash.get(new Pair<>(i, j));
    }

    public ArrayList<SymboleTable> getSymboleTableList() {
        return new ArrayList<>(symboleTableHash.values());
    }

    public int size() {
        return symboleTableHash.size();
    }

    public void print() {
        for (SymboleTable symboleTable : symboleTableHash.values()) {
            symboleTable.print();
        }
    }


}
