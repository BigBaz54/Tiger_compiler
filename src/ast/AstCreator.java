package ast;

import parser.TigerParser;
import parser.TigerParserBaseVisitor;
import parser.TigerParserVisitor;

public class AstCreator extends TigerParserBaseVisitor<Ast> {
    public Ast visitProgram(TigerParser.ProgramContext ctx) {
        Ast child = ctx.getChild(0).accept(this);
        return new Program(child);
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
