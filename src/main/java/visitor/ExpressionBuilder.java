package visitor;

import DOMBuilder.DOMBuilder;
import edu.ucsd.CSE232B.parsers.ExpressionGrammarBaseVisitor;
import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser;
import expression.DataContext;
import expression.Expression;
import org.antlr.v4.runtime.ParserRuleContext;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.crypto.Data;
import java.util.*;

//
//import edu.ucsd.CSE232B.parsers.ExpressionGrammarBaseVisitor;
//import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser.Expr_BinaryContext;
//import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser.Expr_NumberContext;
//import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser.Expr_ParenthesesContext;
//import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser.Expr_VariableContext;
//import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser.NumberContext;
//import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser.VariableContext;
//import edu.ucsd.cse232b.antlrTutorial.expression.BinaryExpression;
//import edu.ucsd.cse232b.antlrTutorial.expression.Expression;
//import edu.ucsd.cse232b.antlrTutorial.expression.NumberConstant;
//import edu.ucsd.cse232b.antlrTutorial.expression.Operator;
//import edu.ucsd.cse232b.antlrTutorial.expression.ParaExpression;
//import edu.ucsd.cse232b.antlrTutorial.expression.Variable;
//
public class ExpressionBuilder extends ExpressionGrammarBaseVisitor<DataContext> {


    Map<ParserRuleContext, DataContext> dataContext;
    Document document;
    Map<ParserRuleContext, Map<String, Map<String, List<Node>>>> forMap;

    public ExpressionBuilder(){
        this.dataContext = new HashMap<>();
        this.document = null;
        this.forMap = new HashMap<>();
    }

    @Override
    public DataContext visitProg(ExpressionGrammarParser.ProgContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        dataContext.put(ctx, new DataContext(null));
        if(ctx.xq() == null){
            return this.visit(ctx.exp(0));
        }else{
            return this.visit(ctx.xq(0));
        }
     }

    @Override
    public DataContext visitExp(ExpressionGrammarParser.ExpContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);
        System.out.println(curr);
        this.visit(ctx.docName());
        DataContext result = this.visit(ctx.rp());
        System.out.println("Exiting " + ctx.getClass().getName());
        System.out.println(result.map);
        System.out.println(result.data.size());
        dataContext.put(ctx.getParent(), result);
        return result;
    }

    @Override
    public DataContext visitRp_Paren(ExpressionGrammarParser.Rp_ParenContext ctx) {
        return this.visitChildren(ctx);
    }

    @Override
    public DataContext visitRp_Pathsymbol(ExpressionGrammarParser.Rp_PathsymbolContext ctx) {
        DataContext curr = pass(ctx);
        String path = ctx.PATH_SYMBOL().toString();
        if(path.equals(".")){
            dataContext.put(ctx.getParent(), curr);
            return curr;
        }else if(path.equals("..")){
            Set<Node> l = new HashSet<>();
            for(Node n : curr.data){
                l.add(n.getParentNode());
            }
            DataContext result = new DataContext(new ArrayList<>(l), curr.map);
            dataContext.put(ctx.getParent(), result);
            return result;
        }else{
            Set<Node> l = new HashSet<>();
            for(Node n : curr.data){
                NodeList nodeList = n.getChildNodes();
                for(int i = 0; i < nodeList.getLength(); i++){
                    l.add(nodeList.item(i));
                }

            }
            DataContext result = new DataContext(new ArrayList<>(l), curr.map);
            dataContext.put(ctx.getParent(), result);
            return result;

        }
    }
