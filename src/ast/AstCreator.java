package ast;

import parser.TigerParser;
import parser.TigerParserBaseVisitor;

public class AstCreator extends TigerParserBaseVisitor<Ast> {
    public Ast visitProgram(TigerParser.ProgramContext ctx) {
        Ast child = ctx.getChild(0).accept(this);
        return new Program(child);
    }

    public Ast visitLValue(TigerParser.LValueContext ctx) {
        int childCount = ctx.getChildCount();
        Ast lValue = ctx.getChild(0).accept(this);
        if (childCount == 1) {
            return lValue;
        }
        for (int i = 1; i < childCount; i++) {
            Ast temp = ctx.getChild(i).accept(this);
            ((LValueExp) temp).accessed = lValue;
            lValue = temp;
        }
        return lValue;
    }

    public Ast visitLValueDot(TigerParser.LValueDotContext ctx) {
        return new LValueDot(null, new Id(ctx.getChild(1).toString()));
    }

    public Ast visitLValueBrack(TigerParser.LValueBrackContext ctx) {
        return new LValueBrack(null, ctx.getChild(1).accept(this));
    }

    public Ast visitExp(TigerParser.ExpContext ctx) {
        int childCount = ctx.getChildCount();
        switch (childCount) {
            case 1 -> {
                Ast Exp = ctx.getChild(0).accept(this);
                return Exp;
            }
            case 4 -> {
                Ast lValue = ctx.getChild(1).accept(this);
                ((LValueExp) lValue).setId(new Id(ctx.getChild(0).toString()));
                Ast orExp = ctx.getChild(3).accept(this);
                return new Exp(null,lValue, orExp);
            }
            case 3 -> {
                Id id1 = new Id(ctx.getChild(0).toString());
                Ast orExp1 = ctx.getChild(2).accept(this);
                return new Exp(id1, null,orExp1);
            }
        }
        return null;
    }
    public Ast visitOrExp(TigerParser.OrExpContext ctx) {
        Ast noeudTemporaire = ctx.getChild(0).accept(this);
        for(int i=1;2*i<ctx.getChildCount();i++){
            Ast right = ctx.getChild(2*i).accept(this);
            noeudTemporaire = new OrExp(noeudTemporaire,right);
        }
        return noeudTemporaire;
    }

    public Ast visitAndExp(TigerParser.AndExpContext ctx) {
        Ast noeudTemporaire = ctx.getChild(0).accept(this);
        for(int i=1;2*i<ctx.getChildCount();i++){
            Ast right = ctx.getChild(2*i).accept(this);
            noeudTemporaire = new AndExp(noeudTemporaire,right);
        }
        return noeudTemporaire;
    }

