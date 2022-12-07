package ast;

import parser.TigerParser;
import parser.TigerParserBaseVisitor;
import parser.TigerParserVisitor;

public class AstCreator extends TigerParserBaseVisitor<Ast> {
    public Ast visitProgram(TigerParser.ProgramContext ctx) {
        Ast child = ctx.getChild(0).accept(this);
        return new Program(child);
    }
    public Ast visitLValue(TigerParser.LValueContext ctx) {
        int childCount = ctx.getChildCount();
        LValue lValue = new LValue();
        for (int i = 0; i < childCount; i++) {
            lValue.addlvalue(ctx.getChild(i).accept(this));
        }
        return new LValue();
    }
    public Ast visitLValueDot(TigerParser.LValueDotContext ctx) {
        Ast id = ctx.getChild(1).accept(this);
        return new LValueDot(id);
    }

    public Ast visitLValueBrack(TigerParser.LValueBrackContext ctx) {
        Ast exp = ctx.getChild(1).accept(this);
        return new LValueBrack(exp);
    }

    public Ast visitExp(TigerParser.ExpContext ctx) {
        int childCount = ctx.getChildCount();
        switch (childCount) {
            case 1 -> {
                Ast Exp = ctx.getChild(0).accept(this);
                return new Exp(Exp);
            }
            case 4 -> {
                Ast id = ctx.getChild(0).accept(this);
                Ast lvalue = ctx.getChild(1).accept(this);
                Ast orExp = ctx.getChild(3).accept(this);
                return new Exp(id, lvalue, orExp);
            }
            case 3 -> {
                Ast id1 = ctx.getChild(0).accept(this);
                Ast orExp1 = ctx.getChild(2).accept(this);
                return new Exp(id1, orExp1);
            }
        }
        return null;
    }
    public Ast visitOrExp(TigerParser.OrExpContext ctx) {
        Ast noeudTemporaire = ctx.getChild(0).accept(this);
        for(int i=0;2*i<ctx.getChildCount()-1;i++){
            Ast right = ctx.getChild(2*i+1).accept(this);
            noeudTemporaire = new OrExp(noeudTemporaire,right);
        }
        return noeudTemporaire;
    }

    public Ast visitAndExp(TigerParser.AndExpContext ctx) {
        Ast noeudTemporaire = ctx.getChild(0).accept(this);
        for(int i=0;2*i<ctx.getChildCount()-1;i++){
            Ast right = ctx.getChild(2*i+1).accept(this);
            noeudTemporaire = new AndExp(noeudTemporaire,right);
        }
        return noeudTemporaire;
    }

    public Ast visitCompExp(TigerParser.CompExpContext ctx) {
        int childCount = ctx.getChildCount();
        switch (childCount) {
            case 1 -> {
                Ast compExp = ctx.getChild(0).accept(this);
                return new CompExp(compExp);
            }
            case 3 -> {
                Ast compExp1 = ctx.getChild(0).accept(this);
                Ast compExp2 = ctx.getChild(2).accept(this);
                String op = ctx.getChild(1).getText();
                return new CompExp(compExp1, compExp2, op);
            }
        }
        return null;
    }

    public Ast visitPlusExp(TigerParser.PlusExpContext ctx) {
        Ast noeuTemporaire = ctx.getChild(0).accept(this);
        for(int i=0;2*i<ctx.getChildCount()-1;i++){
            Ast right = ctx.getChild(2*i+1).accept(this);
            String op = ctx.getChild(2*i).getText();
            noeuTemporaire = new PlusExp(noeuTemporaire,right,op);
        }
        return noeuTemporaire;
    }

    public Ast visitTimesExp(TigerParser.TimesExpContext ctx) {
        Ast noeuTemporaire = ctx.getChild(0).accept(this);
        for(int i=0;2*i<ctx.getChildCount()-1;i++){
            Ast right = ctx.getChild(2*i+1).accept(this);
            String op = ctx.getChild(2*i).getText();
            noeuTemporaire = new TimesExp(noeuTemporaire,right,op);
        }
        return noeuTemporaire;
    }

    public Ast visitExp1(TigerParser.Exp1Context ctx) {
        return ctx.getChild(0).accept(this);
    }

    public Ast visitNilexp(TigerParser.NilexpContext ctx) {
        String nil = ctx.getChild(0).getText();
        return new Nill(nil);
    }

    public Ast visitIntLitexp(TigerParser.IntLitexpContext ctx) {
        int intLit = Integer.parseInt(ctx.getChild(0).getText());
        return new IntLit(intLit);
    }

    public Ast visitStringLitexp(TigerParser.StringLitexpContext ctx) {
        String stringLit = ctx.getChild(0).getText();
        return new StringLit(stringLit);
    }

    public Ast visitBreakexp(TigerParser.BreakexpContext ctx) {
        String breakk = ctx.getChild(0).getText();
        return new Break(breakk);
    }









    @Override
    public Ast visitIntArgLit(TigerParser.IntArgLitContext ctx) {
        return new IntLit(Integer.parseInt(ctx.getChild(0).toString()));
    }
    @Override
    public Ast visitIntArgExp(TigerParser.IntArgExpContext ctx) {
        return ctx.getChild(0).accept(this);
    }
    @Override
    public Ast visitStringArgLit(TigerParser.StringArgLitContext ctx) {
        return new StringLit(ctx.getChild(0).toString());
    }
    @Override
    public Ast visitStringArgExp(TigerParser.StringArgExpContext ctx) {
        return ctx.getChild(0).accept(this);
    }
    @Override
    public Ast visitPrint(TigerParser.PrintContext ctx) {
        Ast stringArg = ctx.getChild(2).accept(this);
        return new Print(stringArg);
    }
    @Override
    public Ast visitFlush(TigerParser.FlushContext ctx) {
        return new Flush();
    }
    @Override
    public Ast visitGetchar(TigerParser.GetcharContext ctx) {
        return new GetChar();
    }
    @Override
    public Ast visitOrd(TigerParser.OrdContext ctx) {
        Ast stringArg = ctx.getChild(2).accept(this);
        return new Ord(stringArg);
    }
    @Override
    public Ast visitChr(TigerParser.ChrContext ctx) {
        Ast intArg = ctx.getChild(2).accept(this);
        return new Chr(intArg);
    }
    @Override
    public Ast visitSize(TigerParser.SizeContext ctx) {
        Ast stringArg = ctx.getChild(2).accept(this);
        return new Size(stringArg);
    }
    @Override
    public Ast visitSubstring(TigerParser.SubstringContext ctx) {
        Ast stringArg = ctx.getChild(2).accept(this);
        Ast intArg1 = ctx.getChild(4).accept(this);
        Ast intArg2 = ctx.getChild(6).accept(this);
        return new Substring(stringArg, intArg1, intArg2);
    }
    @Override
    public Ast visitConcat(TigerParser.ConcatContext ctx) {
        Ast left = ctx.getChild(2).accept(this);
        Ast right = ctx.getChild(4).accept(this);
        return new Concat(left, right);
    }
    @Override
    public Ast visitNot(TigerParser.NotContext ctx) {
        Ast intArg = ctx.getChild(2).accept(this);
        return new Not(intArg);
    }
    @Override
    public Ast visitExit(TigerParser.ExitContext ctx) {
        Ast intArg = ctx.getChild(2).accept(this);
        return new Exit(intArg);
    }
}
