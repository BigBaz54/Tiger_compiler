package types;

public class FloatType extends Type {
    public boolean equals(Type other) {
        return other instanceof FloatType;
    }
    public String toString() {
        return "float";
    }
}
