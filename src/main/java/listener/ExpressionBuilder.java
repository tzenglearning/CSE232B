package listener;

import java.util.*;

import DOMBuilder.DOMBuilder;
import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;


import edu.ucsd.CSE232B.parsers.ExpressionGrammarBaseListener;
import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser.ExpContext;
//import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser.Expr_BinaryContext;
//import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser.Expr_NumberContext;
//import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser.Expr_ParenthesesContext;
//import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser.Expr_VariableContext;
//import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser.NumberContext;
//import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser.ProgContext;
//import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser.VariableContext;
//import expression.BinaryExpression;
//import expression.Expression;
//import expression.NumberConstant;
//import expression.Operator;
//import expression.ParaExpression;
//import edu.ucsd.CSE232B.antlrTutorial.expression.Prog;
//import edu.ucsd.CSE232B.antlrTutorial.expression.Variable;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.w3c.dom.*;

public class ExpressionBuilder extends ExpressionGrammarBaseListener {
    private ParseTreeProperty<Object> expressionObjects;

    /**
     * Constructor
     */
    public ExpressionBuilder() {
        expressionObjects = new ParseTreeProperty<Object>();
    }

    /**
     * Set object (parser tree property)
     *
     * @param subtree subtree
     * @param obj  corresponding object
     */
    private void setObject(ParseTree subtree, Object obj) {
        expressionObjects.put(subtree, obj);
    }

    /**
     * Retrieve object from parser tree property
     *
     * @param obj
     * @return expression object
     */
    private Object retrieveObject(ParseTree obj) {
        return expressionObjects.get(obj);
    }

    public List<Node> getDocument(ParseTree tree){
        return (List<Node>) retrieveObject(tree);
    }

    @Override
    public void enterProg(ExpressionGrammarParser.ProgContext ctx) {
    }

    @Override
    public void exitProg(ExpressionGrammarParser.ProgContext ctx) {
        List<Node> document = (List<Node>) retrieveObject(ctx.exp(0));
        System.out.println("exit prog");
        System.out.println(document);
        setObject(ctx, document);
    }

    @Override
    public void enterExp(ExpContext ctx) {

    }

    @Override
    public void exitExp(ExpContext ctx) {
        List<Node> documents = (List<Node>) retrieveObject(ctx);
        setObject(ctx, documents);
    }

    @Override
    public void enterRp_TagName(ExpressionGrammarParser.Rp_TagNameContext ctx) {
        List<Node> nl = (List<Node>) retrieveObject(ctx.getParent());
        setObject(ctx, nl);
    }

    @Override
    public void exitRp_TagName(ExpressionGrammarParser.Rp_TagNameContext ctx) {
        List<Node> documents = (List<Node>) retrieveObject(ctx);
        //ExpressionGrammarParser.RpContext rp = rpContext.get(0);
        List<Node> res = new ArrayList<>();
        for(Node document : documents) {
            if (ctx.tagName() != null) {
                String tagName = (String) retrieveObject(ctx.tagName());
                //find a list of Document nodes with this tagName
                getNodeByTagName(document, tagName, res);
                setObject(ctx, res);
                if(! (ctx.getParent() instanceof ExpressionGrammarParser.Rp_CommaContext)){
                    setObject(ctx.getParent(), res);
                }
            } else {

            }
        }
        System.out.println("Exiting rp tagname");
        System.out.println(documents);
        System.out.println(res);
    }

    @Override
    public void enterRp_Pathsymbol(ExpressionGrammarParser.Rp_PathsymbolContext ctx) {
        List<Node> document = (List<Node>) retrieveObject((ctx.getParent()));
        System.out.println("Enter rp_path Symbol");
        System.out.println(document);
        setObject(ctx, document);
    }

    @Override
    public void exitRp_Pathsymbol(ExpressionGrammarParser.Rp_PathsymbolContext ctx) {
        List<Node> document = (List<Node>) retrieveObject(ctx);
        String pathSymbol = ctx.PATH_SYMBOL().toString();
        System.out.println("Exit path symbol");
        System.out.println(document);
        List<Node> result = new ArrayList<>();
        if(pathSymbol.equals("*")){
            for(Node d: document){
                for (Node child = d.getFirstChild(); child != null;
                     child = child.getNextSibling()) {
                     result.add(child);
                }
            }
            System.out.println(result);
            setObject(ctx, result);
        }else if(pathSymbol.equals(".")){
            System.out.println(document);
            setObject(ctx, document);
        }else{//..

            for(Node d : document){
                if(!result.contains(d.getParentNode())) {
                    result.add(d.getParentNode());
                }
            }
            System.out.println(result);
            setObject(ctx, result);
        }
    }

