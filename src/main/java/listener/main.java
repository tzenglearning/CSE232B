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

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
     public static void main(String[] args) throws Exception {
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

//           expression = "doc(\"j_caesar.xml\")//(ACT,PERSONAE)/TITLE/text()/../../TITLE[not((./ACT)and(./ACT))]/.././PERSONA/./..";
//           test(expression);
//       expression = "doc(\"j_caesar.xml\")/PLAY/ACT[not(SCENE=ACT)]/TITLE/.";
//       test(expression);
//       expression = "doc(\"j_caesar.xml\")/PLAY/(ACT,PERSONAE)/PGROUP[not(PERSONA)or(GRPDESCR)]/../.";
//       test(expression);
//       expression = "doc(\"j_caesar.xml\")//(ACT/SCENE/SPEECH)/(SPEAKER)/../.[not (./../TITLE==./LINE) and (./../*/SPEAKER==./SPEAKER)]/../TITLE";
//       test(expression);
//       expression = "doc(\"j_caesar.xml\")//ACT[./TITLE]/*/SPEECH/../*/.././TITLE";
//       test(expression);
//         expression = "doc(\"j_caesar.xml\")//PERSONAE/PGROUP/PERSONA";
//         test(expression); //27
//         expression = "doc(\"j_caesar.xml\")//SPEECH/SPEAKER[./text()]/../*/.././../../../TITLE";
//         test(expression); //1
//         expression = "doc(\"j_caesar.xml\")//(./ACT/SCENE, PERSONAE)";
//         test(expression); //19
//         expression = "doc(\"j_caesar.xml\")//ACT[not((./TITLE)==(./TITLE) or (./SCENE/TITLE==./SCENE/TITLE))]/*/SPEECH/../TITLE";
//         test(expression); //0
//         expression = "doc(\"j_caesar.xml\")//(ACT/SCENE/SPEECH)/(SPEAKER)/../.[not (./../TITLE==./LINE) and (./../*/SPEAKER==./SPEAKER) ]/../TITLE";
//         test(expression); //18




    }

    public static void test(String expression) throws Exception {
        ExpressionGrammarLexer lexer = new ExpressionGrammarLexer(CharStreams.fromString(expression));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpressionGrammarParser parser = new ExpressionGrammarParser(tokens);
        ParserRuleContext tree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        ExpressionBuilder expressionBuilder = new ExpressionBuilder();
        walker.walk(expressionBuilder, tree);

        List<Node> document = expressionBuilder.getDocument(tree);
        System.out.println("Result: " + String.valueOf(document.size()));
        System.out.println(document);
//        int i = 1;
        for(Node d : document) {
            //String xmlSource = nodeToString(d);
//            String filename = "./XML_files/queryResult-" + i + ".xml";
//            stringToDom(xmlSource, filename);
//             DOMBuilder domBuilder = new DOMBuilder();
//             domBuilder.echo(d);
//             domBuilder.out.flush();
//             System.out.println("h");
//             domBuilder.out.close();
            //System.out.println(d.getNodeName());
//            i++;
        }
    }

    /**
     * To output a Node as a String.
     */
    public static String nodeToString(Node document) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        Source xmlSource = new DOMSource(document);
        Result outputTarget = new StreamResult(outputStream);
        Transformer transformer = TransformerFactory.newInstance()
                .newTransformer();
        transformer.transform(xmlSource, outputTarget);

        return outputStream.toString();
    }

    public static void stringToDom(String xmlSource, String filename)
            throws IOException, IOException {
        java.io.FileWriter fw = new java.io.FileWriter(filename);
        fw.write(xmlSource);
        fw.close();
    }
}
