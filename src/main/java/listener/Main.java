package listener;

import edu.ucsd.CSE232B.parsers.ExpressionGrammarLexer;
import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser;
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

public class Main {
     public static void main(String[] args) throws Exception {
         String filename = "Input_Query.txt";
         String expression = Files.readString(Path.of(filename));
         String output_filename = "Query_Results.xml";
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
        if(queryResultsFile.createNewFile()){
            System.out.println("File " + queryResultsFile + " created in Project root directory");
        }else System.out.println("File " + queryResultsFile + " already exists in the project root directory");

        // Create an empty output tag/element
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("OUTPUT");

        // Execute query
        ExpressionGrammarLexer lexer = new ExpressionGrammarLexer(CharStreams.fromString(expression));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpressionGrammarParser parser = new ExpressionGrammarParser(tokens);
        ParserRuleContext tree = parser.prog();
        ParseTreeWalker walker = new ParseTreeWalker();
        ExpressionBuilder expressionBuilder = new ExpressionBuilder();
        walker.walk(expressionBuilder, tree);

        // Debugging
        List<Node> resultNodes = expressionBuilder.getDocument(tree);
        System.out.println("Result: " + resultNodes.size());
        System.out.println(resultNodes);

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
