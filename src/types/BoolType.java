package types;

public class BoolType extends Type{

    public boolean equals(Type other) {
        return other instanceof BoolType;
    }
    
}
