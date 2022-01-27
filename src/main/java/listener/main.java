import edu.ucsd.CSE232B.parsers.ExpressionGrammarLexer;
import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser;
import listener.ExpressionBuilder;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.w3c.dom.Document;
import DOMBuilder.DOMBuilder;

//package listener;
//
//import org.antlr.v4.runtime.CharStreams;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.ParserRuleContext;
//import org.antlr.v4.runtime.tree.ParseTreeWalker;
//
//import edu.ucsd.CSE232B.parsers.ExpressionGrammarLexer;
//import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser;
//import edu.ucsd.cse232b.antlrTutorial.expression.Prog;
//
public class main {
     public static void main(String[] args) {
         final String expression = "doc(\"j_caesar.xml\")";
         final ExpressionGrammarLexer lexer = new ExpressionGrammarLexer(CharStreams.fromString(expression));
         final CommonTokenStream tokens = new CommonTokenStream(lexer);
         final ExpressionGrammarParser parser = new ExpressionGrammarParser(tokens);
         final ParserRuleContext tree = parser.prog();
         final ParseTreeWalker walker = new ParseTreeWalker();
         final ExpressionBuilder expressionBuilder = new ExpressionBuilder();
         walker.walk(expressionBuilder, tree);

         Document document = expressionBuilder.getDocument(tree);
         DOMBuilder domBuilder = new DOMBuilder();
         domBuilder.echo(document);
         domBuilder.out.flush();
         System.out.println("h");
         domBuilder.out.close();


    }
}