//
//    public T visitRp_Filter(ExpressionGrammarParser.Rp_FilterContext ctx) {
//        return this.visitChildren(ctx);
//    }
//
    @Override
    public DataContext visitRp_Slash(ExpressionGrammarParser.Rp_SlashContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        DataContext dc = pass(ctx);
        dc.data = reform(dc, ctx);
        System.out.println(dc.data.size());


        DataContext dc1 = this.visit(ctx.rp(0));
        DataContext dc2 = this.visit(ctx.rp(1));
        System.out.println("Exiting: " + ctx.getClass().getName());

        dataContext.put(ctx.getParent(), dc2);
        return dc2;
    }

    private List<Node> reform(DataContext dc, ParserRuleContext ctx) {
        if (isParentSlash(ctx, "//")){
            System.out.println("h");
            return populate(dc.data);
        }else if(isParentSlash(ctx, "/")){
            System.out.println("2");
            Set<Node> result = new HashSet<>();
            for(Node node : dc.data){
                NodeList nodeList = node.getChildNodes();

                for(int i = 0; i < nodeList.getLength(); i++){
                    result.add(nodeList.item(i));
                }
            }
            return new ArrayList<>(result);
        }else{
            System.out.println("4");
            return dc.data;
        }
    }

    private boolean isParentSlash(ParserRuleContext ctx, String slash) {
        boolean isParentRp_Slash = ctx.getParent() instanceof ExpressionGrammarParser.Rp_SlashContext
                &&  ((ExpressionGrammarParser.Rp_SlashContext) ctx.getParent()).SLASH().toString().equals(slash)
                &&   ((ExpressionGrammarParser.Rp_SlashContext) ctx.getParent()).rp(1) == ctx;
        boolean isParentExp_Slash = ctx.getParent() instanceof ExpressionGrammarParser.ExpContext
                &&  ((ExpressionGrammarParser.ExpContext) ctx.getParent()).SLASH().toString().equals(slash);
        boolean isParentXq_Slash = ctx.getParent() instanceof ExpressionGrammarParser.XQ_SLASHContext
                &&  ((ExpressionGrammarParser.XQ_SLASHContext) ctx.getParent()).SLASH().toString().equals(slash);

        return isParentRp_Slash || isParentExp_Slash || isParentXq_Slash;
    }

    @Override
    public DataContext visitRp_TagName(ExpressionGrammarParser.Rp_TagNameContext ctx) {
       /*
                   exp
           docName // rp_tagName
        */
        System.out.println("visit " + ctx.getClass().getName());
        DataContext dc = pass(ctx);
        System.out.println(dc.map);
        System.out.println(dc.data.size());
        dc.data = reform(dc, ctx);
        System.out.println("Data " + String.valueOf(dc.data.size()));

        List<Node> nodeList = dc.data;
        DataContext d = this.visit(ctx.tagName());

        Set<Node> result = new HashSet<>();
        for(Node n : nodeList){
            if(n.getNodeName().equals(d.name)){
                result.add(n);
            }
        }
        System.out.println("Exiting: " + ctx.getClass().getName());
        System.out.println(result.size());

        dc = new DataContext(new ArrayList<>(result), dc.map);
        dataContext.put(ctx.getParent(), dc);
        return dc;
    }

//    public T visitRp_AttName(ExpressionGrammarParser.Rp_AttNameContext ctx) {
//        return this.visitChildren(ctx);
//    }
//
    @Override
    public DataContext visitRp_Text(ExpressionGrammarParser.Rp_TextContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        DataContext dc = pass(ctx);

        List<Node> node = new ArrayList<>();
        for(Node n : dc.data){
            node.add(n.getFirstChild());
        }
        dc.data = node;
        dataContext.put(ctx.getParent(), dc.clone());
        System.out.println("Exiting: " + ctx.getClass().getName());
        System.out.println(dc.toString());
        return dataContext.get(ctx.getParent());
    }
//
//    public T visitRp_Comma(ExpressionGrammarParser.Rp_CommaContext ctx) {
//        return this.visitChildren(ctx);
//    }

    @Override
    public DataContext visitTagName(ExpressionGrammarParser.TagNameContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        DataContext dc = pass(ctx);
        dc.name = ctx.NAME().toString();
        return dc.clone();
    }

