package ast;

import java.util.ArrayList;

public class LValueExp extends IdExp{

    public LValueExp(Id id, Ast right) {
        super(id,right);
        name = "LValue";
    }
    public LValueExp(Id id, Ast right, String name) {
        super(id,right);
        this.name = name;
    }

}
