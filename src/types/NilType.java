package types;

public class NilType extends Type {
    @Override
    public boolean equals(Type other) {
        return other instanceof NilType;
    }
}