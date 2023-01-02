package types;

public class IntType extends Type {
    public boolean equals(Type other) {
        return other instanceof IntType;
    }
    public String toString() {
        return "int";
    }
}
