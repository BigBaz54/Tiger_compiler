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







    public Ast visitSize(TigerParser.SizeContext ctx) {
        Ast stringArg = ctx.getChild(2).accept(this);
        return new Size(stringArg);
    }

    public Ast visitSubstring(TigerParser.SubstringContext ctx) {
        Ast stringArg = ctx.getChild(2).accept(this);
        Ast intArg1 = ctx.getChild(4).accept(this);
        Ast intArg2 = ctx.getChild(6).accept(this);
        return new Substring(stringArg, intArg1, intArg2);
    }

    public Ast visitConcat(TigerParser.ConcatContext ctx) {
        Ast left = ctx.getChild(2).accept(this);
        Ast right = ctx.getChild(4).accept(this);
        return new Concat(left, right);
    }

    public Ast visitNot(TigerParser.NotContext ctx) {
        Ast intArg = ctx.getChild(2).accept(this);
        return new Not(intArg);
    }

    public Ast visitExit(TigerParser.ExitContext ctx) {
        Ast intArg = ctx.getChild(2).accept(this);
        return new Exit(intArg);
    }
}
