
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.IOException;

import SymboleTable.CreateTree;
import SymboleTable.SymboleTableCreator;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

import parser.*;
import parser.TigerLexer;
import parser.TigerParser.*;
import parser.TigerParser.ProgramContext;

import ast.*;
import graphViz.GraphVizVisitor;


public class Main {

    public static void main(String[] args){

        if (args.length < 1){
            System.out.println("Error : Expected 1 argument filepath, found 0");
            return;
        }

        String testFile = args[0];

        try {

            //chargement du fichier et construction du parser
            CharStream input = CharStreams.fromFileName(testFile);
            TigerLexer lexer = new TigerLexer(input); 
            CommonTokenStream stream = new CommonTokenStream(lexer);
            TigerParser parser = new TigerParser(stream);

            ProgramContext program = parser.program();

            // code d'affichage de l'arbre syntaxique
            // JFrame frame = new JFrame("Antlr AST");
            // JPanel panel = new JPanel();
            // TreeViewer viewer = new TreeViewer(Arrays.asList(
            //         parser.getRuleNames()),program);
            // viewer.setScale(.7); // Scale a little
            // panel.add(viewer);
            // frame.add(panel);
            // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // frame.pack();
            // frame.setVisible(true);

            // Visiteur de création de l'AST + création de l'AST
            AstCreator creator = new AstCreator();
            Ast ast = program.accept(creator);

            // Visiteur de représentation graphique + appel
            GraphVizVisitor graphViz = new GraphVizVisitor();
            ast.accept(graphViz);
        
            graphViz.dumpGraph("./out/tree.dot");
            CreateTree tree = new CreateTree();
            tree.readFile();
            SymboleTableCreator symboleTableCreator = new SymboleTableCreator(tree.getTree(), tree.getNameEquivalence());
            symboleTableCreator.createTable("N0");
            symboleTableCreator.getSymboleTableList().print();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (RecognitionException e) {
            e.printStackTrace();
        }
        

    }
    
}