    @Override
    public void enterRp_Paren(ExpressionGrammarParser.Rp_ParenContext ctx) {
        List<Node> node = (List<Node>) retrieveObject(ctx.getParent());
        setObject(ctx, node);
    }

    @Override
    public void exitRp_Paren(ExpressionGrammarParser.Rp_ParenContext ctx) {
        List<Node> document = (List<Node>) retrieveObject(ctx.rp());
        System.out.println("Exiting rp_paren");
        System.out.println(document);
        setObject(ctx, document);
        //required by test case personae
        setObject(ctx.getParent(), document);
    }
    @Override
    public void enterFilter_Or(ExpressionGrammarParser.Filter_OrContext ctx) {
        List<Node> document = (List<Node>) retrieveObject(ctx.getParent());
        setObject(ctx, document);
    }

    @Override
    public void exitFilter_Or(ExpressionGrammarParser.Filter_OrContext ctx) {
        List<Node> filter1 = (List<Node>) retrieveObject(ctx.filter(0));
        List<Node> filter2 = (List<Node>) retrieveObject(ctx.filter(1));
        Set<Node> set2 = new HashSet<>((filter2));
        for(Node n : filter1){
            set2.add(n);
        }
        System.out.println("exiting filter or");
        System.out.println(filter1);
        System.out.println(filter2);
        System.out.println(set2);
        setObject(ctx, new ArrayList<>(set2));
    }

    @Override public void enterRp_Comma(ExpressionGrammarParser.Rp_CommaContext ctx) {
        List<Node> document = (List<Node>) retrieveObject(ctx.getParent());
        setObject(ctx, document);
    }
    @Override public void exitRp_Comma(ExpressionGrammarParser.Rp_CommaContext ctx) {
        List<Node> rp0 = (List<Node>) retrieveObject(ctx.rp(0));
        List<Node> rp1 = (List<Node>) retrieveObject(ctx.rp(1));
        System.out.println("Exit rp_comma");
        System.out.println(rp0);
        System.out.println(rp1);
        rp0.addAll(rp1);
        System.out.println(rp0);
        setObject(ctx, rp0);
    }

    @Override
    public void enterFilter_Paren(ExpressionGrammarParser.Filter_ParenContext ctx) {
        List<Node> document = (List<Node>) retrieveObject(ctx.getParent());
        setObject(ctx, document);
    }

    @Override
    public void exitFilter_Paren(ExpressionGrammarParser.Filter_ParenContext ctx) {
        //get filtered [subelements]
        List<Node> subElements = (List<Node>) retrieveObject(ctx.filter());

        setObject(ctx, subElements);
    }

    @Override
    public void enterFilter_Not(ExpressionGrammarParser.Filter_NotContext ctx) {
        List<Node> document = (List<Node>) retrieveObject(ctx.getParent());
        setObject(ctx, document);
    }

    @Override
    public void exitFilter_Not(ExpressionGrammarParser.Filter_NotContext ctx) {
        //parent could be filter_and or rp_filter or filter or
        List<Node> documents = (List<Node>) retrieveObject(ctx.getParent());

        //get filtered [subelements]
        List<Node> subElements = (List<Node>) retrieveObject(ctx.filter());
        Set<Node> set = new HashSet<>(subElements);

        //good
        List<Node> good = new ArrayList<>();

        System.out.println("Exiting filter not");
        System.out.println(documents);
        System.out.println(subElements);

        for(Node document : documents){
            if(!subElements.contains(document)){
                good.add(document);
            }
        }

        System.out.println(good);
        setObject(ctx, good);

    }
    @Override
    public void enterFilter_And(ExpressionGrammarParser.Filter_AndContext ctx) {
        List<Node>  document = (List<Node>) retrieveObject(ctx.getParent());
        setObject(ctx, document);
    }

    @Override
    public void exitFilter_And(ExpressionGrammarParser.Filter_AndContext ctx) {
        List<Node> filter1 = (List<Node>) retrieveObject(ctx.filter(0));
        List<Node> filter2 = (List<Node>) retrieveObject(ctx.filter(1));
        Set<Node> set2 = new HashSet<>((filter2));
        List<Node> result = new ArrayList<>();
        for(Node n : filter1){
            if(set2.contains(n)){
                result.add(n);
            }
        }
        System.out.println("exiting filter and");
        System.out.println(result);
        setObject(ctx, result);

    }
    @Override
    public void enterRp_Filter(ExpressionGrammarParser.Rp_FilterContext ctx) {
        List<Node> document = (List<Node>) retrieveObject(ctx.getParent());
        setObject(ctx, document);
    }

