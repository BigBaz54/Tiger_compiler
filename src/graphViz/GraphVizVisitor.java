package graphViz;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import ast.*;
import ast.RecordType;
import SymboleTable.*;
import types.NilType;
import types.Type;

public class GraphVizVisitor implements AstVisitor<String> {

    private int state;
    private String nodeBuffer;
    private String linkBuffer;
    private SymboleTableList symboleTableList;

    public GraphVizVisitor(){
        this.symboleTableList = new SymboleTableList();
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

        symboleTableList.print();

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
        symboleTableList.add(new SymboleTable());
        return nodeIdentifier;

    }


    @Override
    public String visit(LValue lValue) {
        // jamais utilisée
        String nodeId= this.nextState();
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

            String expState = exp.orExp.accept(this);
            this.addTransition(nodeId, expState);
        
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
            return compExp.plusExpL.accept(this);
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
    public String visit(AstList astList) {
        String nodeId= this.nextState();
        this.addNode(nodeId,astList.name);

        for (Ast ast:astList.list) {
            String astState = ast.accept(this);
            String nodeIdAst = this.nextState();
            this.addNode(nodeIdAst, "Param");
            this.addTransition(nodeIdAst, astState);
            this.addTransition(nodeId, nodeIdAst);
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
    public String visit(VarDecType varDecType) {
        // jamais utilisée
        String nodeId= this.nextState();
        return nodeId;
    }

    @Override
    public String visit(VarDec varDec) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "VarDec");

        String leftState = varDec.left.accept(this);
        String rightState = varDec.right.accept(this);

        this.addTransition(nodeId, leftState);
        this.addTransition(nodeId, rightState);


        
        return nodeId;
    }
    @Override
    public String visit(VarType varType) {

        String nodeId= this.nextState();

        this.addNode(nodeId, ":");

        String idState = varType.id.accept(this);
        String typeState = varType.type.accept(this);

        this.addTransition(nodeId, idState);
        this.addTransition(nodeId, typeState);
        
        return nodeId;
    }

    @Override
    public String visit(IdExp idExp) {

        String nodeId= this.nextState();

        this.addNode(nodeId, idExp.name);

        String idState = idExp.id.accept(this);
        this.addTransition(nodeId, idState);

        if (idExp.expList != null) {
            for (Ast exp:idExp.expList) {
                String expState = exp.accept(this);
                this.addTransition(nodeId, expState);
            }
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
    public String visit(ArrayCreate ArrayCreate) {
        // Jamais utilisée
        String nodeId= this.nextState();        
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
    public String visit(FunDecType funDecType) {
        // Jamais utilisée
        String nodeId= this.nextState();        
        return nodeId;
    }

    @Override
    public String visit(FunDec funDec) {
        SymboleTable symboleTable = new SymboleTable();

        String nodeId= this.nextState();

        this.addNode(nodeId, "FunDec");

        String idState = funDec.id.accept(this);
        String paramState = funDec.params.accept(this);
        for (Binary param :funDec.params.list) {
            String name = param.value1.toString();
            Type type =(Type) param.value2;
            VariableEntry entry = new VariableEntry(name, type,0,0);
            symboleTable.insert(entry);
        }


        String bodyId = this.nextState();
        this.addNode(bodyId, "Body");
        String bodyState = funDec.body.accept(this);

        this.addTransition(nodeId, idState);
        this.addTransition(nodeId, paramState);
        this.addTransition(nodeId, bodyId);
        this.addTransition(bodyId, bodyState);
        if (funDec.returnType != null) {
            String returnId = this.nextState();
            this.addNode(returnId, "ReturnType");
            String typeState = funDec.returnType.accept(this);
            this.addTransition(nodeId, returnId);
            this.addTransition(returnId, typeState);
        }
        
        return nodeId;
    }

    @Override
    public String visit(TyDec tyDec) {

        String nodeId= this.nextState();

        this.addNode(nodeId, tyDec.name);

        String idState = tyDec.id.accept(this);
        String tyState = tyDec.right.accept(this);

        this.addTransition(nodeId, idState);
        this.addTransition(nodeId, tyState);
        
        return nodeId;
    }

    @Override
    public String visit(List l) {
        String nodeId= this.nextState();

        this.addNode(nodeId,l.name);
        for (Binary element:l.list) {
            String idState1 = element.value1.accept(this);
            String typeState = element.value2.accept(this);
            String nodeIdRec = this.nextState();
            this.addNode(nodeIdRec, element.name);
            this.addTransition(nodeIdRec, idState1);
            this.addTransition(nodeIdRec, typeState);
            this.addTransition(nodeId, nodeIdRec);
        }
        return nodeId;
    }
    

    @Override
    public String visit(Let let) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "Let");

        String decId = this.nextState();
        this.addNode(decId, "List of declarations");
        this.addTransition(nodeId, decId);

        for (Ast ast:let.decs) {
            String astState = ast.accept(this);
            this.addTransition(decId, astState);
        }
        
        String bodyId = this.nextState();
        this.addNode(bodyId, "Body");
        this.addTransition(nodeId, bodyId);

        for (Ast ast:let.body) {
            String astState = ast.accept(this);
            this.addTransition(bodyId, astState);
        }

        // SymbolTable
        SymboleTable newTable = new SymboleTable();
        for (Ast ast:let.decs) {
            //System.out.println(ast.getClass().toString());
            if (ast instanceof VarDec) {
                VarDec varDec = (VarDec) ast;
                if (varDec.left instanceof VarType) {
                    VarType varType = (VarType) varDec.left;
                    SymbolTableEntry entry = new VariableEntry(varType.id.name,(Type) varType.type,0,0);
                    newTable.insert(entry);

                }
                if(varDec.left instanceof Id){
                    Id id = (Id) varDec.left;
                    SymbolTableEntry entry = new VariableEntry(id.name,(Type) varDec.right,0,0);
                    newTable.insert(entry);
                    System.out.println("je suis un id");
                }
                if (varDec.right instanceof CompExp){
                    CompExp comp = (CompExp) varDec.right;
                    System.out.print(comp.plusExpL);
                }
                

            } else if (ast instanceof FunDec) {
                FunDec funDec = (FunDec) ast;
                List params = (List) funDec.params;
                java.util.List<types.Type> listOfParameter = new ArrayList<types.Type>();
                for (Binary param:params.list) {
                    listOfParameter.add((Type) param.value2);
                }
                if (funDec.returnType != null) {
                    SymbolTableEntry entry = new FunctionEntry(funDec.id.toString(),listOfParameter , (Type) funDec.returnType, params.getSize());
                    newTable.insert(entry);
                } else {
                    Type type = new NilType();
                    SymbolTableEntry entry = new FunctionEntry(funDec.id.toString(),listOfParameter ,type , params.getSize());
                    newTable.insert(entry);
                }
            }

        }
        symboleTableList.add(newTable);

        return nodeId;
    }

    @Override
    public String visit(For for1) {

        String nodeId= this.nextState();

        this.addNode(nodeId, "For");

        String idStart = this.nextState();
        this.addNode(idStart, "Start");
        String idState = for1.id.accept(this);
        String initState = for1.init.accept(this);
        this.addTransition(nodeId, idStart);
        this.addTransition(idStart, idState);
        this.addTransition(idStart, initState);

        String endId = this.nextState();
        this.addNode(endId, "End");
        this.addTransition(nodeId, endId);
        String condState = for1.cond.accept(this);
        this.addTransition(endId, condState);

        String bodyId = this.nextState();
        this.addNode(bodyId, "Body");
        this.addTransition(nodeId, bodyId);
        String bodyState = for1.body.accept(this);
        this.addTransition(bodyId, bodyState);
        
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

