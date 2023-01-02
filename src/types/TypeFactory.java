package types;

public class TypeFactory {
    
    public static Type fromString(String s) {
        switch(s) {
            case "int": return new IntType();
            case "string": return new StringType();
            case "nil": return new NilType();
            case "boolean": return new BoolType();
            default: throw new IllegalArgumentException("Invalid type: " + s);
        }
    }



}