    @Override public void exitRp_Filter(ExpressionGrammarParser.Rp_FilterContext ctx) {
        List<Node> nl = (List<Node>) retrieveObject(ctx.filter());
        System.out.println("exiting rp_filter");
        System.out.println(nl);
        setObject(ctx.getParent(), nl);
    }

    @Override public void enterFilter_Eq(ExpressionGrammarParser.Filter_EqContext ctx) {
        List<Node> nl = (List<Node>) retrieveObject(ctx.getParent());
        setObject(ctx, nl);

    }
    @Override
    public void exitFilter_Eq(ExpressionGrammarParser.Filter_EqContext ctx) {
        //parent could be filter_and or rp_filter or filter or
        List<Node> document = (List<Node>) retrieveObject(ctx.getParent());
        System.out.println("exiting filter eq");
        System.out.println(document.size());
        List<ExpressionGrammarParser.RpContext> rpContextList = ctx.rp();
        if(rpContextList.size() == 1){//rp0 = string
            //get filtered [subelements]
            //rp0
            List<Node> nodes = (List<Node>) retrieveObject(rpContextList.get(0));
            //string
            String text = ctx.STRING().toString().trim();
            text = text.replaceAll("\"", "");
            //rp0 = string
            List<Node> okElements = new ArrayList<Node>();
            for(Node n : nodes){
                if(n.getNodeValue().equals(text)){
                    okElements.add(n);
                }
            }

            //good
            List<Node> good = new ArrayList<>();



            for(Node d : document){
                for(Node n: okElements){
                    if(isParent(d, n)){
                        good.add(d);
                        break;
                    }
                }
            }

            setObject(ctx, good);
            System.out.println(good.size());
            System.out.println(good);

        }else{//rp0 = rp1
            List<Node> rp0 = (List<Node>) retrieveObject(ctx.rp(0));
            List<Node> rp1 = (List<Node>) retrieveObject(ctx.rp(1));

            //if for every element rp0 = rp1 return rp0
            Set<Node> set1 = new HashSet<>(rp1);


            for(Node n0 : rp0){
                for(Node n1 : set1) {
                    if (n1.isEqualNode(n0)){
                        set1.remove(n1);
                        break;
                    }
                }
            }

            if(rp0.size() == rp1.size() && set1.size() == 0){
                setObject(ctx, rp0);
            }else{
                setObject(ctx, new ArrayList<Node>());
            }

        }


    }
    @Override
    public void enterFilter_Rp(ExpressionGrammarParser.Filter_RpContext ctx) {
        List<Node> nl = (List<Node>) retrieveObject(ctx.getParent());
        setObject(ctx, nl);
    }

    @Override
    public void exitFilter_Rp(ExpressionGrammarParser.Filter_RpContext ctx) {
        //parent could be filter_and or rp_filter or filter or
        List<Node> document = (List<Node>) retrieveObject(ctx.getParent());
        System.out.println("Exiting Fiter rp");
        System.out.println(document);
        System.out.println(document.size());

        //get filtered [subelements]
        List<Node> subElements = (List<Node>) retrieveObject(ctx.rp());
        System.out.println(subElements);

        //good
        List<Node> good = new ArrayList<>();

        for(Node d : document){
            for(Node n: subElements){
                if(isParent(d, n)){
                    good.add(d);
                    break;
                }
            }
        }

        setObject(ctx, good);

        System.out.println(good.size());
        System.out.println(good);
    }
    @Override
    public void enterFilter_SpecEq(ExpressionGrammarParser.Filter_SpecEqContext ctx) {
        List<Node> document = (List<Node>) retrieveObject(ctx.getParent());
        setObject(ctx, document);
    }

    @Override
    public void exitFilter_SpecEq(ExpressionGrammarParser.Filter_SpecEqContext ctx) {
        List<Node> document = (List<Node>) retrieveObject(ctx.getParent());
        System.out.println("exiting filter ==");
        System.out.println(document.size());
        List<ExpressionGrammarParser.RpContext> rpContextList = ctx.rp();
        List<Node> rp0 = (List<Node>) retrieveObject(ctx.rp(0));
        List<Node> rp1 = (List<Node>) retrieveObject(ctx.rp(1));

        //if for every element rp0 = rp1 return rp0
        boolean everyElement1 = false;
        Set<Node> set0 = new HashSet<>(rp0);
        Set<Node> set1 = new HashSet<>(rp1);
        for(Node n0 : rp0){
            if(set1.contains(n0)){
                set0.remove(n0);
                set1.remove(n0);
            }
        }

        if(set0.size() == 0 && set1.size() == 0){
            setObject(ctx, rp0);
        }else{
            setObject(ctx, new ArrayList<Node>());
        }

    }

