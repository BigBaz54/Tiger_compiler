package ast;

public interface AstVisitor<T> {
    public T visit(Program program) ;
    public T visit(LValue lValue) ;
    public T visit(LValueDot lValueDot) ;
    public T visit(LValueBrack lValueBrack) ;
    public T visit(Exp exp) ;
    public T visit(OrExp orExp) ;
    public T visit(AndExp andExp) ;
    public T visit(CompExp compExp) ;
    public T visit(PlusExp plusExp) ;
    public T visit(TimesExp timesExp) ;
    public T visit(Exp1 exp1) ;







 
    public T visit(Print print);
    public T visit(Flush flush);
    public T visit(GetChar getChar);
    public T visit(Ord ord);
    public T visit(Chr chr);
    public T visit(Size size);
    public T visit(Substring substring);
    public T visit(Concat concat);
    public T visit(Not not);
    public T visit(Exit exit);
}
