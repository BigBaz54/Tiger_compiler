package types;

import java.util.HashMap;
import java.util.Map;

public class TypeFactory {

    private static Map<String, Type> types = new HashMap<String, Type>();

    public TypeFactory() {
        types.put("int",new IntType());
        types.put("string",new StringType());
        types.put("nil",new NilType());
        types.put("bool",new BoolType());
        types.put("void",new VoidType());
    }

    public static Type getType(String id) {
        return types.get(id);
    }

    public static void addType(String id, Type type) {
        types.put(id, type);
    }



}