    @Override
    public void enterRp_Slash(ExpressionGrammarParser.Rp_SlashContext ctx) {
        List<Node> nl = (List<Node>) retrieveObject(ctx.getParent());
        System.out.println("enter Rp_Slash");
        setObject(ctx, nl);

    }

    @Override
    public void exitRp_Slash(ExpressionGrammarParser.Rp_SlashContext ctx) {
        List<ExpressionGrammarParser.RpContext> rpContextList = ctx.rp();
        ExpressionGrammarParser.RpContext rp0 = rpContextList.get(0);
        ExpressionGrammarParser.RpContext rp1 = rpContextList.get(1);
        System.out.println("Exiting rp_slash");
        List<Node> node0 = (List<Node>) retrieveObject(rp0);;
        List<Node> node1 = (List<Node>) retrieveObject(rp1);
        Set<Node> set = new HashSet<>();

        set.addAll(node0);
        set.addAll(node1);

        /*
           case1 ./NOT EXIST
            [A] + [] => set(A)
            [] from set(A) = []

            case2 ./PARENT
            [A] + [parent Nodes] = set(A, PARENT)
            [PARENT] from set(A, PARENT) = [PARENT]
        */
        List<Node> result = new ArrayList<>();
        for(Node n : node1){
            if(set.contains(n)){
                result.add(n);
            }
        }

        boolean r1Parent = ctx.rp(1) instanceof ExpressionGrammarParser.Rp_PathsymbolContext && ((ExpressionGrammarParser.Rp_PathsymbolContext) ctx.rp(1)).PATH_SYMBOL().toString().equals("..");
        if(ctx.SLASH().toString().equals("/") && !r1Parent){
            //check if r1 is direct children of any leftNodes
            for(Node n1 : node1){
                boolean isNotDirectChildren = true;
                for(Node n0 : node0){
                    if(isDirectChildren(n1, n0)){
                        isNotDirectChildren = false;
                        break;
                    }
                }
                if(isNotDirectChildren){
                    result.remove(n1);
                }
            }

        }

        System.out.println(node0);
        System.out.println(node1);
        System.out.println(result);
        setObject(ctx, result);
        setObject(ctx.getParent(), result);

    }

    @Override
    public void enterRp_Text(ExpressionGrammarParser.Rp_TextContext ctx) {
       List<Node> document = (List<Node>) retrieveObject(ctx.getParent());
       setObject(ctx, document);

    }

    @Override
    public void exitRp_Text(ExpressionGrammarParser.Rp_TextContext ctx) {
        List<Node> nl = (List<Node>) retrieveObject(ctx);
        System.out.println("exit rp text");

        List<Node> node = new ArrayList<>();
        for(Node n : nl){
            Node str = n.getFirstChild();
            //System.out.println(str);
            node.add(str);
        }
        setObject(ctx.getParent(), node);
        setObject(ctx, node);
        System.out.println(node);
    }



    public void enterTagName(ExpressionGrammarParser.TagNameContext ctx) {
    }

    @Override
    public void exitTagName(ExpressionGrammarParser.TagNameContext ctx) {
        setObject(ctx, ctx.NAME().toString());
    }

    public void enterAttName(ExpressionGrammarParser.AttNameContext ctx) {
    }

    public void exitAttName(ExpressionGrammarParser.AttNameContext ctx) {
    }

    public void enterFilter(ExpressionGrammarParser.FilterContext ctx) {
    }

    public void exitFilter(ExpressionGrammarParser.FilterContext ctx) {
    }

    public void enterDocName(ExpressionGrammarParser.DocNameContext ctx) {

    }

    @Override
    public void exitDocName(ExpressionGrammarParser.DocNameContext ctx) {
        final ExpressionGrammarParser.FileNameContext filectx = ctx.fileName();
        String fileName = (String) retrieveObject(ctx.fileName());
        DOMBuilder dombUilder = new DOMBuilder();
        Document document = dombUilder.getDocument(fileName);
        //Document -> List
        List<Node> l = new ArrayList<>();
        l.add(document);
        setObject(ctx.getParent(), l);

    }

    public void enterFileName(ExpressionGrammarParser.FileNameContext ctx) {
    }

    @Override
    public void exitFileName(ExpressionGrammarParser.FileNameContext ctx) {
        setObject(ctx, ctx.STRING().toString());
    }

    public void enterStringConst(ExpressionGrammarParser.StringConstContext ctx) {
    }

