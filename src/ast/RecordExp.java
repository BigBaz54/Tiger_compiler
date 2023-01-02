package ast;


import types.TypeFactory;
import types.Type;
import types.VoidType;

public class RecordExp extends IdExp implements TypeExp {

    public RecordExp(Id id, Ast exp) {
        super(id, exp);
        name = "RecordExp";
    }

    @Override
    public Type getType(){
        return new VoidType();
    }
    @Override
    public Type getType(TypeFactory f){
        return f.getType(id.name);
    }
}