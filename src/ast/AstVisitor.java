package ast;

public interface AstVisitor<T> {
    public T visit(Program program) ;
    public T visit(LValue lValue) ;
    public T visit(LValueDot lValueDot) ;








    public T visit(Size size);
    public T visit(Substring substring);
    public T visit(Concat concat);
    public T visit(Not not);
    public T visit(Exit exit);
}
