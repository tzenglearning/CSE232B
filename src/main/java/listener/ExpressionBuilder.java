package listener;

import java.util.ArrayList;
import java.util.List;

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
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
        System.out.println(document);
        setObject(ctx, document);
    }

    @Override
    public void enterExp(ExpContext ctx) {

    }

    @Override
    public void exitExp(ExpContext ctx) {
        NodeList document = (NodeList) retrieveObject(ctx.rp());
        List<Node> l = new ArrayList<>();
        for(int i = 0; i < document.getLength(); i++){
            l.add((document.item(i)));
        }
        setObject(ctx, l);
    }

    @Override
    public void enterRp_TagName(ExpressionGrammarParser.Rp_TagNameContext ctx) {
        Document document = (Document) retrieveObject(ctx.getParent());
        setObject(ctx, document);
    }

    @Override
    public void exitRp_TagName(ExpressionGrammarParser.Rp_TagNameContext ctx) {
        Document document = (Document) retrieveObject(ctx);
        //ExpressionGrammarParser.RpContext rp = rpContext.get(0);

        if (ctx.tagName() != null) {
            String tagName = (String) retrieveObject(ctx.tagName());
            //find a list of Document nodes with this tagName
            System.out.println(tagName);
            NodeList nl = document.getElementsByTagName(tagName);

            setObject(ctx, nl);
        }else {

        }
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
        setObject(ctx.getParent(), document);

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
