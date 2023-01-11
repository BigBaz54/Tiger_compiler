package SymboleTable;

import types.ArrayType;
import types.RecordType;
import types.Type;
import types.TypeFactory;

import java.util.*;

public class SymboleTableCreator {
    HashMap<String, ArrayList<String>> tree = new HashMap<>();
    HashMap<String, String> nameEquivalence  = new HashMap<>();
    private SymboleTableList symboleTableList;
    private SymboleTable current_tds;
    private TypeFactory typeFactory = new TypeFactory();
    public SymboleTableCreator (HashMap<String, ArrayList<String>> tree, HashMap<String, String> nameEquivalence) {
        this.tree = tree;
        this.nameEquivalence = nameEquivalence;
        this.symboleTableList = new SymboleTableList();
        this.current_tds = new SymboleTable();
        this.symboleTableList.add(current_tds);
    }

    public void createTable(String currentNode) {
        ArrayList<String> children = tree.get(currentNode);
        if (nameEquivalence.get(currentNode).equals("VarDec")) {
            if (nameEquivalence.get(children.get(0)).equals(":")){
                String nameVar=nameEquivalence.get(tree.get(children.get(0)).get(0));
                String typeVar=nameEquivalence.get(tree.get(children.get(0)).get(1));
                current_tds.insert(new VariableEntry(nameVar, typeFactory.getType(typeVar), 0,0));
            }
            else {
                String nameVar=nameEquivalence.get(children.get(0));
                String typeVar=getType(nameEquivalence.get(children.get(1)));
                current_tds.insert(new VariableEntry(nameVar, typeFactory.getType(typeVar), 0,0));
            }
        }
        if(nameEquivalence.get(currentNode).equals("TypeDecRecord")){
            String nameType=nameEquivalence.get(children.get(0));
            ArrayList<String> fieldchildren = tree.get(children.get(1));
            Map<String, Type> fields = new HashMap<String, Type>();
            for (int i = 0; i < fieldchildren.size(); i++) {
                String fieldname = nameEquivalence.get(tree.get(fieldchildren.get(i)).get(0));
                String fieldtype = nameEquivalence.get(tree.get(fieldchildren.get(i)).get(1));
                fields.put(fieldname, typeFactory.getType(fieldtype));
            }
            RecordType recordType = new RecordType(nameType, fields);
            typeFactory.addType(nameType, recordType);
        }
        if(nameEquivalence.get(currentNode).equals("TypeDecArray")){
            String nameType=nameEquivalence.get(children.get(0));
            String typeType=getType(nameEquivalence.get(children.get(1)));
            ArrayType arrayType = new ArrayType(nameType, typeFactory.getType(typeType),0);
            typeFactory.addType(nameType, arrayType);
        }
        if(nameEquivalence.get(currentNode).equals("TypeDec")){
            String nameType=nameEquivalence.get(children.get(0));
            String typeType=getType(nameEquivalence.get(children.get(1)));
            typeFactory.addType(nameType, typeFactory.getType(typeType));
        }
        if(children != null) {
            for(String child : children){
                createTable(child);
            }
        }
    }
    public String getType(String node){
        ArrayList<String> children = tree.get(node);
        if (nameEquivalence.get(node).equals("RecordExp")){
            return nameEquivalence.get(tree.get(children.get(0)).get(0));
        }
        else if(nameEquivalence.get(node).equals("ArrayExp")){
            return nameEquivalence.get(tree.get(children.get(0)).get(0));
        }
        else{
            List<String> operateur = Arrays.asList("+", "-", "*", "/", ">", "<", ">=", "<=", "=", "<>", "and", "or");
            if (operateur.contains(nameEquivalence.get(tree.get(children.get(0)).get(0)))){
                return "int";
            }
            if(nameEquivalence.get(tree.get(children.get(0)).get(0)).contains("\"")){
                return "string";
            }
        }
        return null;
    }
    public SymboleTableList getSymboleTableList() {
        return symboleTableList;
    }
}
