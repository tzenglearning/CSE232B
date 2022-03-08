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
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
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
//        System.out.println("visit " + ctx.getClass().getName());
        dataContext.put(ctx, new DataContext(null));
        if(ctx.xq() == null){
            return this.visit(ctx.exp(0));
        }else{
            return this.visit(ctx.xq(0));
        }
     }

    @Override
    public DataContext visitExp(ExpressionGrammarParser.ExpContext ctx) {
//        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);
        //System.out.println(curr);
        DataContext d = this.visit(ctx.docName());
        d.data = reform(d.data, ctx.SLASH().toString());
        dataContext.put(ctx, d);
        DataContext result = this.visit(ctx.rp());
//        System.out.println("Exiting " + ctx.getClass().getName());
        //System.out.println(result.map);
        //System.out.println(result.data.size());
        dataContext.put(ctx.getParent(), result);
        return result;
    }

    @Override
    public DataContext visitRp_Paren(ExpressionGrammarParser.Rp_ParenContext ctx) {
        DataContext curr = pass(ctx);
        DataContext  dc = this.visit(ctx.rp());
        dataContext.put(ctx.getParent(), dc.clone());
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitRp_Pathsymbol(ExpressionGrammarParser.Rp_PathsymbolContext ctx) {
        DataContext curr = pass(ctx);
        String path = ctx.PATH_SYMBOL().toString();
        if(path.equals(".")){
            if(needGoBackByTwoLevel(ctx)){
                Set<Node> l = new HashSet<>();
                for(Node n: curr.data){
                    l.add(n.getParentNode());
                }
                curr.data = new ArrayList<>(l);
            }else{
            }
            dataContext.put(ctx.getParent(), curr);

            return curr;
        }else if(path.equals("..")){

            Set<Node> l = new HashSet<>();
            for(Node n : curr.data){
                l.add(n.getParentNode());
            }

            Set<Node> l2 = new HashSet<>();
            if(needGoBackByTwoLevel(ctx)){
                for(Node n: l){
                    l2.add(n.getParentNode());
                }
            }else{
                l2.addAll(l);
            }

            DataContext result = new DataContext(new ArrayList<>(l2), curr.map);
            dataContext.put(ctx.getParent(), result);
            return result;
        }else{
            dataContext.put(ctx.getParent(), curr);
            return dataContext.get(ctx.getParent());

        }
    }

    public DataContext visitRp_Filter(ExpressionGrammarParser.Rp_FilterContext ctx) {
        DataContext curr = pass(ctx);

        DataContext dc = this.visit(ctx.rp());
        List<Node> originalL = dc.data;
        Set<Node> filter = new HashSet<>();

        for(Node n : originalL) {

            Set<Node> l = new HashSet<>();
            NodeList nodeList = n.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                l.add(nodeList.item(i));
            }

            dc.data = new ArrayList<>(l);
            dataContext.put(ctx, dc);
            DataContext dc2 = this.visit(ctx.filter());

            if(dc2.ok){
                filter.add(n);
            }
        }

       dc.data = new ArrayList<>(filter);
       dataContext.put(ctx.getParent(), dc);
       return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitRp_Slash(ExpressionGrammarParser.Rp_SlashContext ctx) {
//        System.out.println("visit " + ctx.getClass().getName());
        DataContext dc = pass(ctx);

        DataContext dc1 = this.visit(ctx.rp(0));
        dc1.data = reform(dc1.data, ctx.SLASH().toString());
        //System.out.println(dc1.data.size());

        dataContext.put(ctx, dc1);
        DataContext dc2 = this.visit(ctx.rp(1));
//        System.out.println("Exiting: " + ctx.getClass().getName());

        dataContext.put(ctx.getParent(), dc2);
        return dc2;
    }

    private List<Node> reform(List<Node> data, String slash) {
        if (slash.equals("//")){
//            System.out.println("h");
            List<Node> l = populate(data);
            return l;
        }else{
//            System.out.println("2");
            Set<Node> result = new HashSet<>();
            for(Node node : data){
                NodeList nodeList = node.getChildNodes();

                for(int i = 0; i < nodeList.getLength(); i++){
                    result.add(nodeList.item(i));
                }
            }
            return new ArrayList<>(result);
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
//        System.out.println("visit " + ctx.getClass().getName());
        DataContext dc = pass(ctx);
        //System.out.println(dc.map);
        //System.out.println(dc.data.size());
//        System.out.println("Data " + String.valueOf(dc.data.size()));

        List<Node> nodeList = dc.data;
        DataContext d = this.visit(ctx.tagName());

        Set<Node> result = new HashSet<>();
        for(Node n : nodeList){
            if(n.getNodeName().equals(d.name)){
                result.add(n);
            }
        }
//        System.out.println("Exiting: " + ctx.getClass().getName());
        //System.out.println(result.size());

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
//        System.out.println("visit " + ctx.getClass().getName());
        //assume the path is correct
        DataContext dc = pass(ctx);

        dataContext.put(ctx.getParent(), dc.clone());
//        System.out.println("Exiting: " + ctx.getClass().getName());
//        System.out.println(dc.toString());
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitRp_Comma(ExpressionGrammarParser.Rp_CommaContext ctx) {
        DataContext curr = pass(ctx);
        DataContext dc = this.visit(ctx.rp(0));
        dataContext.put(ctx, curr);
        DataContext dc2 = this.visit(ctx.rp(1));
        dc.data.addAll(dc2.data);
        dataContext.put(ctx.getParent(), dc.clone());
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitTagName(ExpressionGrammarParser.TagNameContext ctx) {
//        System.out.println("visit " + ctx.getClass().getName());
        DataContext dc = pass(ctx);
        dc.name = ctx.NAME().toString();
        return dc.clone();
    }

//    public T visitAttName(ExpressionGrammarParser.AttNameContext ctx) {
//        return this.visitChildren(ctx);
//    }
//
    @Override
    public DataContext visitFilter_Or(ExpressionGrammarParser.Filter_OrContext ctx) {
        DataContext curr = pass(ctx);

        dataContext.put(ctx, curr);
        DataContext dc = this.visit(ctx.filter(0));
        dataContext.put(ctx, curr);
        DataContext dc2 = this.visit(ctx.filter(1));
        return new DataContext(dc.ok || dc2.ok);
    }
    @Override
    public DataContext visitFilter_And(ExpressionGrammarParser.Filter_AndContext ctx) {
        DataContext curr = pass(ctx);

        dataContext.put(ctx, curr);
        DataContext dc = this.visit(ctx.filter(0));
        dataContext.put(ctx, curr);
        DataContext dc2 = this.visit(ctx.filter(1));
        return new DataContext(dc.ok && dc2.ok);
    }


    @Override
    public DataContext visitFilter_Not(ExpressionGrammarParser.Filter_NotContext ctx) {
        DataContext curr = pass(ctx);
        DataContext dc = this.visit(ctx.filter());
        return new DataContext(!dc.ok);
    }

    public DataContext visitFilter_Eq(ExpressionGrammarParser.Filter_EqContext ctx) {
        DataContext curr = pass(ctx);
        if(ctx.rp().size() == 2) {
            dataContext.put(ctx, curr);
            DataContext dc = this.visit(ctx.rp(0));
            dataContext.put(ctx,curr);
            DataContext dc2 = this.visit(ctx.rp(1));

            for (Node n1 : dc.data) {
                for (Node n2 : dc2.data) {
                    if (n1.isSameNode(n2)) {
                        return new DataContext(true);
                    }
                }
            }
            return new DataContext(false);
        }else{
            dataContext.put(ctx, curr);
            DataContext dc = this.visit(ctx.rp(0));
            for (Node n1 : dc.data) {
                if (n1.getNodeValue().equals(ctx.STRING().toString().replaceAll("\"", ""))) {
                        return new DataContext(true);
                }
            }

            return new DataContext(false);
        }
    }


    public DataContext visitFilter_SpecEq(ExpressionGrammarParser.Filter_SpecEqContext ctx) {
        DataContext curr = pass(ctx);

        dataContext.put(ctx, curr);
        DataContext dc = this.visit(ctx.rp(0));
        dataContext.put(ctx,curr);
        DataContext dc2 = this.visit(ctx.rp(1));

        for(Node n1 : dc.data){
            for(Node n2 : dc2.data){
                if(n1.isEqualNode(n2)){
                    return new DataContext(true);
                }
            }
        }

        return new DataContext(false);
    }

    @Override
    public DataContext visitFilter_Rp(ExpressionGrammarParser.Filter_RpContext ctx) {
        DataContext curr = pass(ctx);
        dataContext.put(ctx, curr);
        DataContext dc = this.visit(ctx.rp());
        if(dc.data.size() > 0){
            return new DataContext(true);
        }else{
            return new DataContext(false);
        }
    }

    public DataContext visitFilter_Paren(ExpressionGrammarParser.Filter_ParenContext ctx) {
        DataContext curr = pass(ctx);
        DataContext dc = this.visit(ctx.filter());

        return dc;
    }

    @Override
    public DataContext visitXQ_PR(ExpressionGrammarParser.XQ_PRContext ctx) {
        DataContext dc = pass(ctx);
        dataContext.put(ctx.getParent(), this.visit(ctx.xq()));
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitXQ_JOIN(ExpressionGrammarParser.XQ_JOINContext ctx){
        DataContext curr = pass(ctx);
        DataContext dc = this.visit(ctx.xq(0));
        dataContext.put(ctx, curr);
        DataContext dc2 = this.visit(ctx.xq(1));
        DataContext dc4 = this.visit(ctx.namelist(0));
        DataContext dc8 = this.visit(ctx.namelist(1));
        String[] nameList = dc4.name.split(",");
        String[] nameList2 =dc8.name.split(",");
        List<Map<String, List<Node>>> newList = new ArrayList<>();


        Map<Long, List<Map<String,List<Node>>>> tupleMap = new HashMap<>();
        for(int i = 0; i < dc.data.size(); i++) {
            Map<String, List<Node>> tuple = getMapFromTuple(dc.data.get(i));
            tupleMap.computeIfAbsent(getHashCode(tuple, nameList), k -> new ArrayList<>()).add(tuple);
        }

        for(int j = 0; j < dc2.data.size(); j++){
            Map<String, List<Node>> tuple2 = getMapFromTuple(dc2.data.get(j));
            long hashCode = getHashCode(tuple2, nameList2);

            if(!tupleMap.containsKey(hashCode)) continue;
            for(Map<String, List<Node>> tuple : tupleMap.get(hashCode)) {
                if(isEqual(tuple, nameList, tuple2, nameList2)) {
                    newList.add(join(tuple,tuple2));
                }
            }
        }

//        for(int i = 0; i < dc.data.size(); i++) {
//            Map<String, List<Node>> tuple = getMapFromTuple(dc.data.get(i));
//            for (int j = 0; j < dc2.data.size(); j++) {
//                Map<String, List<Node>> tuple2 = getMapFromTuple(dc2.data.get(j));
//                if (isEqual(tuple, nameList, tuple2, nameList2)) {
//                        newList.add(join(tuple, tuple2));
//                } }
//        }

        Set<Node> result = new HashSet<>();

        for(int i = 0; i < newList.size(); i++){
            Map<String, List<Node>> p = newList.get(i);
            Node n = document.createElement("tuple");
            for (Map.Entry<String, List<Node>> e : p.entrySet()) {
                Node varNode = document.createElement(e.getKey());
                List<Node> l = e.getValue();
                for(Node node : l) {
                    Node n2 = document.importNode(node.cloneNode(true), true);
                    varNode.appendChild(n2);
                }
                n.appendChild(varNode);
            }
            result.add(n);
        }
        curr.data = new ArrayList<>(result);
        curr.possibilities = newList;
        return curr;
    }

    public boolean isEqual(Map<String, List<Node>> map, String[] nameList, Map<String, List<Node>> map2, String[] nameList2){
        for(int i = 0; i < nameList.length; i++) {
            List<Node> value = map.get(nameList[i]);
            List<Node> value2 = map2.get(nameList2[i]);
            if(value.size() != value2.size()) return false;
            for(int j = 0; j < value.size(); j++){
                if(!value.get(j).isEqualNode(value2.get(j))){
                    return false;
                }
            }

        }
        return true;
    }

    public Map<String, List<Node>> join(Map<String, List<Node>> map, Map<String, List<Node>> map2){
        Map<String, List<Node>> result = new HashMap<>(map);
        result.putAll(map2);
        return result;
    }

    public Long getHashCode(Map<String, List<Node>> tuple, String[] nameList) {
        long hashCode = 0;
        for(String name: nameList){
            Node n = tuple.get(name).get(0);
            n = n.getFirstChild();
            if(n == null) return hashCode % 10;
            String textContent = n.getTextContent();
            if(textContent != null){
                hashCode += textContent.hashCode();
            }
        }
        return hashCode % 10;
    }
    public Map<String, List<Node>> getMapFromTuple(Node n){
        Map<String, List<Node>> map = new HashMap<>();
        for(Node child = n.getFirstChild(); child != null; child = child.getNextSibling()){
            map.put(child.getNodeName(), Arrays.asList(child.getFirstChild()));
        }
        return map;
    }
    @Override
    public DataContext visitXQ_TAGNAME(ExpressionGrammarParser.XQ_TAGNAMEContext ctx) {
//        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);
        DataContext dc = this.visit(ctx.tagName(0));
        DataContext xq = this.visit(ctx.xq());

        //insert the node before list of node in xq
        Node n = document.createElement(dc.name);
//        System.out.println(xq.data);
        for (Node node : xq.data) {
            Node n2 = document.importNode(node.cloneNode(true), true);
            n.appendChild(n2);
        }
        dc.data = new ArrayList<Node>();
        dc.data.add(n);
//        System.out.println("Exiting XQ_TAGNAME");
//        System.out.println(dc.data);
//        System.out.println(dc.map);
        dataContext.put(ctx.getParent(), dc);
        return dc;
    }
//
    @Override
    public DataContext visitXQ_SLASH(ExpressionGrammarParser.XQ_SLASHContext ctx) {
//        System.out.println("Visiting " + ctx.getClass().getName());
        DataContext dc = pass(ctx);
//        System.out.println(dc.data);
//        System.out.println(dc.map);

        DataContext xq = this.visit(ctx.xq());
        xq.data = reform(xq.data, ctx.SLASH().toString());

        dataContext.put(ctx, xq);
        dataContext.put(ctx.getParent(), this.visit(ctx.rp()));
//        System.out.println("Exiting " + ctx.getClass().getName());
//        System.out.println(dataContext.get(ctx.getParent()).data);
//        System.out.println(dataContext.get(ctx.getParent()).map);
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitXQ_LET(ExpressionGrammarParser.XQ_LETContext ctx) {
        DataContext curr = pass(ctx);

        DataContext dc = this.visit(ctx.definitions());

        dataContext.put(ctx.getParent(), dc.clone());
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitXQ_STRING(ExpressionGrammarParser.XQ_STRINGContext ctx) {
//        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);
        DataContext dc = this.visit(ctx.stringConst());

//        System.out.println("exit  " + ctx.getClass().getName());
        dataContext.put(ctx.getParent(), dc);
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitXQ_EXP(ExpressionGrammarParser.XQ_EXPContext ctx) {
//        System.out.println("visit " + ctx.getClass().getName());
        DataContext dc = dataContext.get(ctx.getParent());
        if(dc == null){
            dataContext.put(ctx, new DataContext(null));
            dc = dataContext.get(ctx);
        }else{
            dataContext.put(ctx, dc);
        }
//        System.out.println(dc.map);
        DataContext result =  this.visit(ctx.exp());
//        System.out.println("Exiting " + ctx.getClass().getName());
//        System.out.println(result.map);
//        System.out.println(result.data.size());
        dataContext.put(ctx.getParent(), result);
        return result;

    }

    @Override
    public DataContext visitXQ_VAR(ExpressionGrammarParser.XQ_VARContext ctx) {
//        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);
        //System.out.println(curr.map);
        DataContext dc = this.visit(ctx.var());


        DataContext result = new DataContext(curr.data, curr.map);
        if(result.map.get(dc.name) == null){
            throw new IllegalArgumentException("Illegal variable name");
        }
        result.data = result.map.get(dc.name);
//        System.out.println(result.data);
//        System.out.println(result.map);

        //dataContext.put(ctx.getParent(), result);
        return result;
    }

    @Override
    public DataContext visitXQ_COMMA(ExpressionGrammarParser.XQ_COMMAContext ctx) {
//        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);
        DataContext xq = this.visit(ctx.xq(0));
        dataContext.put(ctx, curr);
        DataContext xq2 = this.visit(ctx.xq(1));
        List<Node> res = new ArrayList<>(xq.data);
        for(Node n : xq2.data){
            res.add(n);
        }


        dataContext.put(ctx.getParent(), new DataContext(res, curr.map));
//        System.out.println("exiting " + ctx.getClass().getName());
        return dataContext.get(ctx.getParent());
    }


    @Override
    public DataContext visitXQ_FOR(ExpressionGrammarParser.XQ_FORContext ctx) {
        DataContext curr = pass(ctx);
        Map<String, List<Node>> oldMap = new HashMap<>(curr.map);

        this.visit(ctx.forClause());
        this.visit(ctx.letClause());
        this.visit(ctx.whereClause());
        DataContext dc =  this.visit(ctx.returnClause());
        dc.map = oldMap;
        dataContext.put(ctx.getParent(), dc);
        return dc;
    }

    @Override
    public DataContext visitForClause(ExpressionGrammarParser.ForClauseContext ctx) {
//        System.out.println("visit " + ctx.getClass().getName());
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
            //System.out.println(dc);
            dataContext.put(ctx.getParent(), dc);
            return dc;
        }
    }

    @Override
    public DataContext visitITEM_MULTIPLE(ExpressionGrammarParser.ITEM_MULTIPLEContext ctx) {
//        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);

        DataContext dc = this.visit(ctx.item());

//        System.out.println("middle");

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

//        System.out.println("exiting " + ctx.getClass().getName());
        dataContext.put(ctx.getParent(), curr.clone());
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitITEM_ONE(ExpressionGrammarParser.ITEM_ONEContext ctx) {
//        System.out.println("visit " + ctx.getClass().getName());
        //copy from parent
        //go to item to get data
        // added to possibilities
        //return all possibilities

        DataContext curr = pass(ctx);

        //for each p = {a=1} for example pass it:
        DataContext dc = this.visit(ctx.item());

//        System.out.println("exiting " + ctx.getClass().getName());
        dataContext.put(ctx.getParent(), dc.clone());
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitItem(ExpressionGrammarParser.ItemContext ctx) {
//        System.out.println("visit " + ctx.getClass().getName());

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
//        System.out.println("exiting item");
        //System.out.println(dataContext.get(ctx.getParent()).toString());
        return dataContext.get(ctx.getParent());
    }

    private void getAllCombinations(List<String> key, Map<String, List<Node>> map, int i, Map<String, List<Node>> cur, List<Map<String, List<Node>>> result){
        if(i == key.size()){
            result.add(new HashMap<String, List<Node>>(cur));
            return;
        }

        List<Node> nl = map.get(key.get(i));

        for(int j = 0; j < nl.size(); j++){
            List<Node> tmp = new ArrayList<>();
            tmp.add(nl.get(j));
            cur.put(key.get(i), tmp);
            getAllCombinations(key, map, i + 1, cur, result);
            cur.remove(key.get(i));
        }
    }

    @Override
    public DataContext visitLET_DEF(ExpressionGrammarParser.LET_DEFContext ctx) {
        DataContext curr = pass(ctx);
        DataContext dc = this.visit(ctx.definitions());

        dataContext.put(ctx.getParent(), dc.clone());
        return dataContext.get(ctx);
    }

    @Override
    public DataContext visitLET_NONE(ExpressionGrammarParser.LET_NONEContext ctx) {
        return null;
    }

    @Override
    public DataContext visitDEF_MUTIPLE(ExpressionGrammarParser.DEF_MUTIPLEContext ctx) {
        DataContext curr = pass(ctx);

        Map <String, List<Node>> originalM = curr.map;//a1
        List<Map<String, List<Node>>> originalP = curr.possibilities;//{a1}
        Set<Map<String, List<Node>>> result = new HashSet<>();//{}


        for(Map<String, List<Node>> entry : originalP){
            curr.map = entry;//a1
            curr.possibilities = Arrays.asList(entry);//{a1}
            dataContext.put(ctx, curr);
            DataContext dc = this.visit(ctx.definition());//{b12} {a1b1, a1b2}

            //new map from dc b = [1, 2]
            DataContext data = new DataContext(null);



            //new possibilities from definition
            List<Map<String, List<Node>>> newP = new ArrayList<>(dc.possibilities);//{a1b1, b2}

            //a1 b12 {a1b1 a1b2}
            data.map = new HashMap<>(dc.map);
            data.possibilities = new ArrayList<>(newP);

            //a1b1
            //a1b2
            for(Map<String, List<Node>> possibility : data.possibilities){
                dataContext.put(ctx, new DataContext(possibility, Arrays.asList(possibility)));
                //a1b1
                //a2b1
                //a1b2
                //a2b2
                DataContext dc2 = this.visit(ctx.definitions());
                originalM = dc2.map;
                result.addAll(dc2.possibilities);
            }
        }

        DataContext data = new DataContext(originalM, new ArrayList<>(result));
        return data;

    }

    @Override
    public DataContext visitDEF_ONE(ExpressionGrammarParser.DEF_ONEContext ctx) {
        DataContext curr = pass(ctx);

        if(ctx.getParent() instanceof ExpressionGrammarParser.LET_DEFContext){
            //do the job as def_multiple
            Map <String, List<Node>> originalM = curr.map;//a1
            List<Map<String, List<Node>>> originalP = curr.possibilities;//{a1}
            Set<Map<String, List<Node>>> result = new HashSet<>();//{}


            for(Map<String, List<Node>> entry : originalP){
                curr.map = entry;//a1
                curr.possibilities = Arrays.asList(entry);//{a1}
                dataContext.put(ctx, curr);
                DataContext dc = this.visit(ctx.definition());//{b12} {a1b1, a1b2}

                //new map from dc b = [1, 2]
                DataContext data = new DataContext(null);



                //new possibilities from definition
                List<Map<String, List<Node>>> newP = new ArrayList<>(dc.possibilities);//{a1b1, b2}

                //a1 b12 {a1b1 a1b2}
                data.map = new HashMap<>(dc.map);
                data.possibilities = new ArrayList<>(newP);

                originalM = data.map;
                result.addAll(data.possibilities);
            }

            DataContext data = new DataContext(originalM, new ArrayList<>(result));
            return data;

        }else {
            return this.visit(ctx.definition());
        }
    }

    @Override
    public DataContext visitDefinition(ExpressionGrammarParser.DefinitionContext ctx) {
        //copy c:{a12b1} p:{a1b1}
        DataContext curr = pass(ctx);

        //a
        DataContext dc = this.visit(ctx.var());
        //a12
        DataContext dc2 = this.visit(ctx.xq());

        //update c
        curr.map.put(dc.name, dc2.data);

        //update p
        List<Map<String, List<Node>>> l = new ArrayList<>();
        Map<String, List<Node>> t = new HashMap<>();
        getAllCombinations(new ArrayList<>(curr.map.keySet()), new HashMap<>(curr.map), 0,  t, l);

        curr.possibilities = l;


        //return curr
        dataContext.put(ctx.getParent(), curr.clone());
//        System.out.println("exiting item");
        //System.out.println(dataContext.get(ctx.getParent()).toString());
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitWHERE_CONDITION(ExpressionGrammarParser.WHERE_CONDITIONContext ctx) {
//        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);

        //for map is with all kind of combinations
        Map<String, List<Node>> originalMap = curr.map;
        List<Map<String, List<Node>>> filter = new ArrayList<>();
        List<Map<String, List<Node>>> originalP = curr.possibilities;


        //System.out.println(curr.data);
        for(Map<String, List<Node>> entry : originalP){
            curr.map = entry;
            curr.possibilities = Arrays.asList(entry);
            dataContext.put(ctx, curr);
            DataContext dc = this.visit(ctx.cond());

            if(dc.ok){
                filter.add(entry);
            }
        }
//        System.out.println("Exiting Where_Condition");
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
//        System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);

        dataContext.put(ctx.getParent(), curr);
        return curr;
    }

    @Override
    public DataContext visitReturnClause(ExpressionGrammarParser.ReturnClauseContext ctx) {
        /*
           $x : [x1, x2]
           $Y : [y1, y2]
         */

        //System.out.println("visit " + ctx.getClass().getName());

        DataContext dc = new DataContext(null);
        DataContext curr = pass(ctx);

        Map<String, List<Node>> oldMap = curr.map;
        List<Map<String, List<Node>>> originalP = curr.possibilities;
        Set<Node> result = new HashSet<>();


        for(Map<String, List<Node>> entry : originalP){
            curr.map = entry;
            curr.possibilities = Arrays.asList(entry);
            dataContext.put(ctx, curr);
            DataContext dc2 = this.visit(ctx.xq());
            result.addAll(dc2.data);
        }
        dc.data = new ArrayList<>(result);

//        System.out.println("Exiting: " + ctx.getClass().getName());
        dc.map = oldMap;
        dc.possibilities = originalP;
        //System.out.println(dc.data);
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
        dc.ok = dc.data.size() == 0;
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

        //System.out.println("Exiting Cond EQUAL");
        //System.out.println(curr.toString());
        return curr.clone();
    }

    @Override
    public DataContext visitDocName(ExpressionGrammarParser.DocNameContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());
        DataContext curr = pass(ctx);
        //System.out.println(curr.map);
        //get filename
        DataContext fileName = this.visit(ctx.fileName());

        DOMBuilder dombUilder = new DOMBuilder();
        //create document node
        this.document = dombUilder.getDocument(fileName.name.replaceAll("\"", ""));

        List<Node> result = new ArrayList<>();
        result.add(document);

        //pass datacontext with new Data back to parent
        dataContext.put(ctx.getParent(), new DataContext(result, curr.map));
        return dataContext.get(ctx.getParent());
    }

    @Override
    public DataContext visitVar(ExpressionGrammarParser.VarContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());
        return new DataContext(ctx.NAME().toString());
    }

    @Override
    public DataContext visitNAME_MULTIPLE(ExpressionGrammarParser.NAME_MULTIPLEContext ctx){
        DataContext curr = pass(ctx);

        DataContext dc = this.visit(ctx.namelist());
        curr.name = ctx.NAME() + "," + dc.name;

        return curr;
    }

    @Override
    public DataContext visitNAME_ONE(ExpressionGrammarParser.NAME_ONEContext ctx){
        DataContext curr = pass(ctx);
        curr.name =  ctx.NAME().toString();
        return curr;
    }
    @Override
    public DataContext visitFileName(ExpressionGrammarParser.FileNameContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());
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
            for (Node child = n.getFirstChild(); child != null;
                 child = child.getNextSibling()) {
                getAllNodes(child, result);
            }
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

    private boolean needGoBackByTwoLevel(ExpressionGrammarParser.Rp_PathsymbolContext ctx){
        ParserRuleContext curr = ctx;
        while(curr != null) {
            ParserRuleContext parent = curr.getParent();
            if (parent instanceof ExpressionGrammarParser.Rp_SlashContext) {
                String str = ((ExpressionGrammarParser.Rp_SlashContext) parent).SLASH().toString();
                if (str.equals("//")) {
                    return false;
                } else {
                    return true;
                }

            } else if (parent instanceof ExpressionGrammarParser.XQ_SLASHContext) {
                String str = ((ExpressionGrammarParser.XQ_SLASHContext) parent).SLASH().toString();
                if (str.equals("//")) {
                    return false;
                } else {
                    return true;
                }
            } else {
                curr = parent;
            }
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
        //System.out.println("Entering: " + ctx.getClass().getName());
        //System.out.println(dataContext.get(ctx).toString());
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