    public void exitStringConst(ExpressionGrammarParser.StringConstContext ctx) {
    }

    public void enterEveryRule(ParserRuleContext ctx) {
    }

    public void exitEveryRule(ParserRuleContext ctx) {
    }

    public void visitTerminal(TerminalNode node) {
    }

    public void visitErrorNode(ErrorNode node) {
    }

    private void printlnCommon(Node n) {
        System.out.print(" nodeName=\"" + n.getNodeName() + "\"");

        String val = n.getNamespaceURI();
        if (val != null) {
            System.out.print(" uri=\"" + val + "\"");
        }

        val = n.getPrefix();

        if (val != null) {
            System.out.print(" pre=\"" + val + "\"");
        }

        val = n.getLocalName();
        if (val != null) {
            System.out.print(" local=\"" + val + "\"");
        }

        val = n.getNodeValue();
        if (val != null) {
            System.out.print(" nodeValue=");
            if (val.trim().equals("")) {
                // Whitespace
                System.out.print("[WS]");
            }
            else {
               System.out.print("\"" + n.getNodeValue() + "\"");
            }
        }
        System.out.println();
    }

    public boolean isParent(Node n1, Node n2) {
        //n1 is parent of n2
        if(n1 == null){
            return false;
        }

        if(n1.isSameNode(n2)){
            return true;
        }

        for (Node child = n1.getFirstChild(); child != null;
             child = child.getNextSibling()) {
            if(isParent(child, n2))return true;
        }
        return false;
    }
    public void getNodeByTagName(Node n, String tagName, List<Node> res) {
        String name = n.getNodeName();

        if(name.equals(tagName)){
            res.add(n);
        }

        for (Node child = n.getFirstChild(); child != null;
             child = child.getNextSibling()) {
             getNodeByTagName(child, tagName, res);
        }
    }

    private boolean isDirectChildren(Node n0, Node n1){
        if(n0.isSameNode(n1)) return true;
        for (Node child = n1.getFirstChild(); child != null;
             child = child.getNextSibling()) {
            if(n0.isSameNode(child)) return true;
        }
        return false;
    }

    private boolean isChildren(Node n0, Node n1){
        //n1 is children of n0
        if(n0 == null){
            return false;
        }
        if(n0.isSameNode(n1)){
            return true;
        }
        for (Node child = n1.getFirstChild(); child != null;
             child = child.getNextSibling()) {
            if(isChildren(n0, child)) return true;
        }
        return false;
    }
//    @Override
//    public void exitProg(ProgContext ctx){
//        final List<Expression> expressionList = new ArrayList<>();
//        for (ExpContext expressionContext: ctx.exp()){
//            final Expression expression = (Expression) retrieveObject(expressionContext);
//            expressionList.add(expression);
//        }
//        final Prog program = new Prog(expressionList);
//        setObject(ctx,program);
//    }
//    @Override
//    public void exitExpr_Parentheses(Expr_ParenthesesContext ctx){
//        final Expression expression = (Expression) retrieveObject(ctx.exp());
//        final ParaExpression paraExpression = new ParaExpression(expression);
//        setObject(ctx,paraExpression);
//    }
//    @Override
//    public void exitExpr_Binary (Expr_BinaryContext ctx){
//        //Left Expression
//        final Expression expressionLeft = (Expression) retrieveObject(ctx.exp(0));
//        //Operator
//        final Operator operator = Operator.fromString(ctx.OP().getText());
//       //Right Expression
//        final Expression expressionRight = (Expression) retrieveObject(ctx.exp(1));
//
//        final BinaryExpression binaryExpression = new BinaryExpression(expressionLeft,operator,expressionRight);
//        setObject(ctx,binaryExpression);
//    }
//
//
//    @Override
//    public void exitExpr_Number (Expr_NumberContext ctx){
//        final NumberConstant value = (NumberConstant) retrieveObject(ctx.number());
//        setObject(ctx,value);
//    }
//
//    @Override
//    public void exitNumber(NumberContext ctx) {
//        final Integer value = Integer.valueOf(ctx.NUM().getText());
//        final NumberConstant numberConstant = new NumberConstant(value);
//        setObject(ctx,numberConstant);
//    }
//
//    @Override
//    public void exitExpr_Variable (Expr_VariableContext ctx){
//        final Variable variable = (Variable) retrieveObject(ctx.variable());
//        setObject(ctx,variable);
//    }
//    @Override
//    public void exitVariable(VariableContext ctx) {
//       final String name = ctx.ID().getText();
//       final Variable variable  = new Variable(name);
//       setObject(ctx,variable);
//    }
}