//    public T visitAttName(ExpressionGrammarParser.AttNameContext ctx) {
//        return this.visitChildren(ctx);
//    }
//
//    public T visitFilter_Or(ExpressionGrammarParser.Filter_OrContext ctx) {
//        return this.visitChildren(ctx);
//    }
//
//    public T visitFilter_And(ExpressionGrammarParser.Filter_AndContext ctx) {
//        return this.visitChildren(ctx);
//    }
//
//    public T visitFilter_Not(ExpressionGrammarParser.Filter_NotContext ctx) {
//        return this.visitChildren(ctx);
//    }
//
//    public T visitFilter_Eq(ExpressionGrammarParser.Filter_EqContext ctx) {
//        return this.visitChildren(ctx);
//    }
//
//    public T visitFilter_SpecEq(ExpressionGrammarParser.Filter_SpecEqContext ctx) {
//        return this.visitChildren(ctx);
//    }
//
//    public T visitFilter_Rp(ExpressionGrammarParser.Filter_RpContext ctx) {
//        return this.visitChildren(ctx);
//    }
//
//    public T visitFilter_Paren(ExpressionGrammarParser.Filter_ParenContext ctx) {
//        return this.visitChildren(ctx);
//    }
//
    @Override
    public DataContext visitXQ_PR(ExpressionGrammarParser.XQ_PRContext ctx) {
        DataContext dc = pass(ctx);
        dataContext.put(ctx.getParent(), this.visit(ctx.xq()));
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitXQ_TAGNAME(ExpressionGrammarParser.XQ_TAGNAMEContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);
        DataContext dc = this.visit(ctx.tagName(0));
        DataContext xq = this.visit(ctx.xq());

        //insert the node before list of node in xq
        Node n = document.createElement(dc.name);
        System.out.println(xq.data);
        for (Node node : xq.data) {
            Node n2 = document.importNode(node.cloneNode(true), true);
            n.appendChild(n2);
        }

        dc.data = new ArrayList<Node>();
        dc.data.add(n);
        System.out.println("Exiting XQ_TAGNAME");
        System.out.println(dc.data);
        System.out.println(dc.map);
        dataContext.put(ctx.getParent(), dc);
        return dc;
    }
