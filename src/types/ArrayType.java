package types;

public class ArrayType extends Type {
    private Type elementType;
    private int size;
    private String id;

    public ArrayType(String id,Type elementType, int size) {
        this.elementType = elementType;
        this.size = size;
        this.id = id;
    }

    public Type getElementType() {
        return elementType;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Type other) {
        if (other instanceof ArrayType) {
            ArrayType otherArray = (ArrayType) other;
            return elementType.equals(otherArray.getElementType()) && size == otherArray.getSize();
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
        return id;
    }
}