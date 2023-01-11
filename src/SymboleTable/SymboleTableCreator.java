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
        if(nameEquivalence.get(currentNode).equals("FunDec")){
            String nameFunction=nameEquivalence.get(children.get(0));
            Type typeFunction = null;
            if(children.size()>3){ // Si le type de la fonction est défini
                String returnType = tree.get(children.get(3)).get(0);
                typeFunction=typeFactory.getType(nameEquivalence.get(returnType));
            }
            ArrayList<String> paramchildren = tree.get(children.get(1));
            List<Type> params = new ArrayList<Type>();
            for (int i = 0; i < paramchildren.size(); i++) {
                String paramtype = nameEquivalence.get(tree.get(paramchildren.get(i)).get(1));
                params.add(typeFactory.getType(paramtype));
            }
            String bodyFunction = tree.get(children.get(2)).get(0);
            Type typeBodyFunction = typeFactory.getType(getType(bodyFunction));
            if(typeFunction != null && !typeFunction.equals(typeBodyFunction)){
                System.out.println("Error : Tyme mistmatch in function declaration of " + nameFunction);
            }
            FunctionEntry functionEntry = new FunctionEntry(nameFunction, params, typeBodyFunction,params.size());
            current_tds.insert(functionEntry);
        }
        
        if(children != null) {
            for(String child : children){
                createTable(child);
            }
        }
    }
    public String getType(String node){
        String nodeName = nameEquivalence.get(node);
        ArrayList<String> children = tree.get(node);
        switch (nodeName){
            case "RecordExp":
                return nameEquivalence.get(tree.get(children.get(0)).get(0));
            case "ArrayExp":
                return nameEquivalence.get(tree.get(children.get(0)).get(0));
            case "IfThenElse":
                // Retourn le type du then
                return getType(children.get(1));
            case "IfThen":
                return getType(children.get(1));
            default:    
                System.out.println("node : " + nodeName);
                List<String> operateur = Arrays.asList("+", "-", "*", "/", ">", "<", ">=", "<=", "=", "<>", "and", "or");
                try {
                    Integer.parseInt(nodeName);
                    return "int";
                }
                catch(NumberFormatException e){
                    if (operateur.contains(nameEquivalence.get(tree.get(children.get(0)).get(0)))){
                        return "int";
                    }
                    if(nameEquivalence.get(tree.get(children.get(0)).get(0)).contains("\"")){
                        return "string";
                    }
                }
                return null;
        }
    }
    public SymboleTableList getSymboleTableList() {
        return symboleTableList;
    }
}
