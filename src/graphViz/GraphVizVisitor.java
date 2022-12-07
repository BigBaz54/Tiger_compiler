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
        return null;
    }

    @Override
    public String visit(LValueDot lValueDot) {
        return null;
    }

    @Override
    public String visit(LValueBrack lValueBrack) {
        return null;
    }

    @Override
    public String visit(Exp exp) {
        return null;
    }

    @Override
    public String visit(OrExp orExp) {
        return null;
    }

    @Override
    public String visit(AndExp andExp) {
        return null;
    }

    @Override
    public String visit(CompExp compExp) {
        return null;
    }

    @Override
    public String visit(PlusExp plusExp) {
        return null;
    }

    @Override
    public String visit(TimesExp timesExp) {
        return null;
    }

    @Override
    public String visit(StringLit str) {
        return null;
    }

    @Override
    public String visit(Print print) {
        return null;
    }

    @Override
    public String visit(Flush flush) {
        return null;
    }

    @Override
    public String visit(GetChar getChar) {
        return null;
    }

    @Override
    public String visit(Ord ord) {
        return null;
    }

    @Override
    public String visit(Chr chr) {
        return null;
    }

    @Override
    public String visit(Size size) {
        return null;
    }

    @Override
    public String visit(Substring substring) {
        return null;
    }

    @Override
    public String visit(Concat concat) {
        return null;
    }

    @Override
    public String visit(Not not) {
        return null;
    }

    @Override
    public String visit(Exit exit) {
        return null;
    }
}
