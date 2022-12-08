package graphViz;

import java.io.FileOutputStream;
import java.io.IOException;

import ast.*;

public class GraphVizVisitor implements AstVisitor<String> {

    private int state;
    private String nodeBuffer;
    private String linkBuffer;

    public GraphVizVisitor(){
        this.state = 0;
        this.nodeBuffer = "digraph \"ast\"{\n\n\tnodesep=1;\n\tranksep=1;\n\n";
        this.linkBuffer = "\n";
    }

    public void dumpGraph(String filepath) throws IOException{
            
        FileOutputStream output = new FileOutputStream(filepath);

        String buffer = this.nodeBuffer + this.linkBuffer + "}";
        byte[] strToBytes = buffer.getBytes();

        output.write(strToBytes);

        output.close();

    }


    private String nextState(){
        int returnedState = this.state;
        this.state++;
        return "N"+ returnedState;
    }

    private void addTransition(String from,String dest){
        this.linkBuffer += String.format("\t%s -> %s; \n", from,dest);

    }

    private void addNode(String node,String label){
        this.nodeBuffer += String.format("\t%s [label=\"%s\", shape=\"box\"];\n", node,label);

    }   
    
    @Override
    public String visit(Program program) {

        String nodeIdentifier = this.nextState();

        String instructionsState =program.child.accept(this);

        this.addNode(nodeIdentifier, "Program");
        this.addTransition(nodeIdentifier, instructionsState);

        return nodeIdentifier;

    }

