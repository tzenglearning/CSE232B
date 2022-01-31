import edu.ucsd.CSE232B.parsers.ExpressionGrammarLexer;
import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser;
import listener.ExpressionBuilder;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.w3c.dom.Document;
import DOMBuilder.DOMBuilder;
import org.w3c.dom.Node;

import java.util.List;

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
         String expression = null;
         //expression = "doc(\"j_caesar.xml\")//PERSONA";
         //test(expression);
//         expression = "doc(\"j_caesar.xml\")//SCENE[SPEECH/SPEAKER/text() = \"CAESAR\"]/TITLE";
 //        test(expression);
//         expression = "doc(\"j_caesar.xml\")//ACT[SCENE[SPEECH/SPEAKER/text()=\"CAESAR\" and SPEECH/SPEAKER/text() = \"BRUTUS\"]]";
//         test(expression);
         //expression = "doc(\"j_caesar.xml\")//ACT[SCENE[SPEECH/SPEAKER/text() = \"CAESAR\"] [SPEECH/SPEAKER/text() = \"BRUTUS\"]]";
         //test(expression);
//         expression = "doc(\"j_caesar.xml\")//ACT[not  .//SPEAKER/text() = \"CAESAR\"]";
//         test(expression);

//       expression = "doc(\"j_caesar.xml\")//(ACT,PERSONAE)/TITLE/text()/../../TITLE[not((./ACT)and(./ACT))]/.././PERSONA/./..";
//       test(expression);
//       expression = "doc(\"j_caesar.xml\")/PLAY/ACT[not(SCENE=ACT)]/TITLE/.";
//       test(expression);
//       expression = "doc(\"j_caesar.xml\")/PLAY/(ACT,PERSONAE)/PGROUP[not(PERSONA)or(GRPDESCR)]/../.";
//       test(expression);
//       expression = "doc(\"j_caesar.xml\")//(ACT/SCENE/SPEECH)/(SPEAKER)/../.[not (./../TITLE==./LINE) and (./../*/SPEAKER==./SPEAKER)]/../TITLE";
//       test(expression);
//       expression = "doc(\"j_caesar.xml\")//ACT[./TITLE]/*/SPEECH/../*/.././TITLE";
//       test(expression);


    }

    public static void test(String expression){
        ExpressionGrammarLexer lexer = new ExpressionGrammarLexer(CharStreams.fromString(expression));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpressionGrammarParser parser = new ExpressionGrammarParser(tokens);
        ParserRuleContext tree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        ExpressionBuilder expressionBuilder = new ExpressionBuilder();
        walker.walk(expressionBuilder, tree);

        List<Node> document = expressionBuilder.getDocument(tree);
        System.out.println(document.size());
        for(Node d : document) {
//             DOMBuilder domBuilder = new DOMBuilder();
//             domBuilder.echo(d);
//             domBuilder.out.flush();
//             System.out.println("h");
//             domBuilder.out.close();
            System.out.println(d.getNodeName() + " " + d.getTextContent());
        }

    }
}
