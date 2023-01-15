import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

import parser.*;
import parser.TigerLexer;
import parser.TigerParser.ProgramContext;

import ast.*;
import graphViz.GraphVizVisitor;
import SymboleTable.SymboleTableVisitor;

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

            // Visiteur de création de la table des symboles + appel
            System.out.println("\n");
            SymboleTableVisitor symboleTableVisitor = new SymboleTableVisitor();
            ast.accept(symboleTableVisitor);
            symboleTableVisitor.print();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (RecognitionException e) {
            e.printStackTrace();
        }
        

    }
    
}