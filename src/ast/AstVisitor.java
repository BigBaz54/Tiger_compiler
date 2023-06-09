package ast;

public interface AstVisitor<T> {
    public T visit(Program program);
    public T visit(LValueDot lValueDot);
    public T visit(LValueBrack lValueBrack);
    public T visit(LValue lValue);
    public T visit(Exp exp) ;
    public T visit(OrExp orExp) ;
    public T visit(AndExp andExp) ;
    public T visit(CompExp compExp) ;
    public T visit(PlusExp plusExp) ;
    public T visit(TimesExp timesExp) ;
    public T visit(Nill nill) ;
    public T visit(Break Breack) ;
    public T visit(SeqExp seqExp) ;
    public T visit(Negation negation) ;
    public T visit(IdExp idExp) ;
    public T visit(ArrayCreate ArrayCreate) ;
    public T visit(IfThenElse ifThenElse);
    public T visit(While while1);
    public T visit(For for1);
    public T visit(Let let);
    public T visit(TyDec tyDec);
    public T visit(List l);
    public T visit(FunDec funDec);
    public T visit(FunDecType funDecType);
    public T visit(AstList params);
    public T visit(VarDec varDec);
    public T visit(VarDecType varDecNoType);
    public T visit(VarType varType);
    public T visit(Id id);
    public T visit(IntLit intLit);
    public T visit(StringLit str);
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
    public T visit(LValueExp lValueExp);
}
