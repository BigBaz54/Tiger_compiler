package types;

import java.util.HashMap;
import java.util.Map;

public class TypeFactory {

    private Map<String, Type> types = new HashMap<String, Type>();

    public TypeFactory() {
        types.put("int",new IntType());
        types.put("string",new StringType());
        types.put("nil",new NilType());
        types.put("bool",new BoolType());
        types.put("void",new VoidType());
    }

    public Type getType(String id) {
        return types.get(id);
    }

    public String getType(Type type) {
        for (Map.Entry<String, Type> entry : types.entrySet()) {
            if (entry.getValue().equals(type)) {
                String s =  entry.getKey();
                return s;
            }
        }
        return null;
    }

    public void addType(String id, Type type) {
        types.put(id, type);
    }



}
