package types;

import java.util.ArrayList;

public abstract class Type {
    public abstract boolean equals(Type other);
    public abstract String toString();
    
    public boolean isIn(ArrayList<Type> list) {
        for (Type ty : list) {
            if (this.equals(ty)) {
                return true;
            }
        }
        return false;
    }
}
