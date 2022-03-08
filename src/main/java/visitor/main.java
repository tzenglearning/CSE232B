package visitor;

import edu.ucsd.CSE232B.parsers.ExpressionGrammarLexer;
import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser;
import expression.DataContext;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class main {
    static Document document;
    public static void main(String[] args) throws Exception {
        String filename = args[0];
        String expression = Files.readString(Path.of(filename));
        String output_filename = "xquery_m3_result.txt";
        test(expression, output_filename);

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

    public static void test(String expression, String output_filename) throws Exception {
        // Output file
        File queryResultsFile = new File(output_filename);
        queryResultsFile.createNewFile();

        // Create an empty output tag/element
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.newDocument();
        Element root = document.createElement("OUTPUT");

        // Execute query
//        System.out.println(expression);
        final ExpressionGrammarLexer lexer = new ExpressionGrammarLexer(CharStreams.fromString(expression));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final ExpressionGrammarParser parser = new ExpressionGrammarParser(tokens);
        final ParserRuleContext tree = parser.prog();
        final ProgramBuilder programBuilder = new ProgramBuilder();
        final ProgramBuilder programBuilder2 = new ProgramBuilder();

        final Rewriter rewriter = new Rewriter();
        String result = rewriter.visit(tree);
        PrintWriter printWriter = new PrintWriter("xquery_rewritten.txt");
        printWriter.println(result);
        printWriter.flush();

//        System.out.println(result);


        final ExpressionGrammarLexer newlexer = new ExpressionGrammarLexer(CharStreams.fromString(result));
        final CommonTokenStream newtokens = new CommonTokenStream(newlexer);
        final ExpressionGrammarParser newparser = new ExpressionGrammarParser(newtokens);
        final ParserRuleContext tree2 = newparser.prog();
        long curr = System.currentTimeMillis();
        final DataContext dataContext = programBuilder.visit(tree2);
        long e = System.currentTimeMillis();
        System.out.printf("Rewritten: It takes %d milliseconds\n", e - curr);



//        final ExpressionGrammarLexer lexer2 = new ExpressionGrammarLexer(CharStreams.fromString(expression));
//        final CommonTokenStream tokens2 = new CommonTokenStream(lexer2);
//        final ExpressionGrammarParser parser2 = new ExpressionGrammarParser(tokens2);
//        final ParserRuleContext tree4 = parser2.prog();
//
//        long curr2 = System.currentTimeMillis();
//        final DataContext dataContext2 = programBuilder2.visit(tree4);
//        long e2 = System.currentTimeMillis();
//        System.out.printf("It takes %d milliseconds\n", e2 - curr2);
//        System.out.println(dataContext);
//
//
//        // Debugging
        List<Node> resultNodes = dataContext.data;
        System.out.println("Result: " + resultNodes.size());
//        System.out.println(resultNodes);
//
        for(Node d : resultNodes) {
            // Have to import d into the newly created output xml document
            Node d_copy = document.importNode(d, true);
            root.appendChild(d_copy);
//            System.out.println(d.getNodeName());
        }
        document.appendChild(root);
        String xml_output_str = nodeToString(document);
        xml_output_str = prettyFormat(xml_output_str);
        Files.writeString(Path.of(output_filename), xml_output_str);
    }

    /**
     * To output a Node as a String.
     */
    public static String nodeToString(Node document) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        Source xmlSource = new DOMSource(document);
        Result outputTarget = new StreamResult(outputStream);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(xmlSource, outputTarget);

        return outputStream.toString();
    }

    // XML file indent: ugly one-line XML str -> pretty indented XML str
    public static String prettyFormat(String input, int indent) {
        try {
            Source xmlInput = new StreamSource(new StringReader(input));
            StringWriter stringWriter = new StringWriter();
            StreamResult xmlOutput = new StreamResult(stringWriter);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(xmlInput, xmlOutput);
            return xmlOutput.getWriter().toString();
        } catch (Exception e) {
            throw new RuntimeException(e); // simple exception handling, please review it
        }
    }

    public static String prettyFormat(String input) {
        return prettyFormat(input, 2);
    }

//    public static void stringToDom(String xmlSource, String filename)
//            throws IOException, IOException {
//        java.io.FileWriter fw = new java.io.FileWriter(filename);
//        fw.write(xmlSource);
//        fw.close();
//    }
}
