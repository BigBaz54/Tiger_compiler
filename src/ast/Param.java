package ast;

public class Param extends Binary{

    public Id value2;

    public Param(Id id, Id type) {
        super(id, type);
        name = "Param";
    }
    
}
