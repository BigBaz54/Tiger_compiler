package ast;

public class Binary {

    public Id value1;
    public Ast value2;
    public String name;

    public Binary(Id value1, Ast value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
    
}
