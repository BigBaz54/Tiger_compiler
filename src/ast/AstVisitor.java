package ast;

public interface AstVisitor<T> {
    public <T> T visit(Program program) ;
}
