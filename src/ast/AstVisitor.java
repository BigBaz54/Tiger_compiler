package ast;

import parser.TigerParser.VarDec1NoTypeContext;

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
    public T visit(Nill nill) ;
    public T visit(Break Breack) ;
    public T visit(SeqExp seqExp) ;
    public T visit(Negation negation) ;
    public T visit(IdExp idExp) ;
    public T visit(IdExp1ArrayCreate idExp1ArrayCreate) ;
    public T visit(IdExp1ReccordCreate idExp1ReccordCreate) ;






 

    public T visit(VarDec varDec);
    public T visit(VarDecType varDecType);
    public T visit(VarDecNoType varDecNoType);
    public T visit(Id id);
    public T visit(CallExp callExp);
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
}
