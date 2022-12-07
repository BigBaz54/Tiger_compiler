package ast;

public interface AstVisitor<T> {
    public T visit(Program program) ;


    public T visit(Not not);
    public T visit(Exit exit);
}