    @Override
    public String visit(LValue lValue) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "LValue");

        for (Ast ast:lValue.lValue1) {
            String astState = ast.accept(this);
            this.addTransition(nodeId, astState);
        }

        return nodeId;
    }

    @Override
    public String visit(LValueDot lValueDot) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "LValueDot");

        String idState =lValueDot.id.accept(this);
        this.addTransition(nodeId, idState);

        return nodeId;
    }

    @Override
    public String visit(LValueBrack lValueBrack) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "LValueBrack");
        
        String expState = lValueBrack.exp.accept(this);
        this.addTransition(nodeId, expState);

        return nodeId;
    }

    @Override
    public String visit(Exp exp) {

        String nodeId = this.nextState();



            this.addNode(nodeId, ":=");
            
            if (exp.id != null) {
                String idState = exp.id.accept(this);
                this.addTransition(nodeId, idState);
            }

            if (exp.lvalue != null) {
                String lvalueState = exp.lvalue.accept(this);
                this.addTransition(nodeId, lvalueState);
            }
        
        return nodeId;
    }

    @Override
    public String visit(OrExp orExp) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "OR");

        String leftState = orExp.gauche.accept(this);
        String rightState = orExp.droite.accept(this);

        this.addTransition(nodeId, leftState);
        this.addTransition(nodeId, rightState);

        return nodeId;
    }

    @Override
    public String visit(AndExp andExp) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "AND");

        String leftState = andExp.gauche.accept(this);
        String rightState = andExp.droite.accept(this);

        this.addTransition(nodeId, leftState);
        this.addTransition(nodeId, rightState);
        
        return nodeId;
    }

    @Override
    public String visit(CompExp compExp) {
        
        if (compExp.op != null && compExp.plusExpR != null) {
            String nodeId= this.nextState();
            this.addNode(nodeId, compExp.op);

            String plusExpLState = compExp.plusExpL.accept(this);
            String plusExpRState = compExp.plusExpR.accept(this);

            this.addTransition(nodeId, plusExpLState);
            this.addTransition(nodeId, plusExpRState);

            return nodeId;
        } else {
            String plusExpLState = compExp.plusExpL.accept(this);

            return plusExpLState;
        }
    }

    @Override
    public String visit(PlusExp plusExp) {

        String nodeId= this.nextState();

        this.addNode(nodeId, plusExp.op);

        String leftState = plusExp.gauche.accept(this);
        String rightState = plusExp.droite.accept(this);

        this.addTransition(nodeId, leftState);
        this.addTransition(nodeId, rightState);

        return nodeId;
    }

    @Override
    public String visit(TimesExp timesExp) {

        String nodeId= this.nextState();

        this.addNode(nodeId, timesExp.op);

        String leftState = timesExp.gauche.accept(this);
        String rightState = timesExp.droite.accept(this);

        this.addTransition(nodeId, leftState);
        this.addTransition(nodeId, rightState);

        return nodeId;
    }

    @Override
    public String visit(StringLit str) {

        String nodeId= this.nextState();

        this.addNode(nodeId, str.value);
        
        return nodeId;
    }

    @Override
    public String visit(IntLit intLit) {

        String nodeId= this.nextState();

        this.addNode(nodeId, String.valueOf(intLit.value));

        return nodeId;
    }

    @Override
    public String visit(Print print) {

        String nodeId= this.nextState();

        this.addNode(nodeId, print.functName);

        String argState = print.arg.accept(this);
        this.addTransition(nodeId, argState);

        return nodeId;
    }

    @Override
    public String visit(Flush flush) {

        String nodeId= this.nextState();

        this.addNode(nodeId, flush.functName);

        return nodeId;
    }

    @Override
    public String visit(GetChar getChar) {

        String nodeId= this.nextState();

        this.addNode(nodeId, getChar.functName);

        return nodeId;
    }

    @Override
    public String visit(Ord ord) {

        String nodeId= this.nextState();

        this.addNode(nodeId, ord.functName);

        String stringArgState = ord.stringArg.accept(this);
        this.addTransition(nodeId, stringArgState);

        return nodeId;
    }

    @Override
    public String visit(Chr chr) {

        String nodeId= this.nextState();

        this.addNode(nodeId, chr.functName);

        String intArgState = chr.intArg.accept(this);
        this.addTransition(nodeId, intArgState);

        return nodeId;
    }

    @Override
    public String visit(Size size) {

        String nodeId= this.nextState();

        this.addNode(nodeId, size.functName);

        String stringArgState = size.stringArg.accept(this);
        this.addTransition(nodeId, stringArgState);

        return nodeId;
    }

    @Override
    public String visit(Substring substring) {

        String nodeId= this.nextState();

        this.addNode(nodeId, substring.functName);

        String stringArgState = substring.stringArg.accept(this);
        String intArg1State = substring.intArg1.accept(this);
        String intArg2State = substring.intArg2.accept(this);
        
        this.addTransition(nodeId, stringArgState);
        this.addTransition(nodeId, intArg1State);
        this.addTransition(nodeId, intArg2State);

        return nodeId;
    }

    @Override
    public String visit(Concat concat) {

        String nodeId= this.nextState();

        this.addNode(nodeId, concat.functName);

        String leftState = concat.left.accept(this);
        String rightState = concat.right.accept(this);

        this.addTransition(nodeId, leftState);
        this.addTransition(nodeId, rightState);

        return nodeId;
    }

    @Override
    public String visit(Not not) {

        String nodeId= this.nextState();

        this.addNode(nodeId, not.functName);

        String intArgState = not.intArg.accept(this);
        this.addTransition(nodeId, intArgState);

        return nodeId;
    }

    @Override
    public String visit(CallExp callExp) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "CallExp");

        for (Ast ast:callExp.expList) {
            String astState = ast.accept(this);
            this.addTransition(nodeId, astState);
        }

        return nodeId;
    }

    @Override
    public String visit(Break caca) {

        String nodeId= this.nextState();

        this.addNode(nodeId, caca.name);
        
        return nodeId;
    }

    @Override
    public String visit(Nill nill) {

        String nodeId= this.nextState();

        this.addNode(nodeId, nill.name);
        
        return nodeId;
    }

    @Override
    public String visit(SeqExp seqExp) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "SeqExp");

        for (Ast ast:seqExp.seqExp1) {
            String astState = ast.accept(this);
            this.addTransition(nodeId, astState);
        }

        return nodeId;
    }

    @Override
    public String visit(Id id) {

        String nodeId= this.nextState();

        this.addNode(nodeId, id.name);
        
        return nodeId;
    }

    @Override
    public String visit(VarDecNoType varDecNoType) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "VarDecNoType");

        String expState = varDecNoType.exp.accept(this);
        this.addTransition(nodeId, expState);
        
        return nodeId;
    }

    @Override
    public String visit(VarDecType varDecType) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "VarDecType");

        String typeState = varDecType.type.accept(this);
        String expState = varDecType.exp.accept(this);

        this.addTransition(nodeId, typeState);
        this.addTransition(nodeId, expState);
        
        return nodeId;
    }

    @Override
    public String visit(VarDec varDec) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "VarDec");

        String idState = varDec.id.accept(this);
        String rightState = varDec.right.accept(this);

        this.addTransition(nodeId, idState);
        this.addTransition(nodeId, rightState);
        
        return nodeId;
    }

    @Override
    public String visit(IdExp idExp) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "IdExp");

        String idState = idExp.id.accept(this);
        this.addTransition(nodeId, idState);

        if (idExp.exp != null) {
            String expState = idExp.exp.accept(this);
            this.addTransition(nodeId, expState);
        }
        
        return nodeId;
    }

    @Override
    public String visit(Negation negation) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "NOT");

        String expState = negation.exp.accept(this);
        this.addTransition(nodeId, expState);
        
        return nodeId;
    }

    @Override
    public String visit(IdExp1ArrayCreate idExp1ArrayCreate) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "IdExp1ArrayCreate");

        String expState = idExp1ArrayCreate.exp.accept(this);
        String exp1State = idExp1ArrayCreate.exp1.accept(this);

        this.addTransition(nodeId, expState);
        this.addTransition(nodeId, exp1State);
        
        return nodeId;
    }

    @Override
    public String visit(IdExp1RecordCreate idExp1RecordCreate) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "IdExp1RecordCreate");

        for (Ast ast:idExp1RecordCreate.feur) {
            String astState = ast.accept(this);
            this.addTransition(nodeId, astState);
        }
        
        return nodeId;
    }

    @Override
    public String visit(Exit exit) {

        String nodeId= this.nextState();

        this.addNode(nodeId, exit.functName);

        String intArgState = exit.intArg.accept(this);
        this.addTransition(nodeId, intArgState);
        
        return nodeId;
    }

    @Override
    public String visit(FunDecNoType funDecNoType) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "FunDecNoType");

        String expState = funDecNoType.exp.accept(this);
        this.addTransition(nodeId, expState);
        
        return nodeId;
    }

    @Override
    public String visit(FunDecType funDecType) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "FunDecType");

        String typeState = funDecType.type.accept(this);
        String rightState = funDecType.right.accept(this);

        this.addTransition(nodeId, typeState);
        this.addTransition(nodeId, rightState);
        
        return nodeId;
    }

    @Override
    public String visit(FunDec funDec) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "FunDec");

        String idState = funDec.id.accept(this);
        String rightState = funDec.right.accept(this);

        this.addTransition(nodeId, idState);
        this.addTransition(nodeId, rightState);

        for (Param param:funDec.params) {
            String idState1 = param.id.accept(this);
            String typeState = param.type.accept(this);

            this.addTransition(nodeId, idState1);
            this.addTransition(nodeId, typeState);
        }
        
        return nodeId;
    }

    @Override
    public String visit(TyDec tyDec) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "TyDec");

        String idState = tyDec.id.accept(this);
        String tyState = tyDec.ty.accept(this);

        this.addTransition(nodeId, idState);
        this.addTransition(nodeId, tyState);
        
        return nodeId;
    }

    @Override
    public String visit(TyDecRecord tyDecRecord) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "TyDecRecord");

        for (Param param:tyDecRecord.fields) {
            String idState1 = param.id.accept(this);
            String typeState = param.type.accept(this);

            this.addTransition(nodeId, idState1);
            this.addTransition(nodeId, typeState);
        }
        
        return nodeId;
    }

    @Override
    public String visit(Let let) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "Let");

        for (Ast ast:let.decs) {
            String astState = ast.accept(this);
            this.addTransition(nodeId, astState);
        }
        
        for (Ast ast:let.body) {
            String astState = ast.accept(this);
            this.addTransition(nodeId, astState);
        }

        return nodeId;
    }

    @Override
    public String visit(For for1) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "For");

        String idState = for1.id.accept(this);
        String initState = for1.init.accept(this);
        String condState = for1.cond.accept(this);
        String bodyState = for1.body.accept(this);

        this.addTransition(nodeId, idState);
        this.addTransition(nodeId, initState);
        this.addTransition(nodeId, condState);
        this.addTransition(nodeId, bodyState);
        
        return nodeId;
    }

    @Override
    public String visit(While while1) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "While");

        String condState = while1.cond.accept(this);
        String bodyState = while1.body.accept(this);

        this.addTransition(nodeId, condState);
        this.addTransition(nodeId, bodyState);
        
        return nodeId;
    }

    @Override
    public String visit(IfThenElse ifThenElse) {

        String nodeId= this.nextState();

        if (ifThenElse.elseBlock != null) {
            this.addNode(nodeId, "IfThenElse");

            String conditionState = ifThenElse.condition.accept(this);
            String thenBlockState = ifThenElse.thenBlock.accept(this);
            String elseBlockState = ifThenElse.elseBlock.accept(this);

            this.addTransition(nodeId, conditionState);
            this.addTransition(nodeId, thenBlockState);
            this.addTransition(nodeId, elseBlockState);
        } else {
            this.addNode(nodeId, "IfThen");

            String conditionState = ifThenElse.condition.accept(this);
            String thenBlockState = ifThenElse.thenBlock.accept(this);

            this.addTransition(nodeId, conditionState);
            this.addTransition(nodeId, thenBlockState);
        }

        return nodeId;
    }
}
