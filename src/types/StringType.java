package types;

public class StringType extends Type {
    public boolean equals(Type other) {
        return other instanceof StringType;
    }
}
