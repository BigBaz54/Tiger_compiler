package SymboleTable;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CreateTree {
    public HashMap<String, ArrayList<String>> getTree() {
        return tree;
    }

    public HashMap<String, String> getNameEquivalence() {
        return nameEquivalence;
    }

    HashMap<String, ArrayList<String>> tree = new HashMap<>();
    HashMap<String, String> nameEquivalence  = new HashMap<>();
    public void readFile(){
        try {
            File file = new File("out/tree.dot");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null) {
                if(!line.isEmpty() && !line.contains("{") && !line.contains("}") && !line.contains("nodesep") && !line.contains("ranksep")) {
                    if(line.contains("->")) {
                        String node = line.replace(";", "").replaceAll(" ","").trim();
                        String[] name = node.split("->");
                        ArrayList<String> children = tree.get(name[0]);
                        children.add(name[1]);
                        tree.put(name[0],children);
                    }
                    else {
                        String node = line.replace("\", shape=\"box\"];", "").replace("[label=\"", "").trim();
                        String [] name = node.split(" ");
                        tree.put(name[0], new ArrayList<>());
                        nameEquivalence.put(name[0], name[1]);
                    }
                }
            }
            br.close();
            fr.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public String getName(String name) {
        if(tree.get(name) != null) {
            return nameEquivalence.get(name);
        }
        return null;
    }

}
