package ast;

import types.Type;
import types.TypeFactory;

public interface TypeExp {
    
    public Type getType();

    default public Type getType(TypeFactory f) {
        return getType();
    }
}