//
    @Override
    public DataContext visitXQ_SLASH(ExpressionGrammarParser.XQ_SLASHContext ctx) {
        System.out.println("Visiting " + ctx.getClass().getName());
        DataContext dc = pass(ctx);
        System.out.println(dc.data);
        System.out.println(dc.map);

        DataContext xq = this.visit(ctx.xq());
        dataContext.put(ctx.getParent(), this.visit(ctx.rp()));
        System.out.println("Exiting " + ctx.getClass().getName());
        System.out.println(dataContext.get(ctx.getParent()).data);
        System.out.println(dataContext.get(ctx.getParent()).map);
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitXQ_LET(ExpressionGrammarParser.XQ_LETContext ctx) {
        DataContext curr = pass(ctx);

        DataContext dc = this.visit(ctx.xq());

        dataContext.put(ctx.getParent(), dc.clone());
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitXQ_STRING(ExpressionGrammarParser.XQ_STRINGContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);
        DataContext dc = this.visit(ctx.stringConst());

        System.out.println("exit  " + ctx.getClass().getName());
        dataContext.put(ctx.getParent(), dc.clone());
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitXQ_EXP(ExpressionGrammarParser.XQ_EXPContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        DataContext dc = dataContext.get(ctx.getParent());
        if(dc == null){
            dataContext.put(ctx, new DataContext(null));
        }else{
            dataContext.put(ctx, dc);
        }
        System.out.println(dc.map);
        DataContext result =  this.visit(ctx.exp());
        System.out.println("Exiting " + ctx.getClass().getName());
        System.out.println(result.map);
        System.out.println(result.data.size());
        dataContext.put(ctx.getParent(), result);
        return result;

    }

    @Override
    public DataContext visitXQ_VAR(ExpressionGrammarParser.XQ_VARContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);
        System.out.println(curr.map);
        DataContext dc = this.visit(ctx.var());


        DataContext result = new DataContext(curr.data, curr.map);
        if(result.map.get(dc.name) == null){
            throw new IllegalArgumentException("Illegal variable name");
        }
        result.data = result.map.get(dc.name);
        System.out.println(result.data);
        System.out.println(result.map);

        dataContext.put(ctx.getParent(), result);
        return result;
    }

    @Override
    public DataContext visitXQ_COMMA(ExpressionGrammarParser.XQ_COMMAContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);
        DataContext xq = this.visit(ctx.xq(0));
        DataContext xq2 = this.visit(ctx.xq(1));
        xq.data.addAll(xq2.data);

        dataContext.put(ctx.getParent(), new DataContext(xq.data, curr.map));
        System.out.println("exiting " + ctx.getClass().getName());
        return dataContext.get(ctx.getParent());
    }


    @Override
    public DataContext visitXQ_FOR(ExpressionGrammarParser.XQ_FORContext ctx) {
        pass(ctx);

        this.visit(ctx.forClause());
        this.visit(ctx.letClause());
        this.visit(ctx.whereClause());
        DataContext dc =  this.visit(ctx.returnClause());
        dataContext.put(ctx.getParent(), dc);
        return dc;
    }

    @Override
    public DataContext visitForClause(ExpressionGrammarParser.ForClauseContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);
        DataContext dc = this.visit(ctx.items());

        if(ctx.items() instanceof ExpressionGrammarParser.ITEM_ONEContext){
            //update e
            for(Map.Entry<String, List<Node>> e : dc.map.entrySet()){
                curr.map.put(e.getKey(), e.getValue());
            }

            curr.possibilities = dc.possibilities;
            dataContext.put(ctx.getParent(), dc.clone());
            return dataContext.get(ctx.getParent());
        }else {
            System.out.println(dc);
            dataContext.put(ctx.getParent(), dc);
            return dc;
        }
    }

    @Override
    public DataContext visitITEM_MULTIPLE(ExpressionGrammarParser.ITEM_MULTIPLEContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);

        DataContext dc = this.visit(ctx.item());

        System.out.println("middle");

        //get c = {a: [1, 2]} p = {a=1, a=2}
        //update change in c to parent
        for(Map.Entry<String, List<Node>> map : dc.map.entrySet()){
            curr.map.put(map.getKey(), map.getValue());
        }

        //for each p = {a=1} for example pass it:

        Map<String, List<Node>> originalMap = curr.map;
        Map<String, List<Node>> newMap = new HashMap<>();
        List<Map<String, List<Node>>> possibilities = new ArrayList<>();

        for(Map<String, List<Node>> map : dc.possibilities){
            //set c = p = [a:[1]]
            curr.possibilities = Arrays.asList(map);
            curr.map = map;
            dataContext.put(ctx, curr);
            DataContext dc2 = this.visit(ctx.items());


            //get the difference
            for(Map.Entry<String, List<Node>> m : dc2.map.entrySet()){
                if (!newMap.containsKey(m.getKey())){
                    newMap.put(m.getKey(), new ArrayList<Node>());
                }
                List<Node> l = newMap.get(m.getKey());
                List<Node> h = m.getValue();
                l.addAll(h);

            }

            possibilities.addAll(dc2.possibilities);
        }


        curr.map = originalMap;
        for(Map.Entry<String, List<Node>> entry: newMap.entrySet()){
            curr.map.put(entry.getKey(), entry.getValue());
        }
        curr.possibilities = possibilities;

        System.out.println("exiting " + ctx.getClass().getName());
        dataContext.put(ctx.getParent(), curr.clone());
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitITEM_ONE(ExpressionGrammarParser.ITEM_ONEContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        //copy from parent
        //go to item to get data
        // added to possibilities
        //return all possibilities

        DataContext curr = pass(ctx);

        //for each p = {a=1} for example pass it:
        DataContext dc = this.visit(ctx.item());

        System.out.println("exiting " + ctx.getClass().getName());
        dataContext.put(ctx.getParent(), dc.clone());
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitItem(ExpressionGrammarParser.ItemContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());

        //copy c:{a : [1,2]} p:{a=1, a= 2}
        DataContext curr = pass(ctx);

        DataContext dc = this.visit(ctx.var());
        DataContext dc2 = this.visit(ctx.xq());

        //update c
        curr.map = new HashMap<>();
        curr.map.put(dc.name, dc2.data);

        //update p
        List<Map<String, List<Node>>> l = new ArrayList<>();
        if(curr.possibilities.size() == 0){
            for(Node node : dc2.data){
                Map<String, List<Node>> result = new HashMap<>();
                result.put(dc.name, Arrays.asList(node));
                l.add(result);
            }
        }else {
            for (Map<String, List<Node>> map : curr.possibilities) {
                for (Node node : dc2.data) {
                    Map<String, List<Node>> result = new HashMap<>(map);
                    result.put(dc.name, Arrays.asList(node));
                    l.add(result);
                }
            }
        }

        curr.possibilities = l;


        //return curr
        dataContext.put(ctx.getParent(), curr.clone());
        System.out.println("exiting item");
        System.out.println(dataContext.get(ctx.getParent()).toString());
        return dataContext.get(ctx.getParent());
    }

    private void getAllCombinations(List<String> key, Map<String, List<Node>> map, int i, Map<String, List<Node>> cur){
        if(i == key.size()){
            //forMap.add(new HashMap<String, List<Node>>(cur));
            return;
        }

        List<Node> nl = map.get(key.get(i));

        for(int j = 0; j < nl.size(); j++){
            List<Node> tmp = new ArrayList<>();
            tmp.add(nl.get(j));
            cur.put(key.get(i), tmp);
            getAllCombinations(key, map, i + 1, cur);
            cur.remove(key.get(i));
        }
    }

    @Override
    public DataContext visitLET_DEF(ExpressionGrammarParser.LET_DEFContext ctx) {
        DataContext curr = pass(ctx);
        DataContext dc = this.visit(ctx.definition());

        dataContext.put(ctx, dc.clone());
        return dataContext.get(ctx);
    }

    @Override
    public DataContext visitLET_NONE(ExpressionGrammarParser.LET_NONEContext ctx) {
        return null;
    }