    public Ast visitCompExp(TigerParser.CompExpContext ctx) {
        int childCount = ctx.getChildCount();
        switch (childCount) {
            case 1 -> {
                Ast compExp = ctx.getChild(0).accept(this);
                return compExp;
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
        for(int i=0;2*i+1<ctx.getChildCount();i++){
            Ast right = ctx.getChild(2*i+2).accept(this);
            String op = ctx.getChild(2*i+1).getText();
            noeuTemporaire = new PlusExp(noeuTemporaire,right,op);
        }
        return noeuTemporaire;
    }

    public Ast visitTimesExp(TigerParser.TimesExpContext ctx) {
        Ast noeuTemporaire = ctx.getChild(0).accept(this);
        for(int i=0;2*i+1<ctx.getChildCount();i++){
            Ast right = ctx.getChild(2*i+2).accept(this);
            String op = ctx.getChild(2*i+1).getText();
            noeuTemporaire = new TimesExp(noeuTemporaire,right,op);
        }
        return noeuTemporaire;
    }

    public Ast visitExp1(TigerParser.Exp1Context ctx) {
        return ctx.getChild(0).accept(this);
    }

    public Ast visitNilexp(TigerParser.NilexpContext ctx) {
        return new Nill();
    }

    public Ast visitIntLitexp(TigerParser.IntLitexpContext ctx) {
        int intLit = Integer.parseInt(ctx.getChild(0).toString());
        return new IntLit(intLit);
    }

    public Ast visitStringLitexp(TigerParser.StringLitexpContext ctx) {
        String stringLit = ctx.getChild(0).toString();
        return new StringLit(stringLit);
    }

    public Ast visitBreakexp(TigerParser.BreakexpContext ctx) {
        return new Break();
    }

    public Ast visitSeqExp(TigerParser.SeqExpContext ctx) {
        int childCount = ctx.getChildCount();
        if (childCount == 2) {
            return new SeqExp();
        } else if (childCount==3) {
            return ctx.getChild(1).accept(this);
        } else {
            Ast exp1 = ctx.getChild(1).accept(this);
            SeqExp seqExp = new SeqExp();
            seqExp.addseqExp(exp1);
            for (int i = 0; 2*i+3 < childCount - 1; i++) {
                Ast exp2 = ctx.getChild(2*i+3).accept(this);
                seqExp.addseqExp(exp2);
            }
            return seqExp;
        }
    }

    public Ast visitNegation(TigerParser.NegationContext ctx) {
        Ast exp = ctx.getChild(1).accept(this);
        return new Negation(exp);
    }

    public Ast visitIdExp(TigerParser.IdExpContext ctx) {
        int childCount = ctx.getChildCount();
        switch (childCount) {
            case 1 -> {
                Ast id =new Id (ctx.getChild(0).toString());
                return id;
            }
            case 2 -> {
                Id id =new Id (ctx.getChild(0).toString());
                Ast right = ctx.getChild(1).accept(this);
                switch (right.getClass().getSimpleName()) {
                    case "ArrayCreate" -> {
                        return new ArrayExp(id, ((ArrayCreate) right).integer, ((ArrayCreate) right).exp);
                    }
                    case "FieldList" -> {
                        return new RecordExp(id, right);
                    }
                    case "LValueDot" -> {
                        // jamais utilisé je crois
                        ((LValueExp) right).setId(id);
                        return right;
                    }
                    case "LValueBrack" -> {
                        // jamais utilisé je crois
                        ((LValueExp) right).setId(id);
                        return right;
                    }
                    case "AstList" -> {
                        return new CallExp(id, right);
                    }
                    default -> {
                        return new CallExp(id, right);
                    }
                }
            }
        }
        return null;
    }

    public Ast visitIdExp1CallExp(TigerParser.IdExp1CallExpContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    public Ast visitIdExp1LValue(TigerParser.IdExp1LValueContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    public Ast visitIdExp1ArrayCreate(TigerParser.IdExp1ArrayCreateContext ctx) {
        Ast integer = ctx.getChild(1).accept(this);
        Ast exp = ctx.getChild(4).accept(this);
        return new ArrayCreate(integer, exp);
    }

    public Ast visitIdExp1RecordCreate(TigerParser.IdExp1RecordCreateContext ctx) {
        int childCount = ctx.getChildCount();
        if (childCount == 2) {
            return new FieldList();
        } else {
            FieldList records = new FieldList();
            for (int i = 3; i < childCount ; i=i+4) {
                Id id = new Id(ctx.getChild(i-2).toString());
                Ast fieldExp = ctx.getChild(i).accept(this);
                RecordValue recordValue = new RecordValue(id,fieldExp);
                records.add(recordValue);
            }
            return records;
        }
    }


    @Override
    public Ast visitIfThenElse(TigerParser.IfThenElseContext ctx) {
        Ast cond = ctx.getChild(1).accept(this);
        Ast exp1 = ctx.getChild(3).accept(this);
        if (ctx.getChildCount() == 6) {
            Ast exp2 = ctx.getChild(5).accept(this);
            return new IfThenElse(cond,exp1,exp2);
        }
        return new IfThenElse(cond,exp1);
    }
    @Override
    public Ast visitWhileExp(TigerParser.WhileExpContext ctx) {
        Ast cond = ctx.getChild(1).accept(this);
        Ast exp = ctx.getChild(3).accept(this);
        return new While(cond,exp);
    }
    @Override
    public Ast visitForExp(TigerParser.ForExpContext ctx) {
        Ast id = new Id(ctx.getChild(1).toString());
        Ast init = ctx.getChild(3).accept(this);
        Ast cond = ctx.getChild(5).accept(this);
        Ast body = ctx.getChild(7).accept(this);
        return new For(id,init,cond,body);
    }

    @Override
    public Ast visitLetExp(TigerParser.LetExpContext ctx) {
        Let let = new Let();
        int childCount = ctx.getChildCount();
        int i=1;
        while(!ctx.getChild(i).toString().equals("in")){
            Ast dec = ctx.getChild(i).accept(this);
            let.addDec(dec);
            i++;
        }
        i++;
        while(i<childCount-1){
            Ast exp = ctx.getChild(i).accept(this);
            let.addBody(exp);
            i++;
            i++;
        }
        return let;
    }

    @Override
    public Ast visitDeclaration(TigerParser.DeclarationContext ctx) {
        return ctx.getChild(0).accept(this);
    }
    @Override
    public Ast visitTyDec(TigerParser.TyDecContext ctx) {
        Id id = new Id(ctx.getChild(1).toString());
        Ast right = ctx.getChild(3).accept(this);
        if(right instanceof Id){
            boolean isArray = ((Id) right).isArrayId;
            if (isArray)
                return new TyDecArray(id,(Id) right);
            else
                return new TyDecId(id,(Id) right);
        }
        else if (right instanceof FieldList){
            return new TyDecRecord(id,right);
        }
        return null;
    }
    @Override
    public Ast visitTyDec1Id(TigerParser.TyDec1IdContext ctx) {
        return new Id(ctx.getChild(0).toString());
    }
    @Override
    public Ast visitTyDec1Array(TigerParser.TyDec1ArrayContext ctx) {
        return new Id(ctx.getChild(2).toString(),true);
    }
    @Override
    public Ast visitTyDec1Record(TigerParser.TyDec1RecordContext ctx) {
        FieldList listFields = new FieldList();
        int n = ctx.getChildCount();
        if (n == 2) {
            return listFields;
        }
        Id id = new Id(ctx.getChild(1).toString());
        Id type = new Id(ctx.getChild(3).toString());
        RecordType recordType = new RecordType(id, type);
        listFields.add(recordType);
        for (int i = 1; 4*i+3 < n - 1; i++) {
            Id id1 = new Id(ctx.getChild(4*i+1).toString());
            Id type1 = new Id(ctx.getChild(4*i+3).toString());
            RecordType recordType1 = new RecordType(id1, type1);
            listFields.add(recordType1);
        }
        return listFields;
    }
    @Override
    public Ast visitFunDec(TigerParser.FunDecContext ctx) {
        int n = ctx.getChildCount();
        Id id = new Id(ctx.getChild(1).toString());
        // List of parameters
        ParamList params = new ParamList();
        for (int i = 0; 4*i+5 < n - 2; i++) {
            Id paramId = new Id(ctx.getChild(4*i+3).toString());
            Id paramType = new Id(ctx.getChild(4*i+5).toString());
            Param param = new Param(paramId, paramType);
            params.add(param);
        }
        // Body
        Ast temp = ctx.getChild(n-1).accept(this);
        if (temp instanceof FunDecType){
            Ast body = ((FunDecType) temp).body;
            Id returnType = ((FunDecType) temp).type;
            return new FunDec(id, params, body, returnType);
        }else {
            Ast body = temp;
            return new FunDec(id, params, body);
        }
    }
    @Override
    public Ast visitFunDec1NoType(TigerParser.FunDec1NoTypeContext ctx) {
        Ast exp = ctx.getChild(1).accept(this);
        return exp;
    }
    @Override
    public Ast visitFunDec1Type(TigerParser.FunDec1TypeContext ctx) {
        Id type = new Id(ctx.getChild(1).toString());
        Ast exp = ctx.getChild(3).accept(this);
        return new FunDecType(type, exp);
    }
    @Override
    public Ast visitVarDec(TigerParser.VarDecContext ctx) {
        Id id = new Id(ctx.getChild(1).toString());
        Ast right = ctx.getChild(2).accept(this);
        Ast left;
        if(right instanceof VarDecType){
            Id type = (Id) ((VarDecType) right).type;
            left = new VarType(id, type);
            right = ((VarDecType) right).exp;
        }else{
            left = id;
        }
        return new VarDec(left, right);
    }
    @Override
    public Ast visitVarDec1NoType(TigerParser.VarDec1NoTypeContext ctx) {
        Ast exp = ctx.getChild(1).accept(this);
        return exp;
    }
    @Override
    public Ast visitVarDec1Type(TigerParser.VarDec1TypeContext ctx) {
        Ast type = new Id(ctx.getChild(1).toString());
        Ast exp = ctx.getChild(3).accept(this);
        return new VarDecType(type, exp);
    }
    @Override
    public Ast visitCallExp(TigerParser.CallExpContext ctx) {
        int n = ctx.getChildCount();
        AstList params = new AstList();
        for (int i = 0; 2*i < n-2; i++) {
            Ast param = ctx.getChild(2*i+1).accept(this);
            params.addParam(param);
        }
        return params;
        
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
