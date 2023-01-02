package types;

public class VoidType extends Type{
    public boolean equals(Type other) {
        return other instanceof VoidType;
    }
}