//
//    public T visitDEF_MUTIPLE(ExpressionGrammarParser.DEF_MUTIPLEContext ctx) {
//        return this.visitChildren(ctx);
//    }
//
//    public T visitDEF_ONE(ExpressionGrammarParser.DEF_ONEContext ctx) {
//        return this.visitChildren(ctx);
//    }
//
//    public T visitDefinition(ExpressionGrammarParser.DefinitionContext ctx) {
//        return this.visitChildren(ctx);
//    }
//
    @Override
    public DataContext visitWHERE_CONDITION(ExpressionGrammarParser.WHERE_CONDITIONContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);

        //for map is with all kind of combinations
        Map<String, List<Node>> originalMap = curr.map;
        List<Map<String, List<Node>>> filter = new ArrayList<>();


        System.out.println(curr.data);
        for(Map<String, List<Node>> entry : curr.possibilities){
            curr.map = entry;
            dataContext.put(ctx, curr);
            DataContext dc = this.visit(ctx.cond());

            if(dc.ok){
                filter.add(entry);
            }
        }
        System.out.println("Exiting Where_Condition");
        curr.map = originalMap;
        curr.possibilities = filter;
        dataContext.put(ctx.getParent(), curr.clone());

        return null;
    }

    @Override
    public DataContext visitWHERE_NONE(ExpressionGrammarParser.WHERE_NONEContext ctx) {
        /*

           XQ need hash map
           {$x : v ... }

           XQ needs List<Node>

         */
        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);
        System.out.println(curr.map);
        List<String> keys = new ArrayList<>(curr.map.keySet());
        Map<String, List<Node>> map = new HashMap<>();
        getAllCombinations(keys, curr.map, 0, map);
        return null;
    }

    @Override
    public DataContext visitReturnClause(ExpressionGrammarParser.ReturnClauseContext ctx) {
        /*
           $x : [x1, x2]
           $Y : [y1, y2]
         */

        System.out.println("visit " + ctx.getClass().getName());

        DataContext dc = new DataContext(null);
        DataContext curr = pass(ctx);

        Map<String, List<Node>> oldMap = curr.map;


        for(Map<String, List<Node>> entry : curr.possibilities){
            curr.map = entry;
            dataContext.put(ctx, curr);
            DataContext dc2 = this.visit(ctx.xq());
            dc.data.addAll(dc2.data);
        }

        System.out.println("Exiting: " + ctx.getClass().getName());
        dc.map = oldMap;
        dc.possibilities = curr.possibilities;
        System.out.println(dc.data);
        return dc;
    }

    @Override
    public DataContext visitCOND_SPEQUAL(ExpressionGrammarParser.COND_SPEQUALContext ctx) {
        DataContext curr = pass(ctx);

        DataContext dc = this.visit(ctx.xq(0));
        DataContext dc2 = this.visit(ctx.xq(1));

        for(Node n : dc.data){
            for(Node n2 : dc2.data){
                if(n == n2){
                     return new DataContext(true);
                }
            }
        }

        return new DataContext(false);
    }
    @Override
    public DataContext visitCOND_PR(ExpressionGrammarParser.COND_PRContext ctx) {
        DataContext curr = pass(ctx);

        return this.visit(ctx.cond());
    }

    @Override
    public DataContext visitCOND_AND(ExpressionGrammarParser.COND_ANDContext ctx) {
        DataContext curr = pass(ctx);

        DataContext dc0 = this.visit(ctx.cond(0));
        DataContext dc2 = this.visit(ctx.cond(1));

        curr.ok = dc0.ok && dc2.ok;
        return curr;
    }

    @Override
    public DataContext visitCOND_EMPTY(ExpressionGrammarParser.COND_EMPTYContext ctx) {
        DataContext curr = pass(ctx);
        DataContext dc = this.visit(ctx.xq());
        return  new DataContext(dc.ok);
    }

    @Override
    public DataContext visitCOND_SATISFY(ExpressionGrammarParser.COND_SATISFYContext ctx) {
        DataContext curr = pass(ctx);
        DataContext dc = this.visit(ctx.items());

        boolean some = false;
        for(Map<String, List<Node>> map : dc.possibilities){
            curr.map = map;
            dataContext.put(ctx, curr);
            DataContext dc2 = this.visit(ctx.cond());

            if(dc2.ok){
                some = true;
                break;
            }
        }

        return new DataContext(some);
    }

    @Override
    public DataContext visitCOND_NEGATE(ExpressionGrammarParser.COND_NEGATEContext ctx) {
        DataContext curr = pass(ctx);
        DataContext dc = this.visit(ctx.cond());
        curr.ok = !dc.ok;
        return curr;
    }

    @Override
    public DataContext visitCOND_OR(ExpressionGrammarParser.COND_ORContext ctx) {
        DataContext curr = pass(ctx);

        DataContext dc = this.visit(ctx.cond(0));
        DataContext dc2 = this.visit(ctx.cond(1));

        curr.ok = dc.ok || dc2.ok;
        return curr;
    }

    @Override
    public DataContext visitCOND_EQUAL(ExpressionGrammarParser.COND_EQUALContext ctx) {
        DataContext curr = pass(ctx);
        DataContext dc = this.visit(ctx.xq(0));
        DataContext dc2 = this.visit(ctx.xq(1));


        Set<Node> set = new HashSet<>(dc.data);
        Set<Node> set2 = new HashSet<>(dc2.data);

        boolean ok = false;
        for(Node node1: set){
            for(Node node2: set2){
                if(node1.isEqualNode(node2)){
                    ok = true;
                    break;
                }

            }
        }


        curr.ok = ok;

        System.out.println("Exiting Cond EQUAL");
        System.out.println(curr.toString());
        return curr.clone();
    }

    @Override
    public DataContext visitDocName(ExpressionGrammarParser.DocNameContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);
        System.out.println(curr.map);
        //get filename
        DataContext fileName = this.visit(ctx.fileName());

        DOMBuilder dombUilder = new DOMBuilder();
        //create document node
        this.document = dombUilder.getDocument(fileName.name);

        List<Node> result = new ArrayList<>();
        result.add(document);

        //pass datacontext with new Data back to parent
        dataContext.put(ctx.getParent(), new DataContext(result, curr.map));
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitVar(ExpressionGrammarParser.VarContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        return new DataContext(ctx.NAME().toString());
    }

    @Override
    public DataContext visitFileName(ExpressionGrammarParser.FileNameContext ctx) {
        System.out.println("visit " + ctx.getClass().getName());
        return new DataContext(ctx.STRING().toString());
    }

    @Override
    public DataContext visitStringConst(ExpressionGrammarParser.StringConstContext ctx) {
        DataContext curr = pass(ctx);
        Node n = document.createTextNode(ctx.STRING().toString().replaceAll("\"", ""));
        curr.data = new ArrayList<>();
        curr.data.add(n);
        return curr.clone();
    }

    private boolean inAForLoop(ParserRuleContext ctx){
        while(! (ctx.getParent() instanceof ExpressionGrammarParser.ProgContext)){
            if(ctx instanceof ExpressionGrammarParser.XQ_FORContext){
                return true;
            }
            ctx = ctx.getParent();
        }
        return false;
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
    public void getNodeByTagName(Node n, String tagName, Set<Node> res) {
        String name = n.getNodeName();

        if(name.equals(tagName)){
            res.add(n);
        }

        for (Node child = n.getFirstChild(); child != null;
             child = child.getNextSibling()) {
            getNodeByTagName(child, tagName, res);
        }
    }

    private List<Node> populate(List<Node> nl) {

        Set<Node> res = new HashSet<>();
        for(Node n : nl) {
            Set<Node> result = new HashSet<>();
            getAllNodes(n, result);
            res.addAll(result);
        }

        return new ArrayList<>(res);

    }

    private void getAllNodes(Node n, Set<Node> result){
        if(n == null){
            return;
        }

        result.add(n);
        for (Node child = n.getFirstChild(); child != null;
             child = child.getNextSibling()) {
            getAllNodes(child, result);
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

    public void put(ParserRuleContext ctx, DataContext dc){
        dataContext.put(ctx, dc.clone());
    }
    public DataContext get(ParserRuleContext ctx){
        return dataContext.get(ctx);
    }

    public DataContext pass(ParserRuleContext ctx){
        //get a dc from parent and store a clone in current node
        DataContext dc = dataContext.getOrDefault(ctx.getParent(), new DataContext(null));
        put(ctx, dc);
        System.out.println("Entering: " + ctx.getClass().getName());
        System.out.println(dataContext.get(ctx).toString());
        return dataContext.get(ctx);
    }
//    @Override
//    public Expression visitExpr_Binary(Expr_BinaryContext ctx) {
//        final Expression expressionLeft = visit(ctx.exp(0));
//        final Operator operator = Operator.fromString(ctx.OP().getText());
//        final Expression expressionRight = visit(ctx.exp(1));
//        return  new BinaryExpression(expressionLeft,operator,expressionRight);
//    }
//
//    @Override
//    public Expression visitExpr_Parentheses(Expr_ParenthesesContext ctx) {
//        final Expression expression = visit(ctx.exp());
//        return new ParaExpression(expression);
//    }
//
//    @Override
//    public Expression visitExpr_Number(Expr_NumberContext ctx) {
//        final Expression number = visit(ctx.number());
//        return number;
//    }
//
//    @Override
//    public Expression visitNumber(NumberContext ctx) {
//        final int number = Integer.valueOf(ctx.NUM().getText());
//        final NumberConstant numberConstant = new NumberConstant(number);
//        return numberConstant;
//    }
//
//    @Override
//    public Expression visitExpr_Variable(Expr_VariableContext ctx) {
//        final Expression variable = visit(ctx.variable());
//        return variable;
//    }
//    @Override
//    public Expression visitVariable(VariableContext ctx) {
//        final String name = ctx.ID().getText();
//        final Variable variable = new Variable(name);
//        return variable;
//    }
}
