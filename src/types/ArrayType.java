package types;

public class ArrayType extends Type {
    private Type elementType;
    private int size;

    public ArrayType(Type elementType, int size) {
        this.elementType = elementType;
        this.size = size;
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
}