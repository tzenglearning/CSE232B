package DOMBuilder;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;


public class DOMBuilder {
    static final String outputEncoding = "UTF-8";

    private PrintWriter out;
    private int indent = 0;
    private final String basicIndent = " ";

    public DOMBuilder(PrintWriter out) {
        this.out = out;
    }

    private static void usage() {
        // ...
    }

    public static void main(String[] args) throws Exception {

        String filename = null;
        boolean dtdValidate = false;
        boolean xsdValidate = false;
        String schemaSource = null;

//        for (int i = 0; i < args.length; i++) {
//            if (args[i].equals("-dtd"))  {
//                dtdValidate = true;
//            }
//            else if (args[i].equals("-xsd")) {
//                xsdValidate = true;
//            }
//            else if (args[i].equals("-xsdss")) {
//                if (i == args.length - 1) {
//                    usage();
//                }
//                xsdValidate = true;
//                schemaSource = args[++i];
//            }
//            else {
//                filename = args[i];
//                if (i != args.length - 1) {
//                    usage();
//                }
//            }
//        }
//
//        if (filename == null) {
//            usage();
//        }

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        dbf.setNamespaceAware(true);
        dbf.setValidating(dtdValidate || xsdValidate);

        // ...

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File("src/main/resources/j_caesar.xml"));
        DOMBuilder builder = new DOMBuilder(new PrintWriter(System.out));
        builder.echo(doc);
        builder.out.flush();
        builder.out.close();

    }

    private void printlnCommon(Node n) {
        out.print(" nodeName=\"" + n.getNodeName() + "\"");

        String val = n.getNamespaceURI();
        if (val != null) {
            out.print(" uri=\"" + val + "\"");
        }

        val = n.getPrefix();

        if (val != null) {
            out.print(" pre=\"" + val + "\"");
        }

        val = n.getLocalName();
        if (val != null) {
            out.print(" local=\"" + val + "\"");
        }

        val = n.getNodeValue();
        if (val != null) {
            out.print(" nodeValue=");
            if (val.trim().equals("")) {
                // Whitespace
                out.print("[WS]");
            }
            else {
                out.print("\"" + n.getNodeValue() + "\"");
            }
        }
        out.println();
    }
    private void outputIndentation() {
        for (int i = 0; i < indent; i++) {
            out.print(basicIndent);
        }
    }

    private void echo(Node n) {
        outputIndentation();
        int type = n.getNodeType();

        switch (type) {
            case Node.ATTRIBUTE_NODE:
                out.print("ATTR:");
                printlnCommon(n);
                break;

            case Node.CDATA_SECTION_NODE:
                out.print("CDATA:");
                printlnCommon(n);
                break;

            case Node.COMMENT_NODE:
                out.print("COMM:");
                printlnCommon(n);
                break;

            case Node.DOCUMENT_FRAGMENT_NODE:
                out.print("DOC_FRAG:");
                printlnCommon(n);
                break;

            case Node.DOCUMENT_NODE:
                out.print("DOC:");
                printlnCommon(n);
                break;

            case Node.DOCUMENT_TYPE_NODE:
                out.print("DOC_TYPE:");
                printlnCommon(n);
                NamedNodeMap nodeMap = ((DocumentType)n).getEntities();
                indent += 2;
                for (int i = 0; i < nodeMap.getLength(); i++) {
                    Entity entity = (Entity)nodeMap.item(i);
                    echo(entity);
                }
                indent -= 2;
                break;

            case Node.ELEMENT_NODE:
                out.print("ELEM:");
                printlnCommon(n);

                NamedNodeMap atts = n.getAttributes();
                indent += 2;
                for (int i = 0; i < atts.getLength(); i++) {
                    Node att = atts.item(i);
                    echo(att);
                }
                indent -= 2;
                break;

            case Node.ENTITY_NODE:
                out.print("ENT:");
                printlnCommon(n);
                break;

            case Node.ENTITY_REFERENCE_NODE:
                out.print("ENT_REF:");
                printlnCommon(n);
                break;

            case Node.NOTATION_NODE:
                out.print("NOTATION:");
                printlnCommon(n);
                break;

            case Node.PROCESSING_INSTRUCTION_NODE:
                out.print("PROC_INST:");
                printlnCommon(n);
                break;

            case Node.TEXT_NODE:
                out.print("TEXT:");
                printlnCommon(n);
                break;

            default:
                out.print("UNSUPPORTED NODE: " + type);
                printlnCommon(n);
                break;
        }

        indent++;
        for (Node child = n.getFirstChild(); child != null;
             child = child.getNextSibling()) {
            echo(child);
        }
        indent--;
    }
}
