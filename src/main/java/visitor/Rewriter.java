package visitor;

import DOMBuilder.DOMBuilder;
import com.sun.jdi.event.StepEvent;
import edu.ucsd.CSE232B.parsers.ExpressionGrammarBaseVisitor;
import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser;
import expression.DataContext;
import org.antlr.v4.runtime.ParserRuleContext;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.*;

public class Rewriter extends ExpressionGrammarBaseVisitor<String> {

    Map<String, List<String>> map;
    Map<String, String> kv;
    Map<String, List<String>> whereMap;
    Map<String, List<String>> whereEqStringConstantMap;
    String returnSyntax;
    boolean result;
    Map<Integer, List<String>> group;
    int cnt;
    List<String> parent;
    Map<String, Integer> inDegree;
    Map<Integer, Set<Integer>> link;
    Map<String, Integer> from;

    public Rewriter(){
        this.map = new HashMap<>();
        this.kv = new HashMap<>();
        this.whereMap = new HashMap<>();
        this.whereEqStringConstantMap = new HashMap<>();
        this.returnSyntax = null;
        this.result = true;
        this.group = new HashMap<>();
        this.cnt = 0;
        this.parent = new ArrayList<>();
        this.inDegree = new HashMap<>();
        this.link = new HashMap<>();
        this.from = new HashMap<>();
    }
    @Override
    public String visitProg(ExpressionGrammarParser.ProgContext ctx) {
//        System.out.println("visit " + ctx.getClass().getName());
        String res = null;
        if(ctx.xq() == null){
            res= this.visit(ctx.exp(0));
        }else{
            res = this.visit(ctx.xq(0));
        }
//        System.out.println(map);
//        System.out.println(kv);
//        System.out.println(returnSyntax);
//        System.out.println(whereMap);
//        System.out.println(result);

        int num = getNumOfGraphComponents();
        if(num > 1){
            return generateJoinSyntax();
        }else{
            return res;
        }


    }

    @Override
    public String visitExp(ExpressionGrammarParser.ExpContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());

        String docName = this.visit(ctx.docName());
        String rp = this.visit(ctx.rp());
        return docName + ctx.SLASH().toString() + rp;
    }

    @Override
    public String visitRp_Paren(ExpressionGrammarParser.Rp_ParenContext ctx) {
        return "(" + this.visit(ctx.rp()) + ")";
    }

    @Override
    public String visitRp_Pathsymbol(ExpressionGrammarParser.Rp_PathsymbolContext ctx) {
        return ctx.PATH_SYMBOL().toString();
    }

    @Override
    public String visitRp_Slash(ExpressionGrammarParser.Rp_SlashContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());
        return this.visit(ctx.rp(0)) + ctx.SLASH().toString() + this.visit(ctx.rp(1));
    }

    @Override
    public String visitRp_TagName(ExpressionGrammarParser.Rp_TagNameContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());
        return this.visit(ctx.tagName());
    }

    //    public T visitRp_AttName(ExpressionGrammarParser.Rp_AttNameContext ctx) {
//        return this.visitChildren(ctx);
//    }
//
    @Override
    public String visitRp_Text(ExpressionGrammarParser.Rp_TextContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());
        return "text()";
    }

    @Override
    public String visitRp_Comma(ExpressionGrammarParser.Rp_CommaContext ctx) {
        return this.visit(ctx.rp(0)) + ", " + this.visit(ctx.rp(1));
    }

    @Override
    public String visitTagName(ExpressionGrammarParser.TagNameContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());
        return ctx.NAME().toString();
    }

    //    public T visitAttName(ExpressionGrammarParser.AttNameContext ctx) {
//        return this.visitChildren(ctx);
//    }
//

    @Override
    public String visitXQ_PR(ExpressionGrammarParser.XQ_PRContext ctx) {
        return "(" + this.visit(ctx.xq()) + ")";
    }

    @Override
    public String visitXQ_TAGNAME(ExpressionGrammarParser.XQ_TAGNAMEContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());
        String tagName = this.visit(ctx.tagName(0));
        String xq = this.visit(ctx.xq());

        //insert the node before list of node in xq
        return "<" + tagName + ">" + "{" + xq + "}" + "</" + tagName + ">" ;
    }
    //
    @Override
    public String visitXQ_SLASH(ExpressionGrammarParser.XQ_SLASHContext ctx) {
        //System.out.println("Visiting " + ctx.getClass().getName());
        String xq = this.visit(ctx.xq());
        String rp = this.visit(ctx.rp());
        return xq + ctx.SLASH().toString() + rp;


    }

    @Override
    public String visitXQ_JOIN(ExpressionGrammarParser.XQ_JOINContext ctx){
        return "join( " + this.visit(ctx.xq(0))
                + ","  + this.visit(ctx.xq(1))
                + "[" + ctx.namelist(0) + "] , [" + ctx.namelist(1) + "]) ";
    }

    @Override
    public String visitNAME_MULTIPLE(ExpressionGrammarParser.NAME_MULTIPLEContext ctx){
       return ctx.NAME().toString() + "," + this.visit(ctx.namelist());
    }

    @Override
    public String visitNAME_ONE(ExpressionGrammarParser.NAME_ONEContext ctx){
        return ctx.NAME().toString();
    }

    @Override
    public String visitXQ_STRING(ExpressionGrammarParser.XQ_STRINGContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());
        return this.visit(ctx.stringConst());
    }

    @Override
    public String visitXQ_EXP(ExpressionGrammarParser.XQ_EXPContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());
        return this.visit(ctx.exp());
    }

    @Override
    public String visitXQ_VAR(ExpressionGrammarParser.XQ_VARContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());
        return this.visit(ctx.var());
    }

    @Override
    public String visitXQ_COMMA(ExpressionGrammarParser.XQ_COMMAContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());
        String xq = this.visit(ctx.xq(0));
        String xq2 = this.visit(ctx.xq(1));
        return xq + "," + xq2;
    }


    @Override
    public String visitXQ_FOR(ExpressionGrammarParser.XQ_FORContext ctx) {
        return this.visit(ctx.forClause()) +  this.visit(ctx.whereClause())  + this.visit(ctx.returnClause());
    }

    @Override
    public String visitForClause(ExpressionGrammarParser.ForClauseContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());

        //build map during visit items
        return "for " + this.visit(ctx.items()) + "\n";
    }

    @Override
    public String visitITEM_MULTIPLE(ExpressionGrammarParser.ITEM_MULTIPLEContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());

        return this.visit(ctx.item()) + ", \n" + this.visit(ctx.items());
    }

    @Override
    public String visitITEM_ONE(ExpressionGrammarParser.ITEM_ONEContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());
        return this.visit(ctx.item());
    }

    @Override
    public String visitItem(ExpressionGrammarParser.ItemContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());


        String varName = this.visit(ctx.var());
        String xq = this.visit(ctx.xq());
        if(varName == null){
            System.out.println(varName);
        }

        if(xq == null) {
            System.out.println(varName);
        }

        String name = getVarName(varName);
        String name2 = getVarName(xq);
        if(!xq.substring(0,3).equals("doc")){
            //update map
            map.computeIfAbsent(name2, k -> new ArrayList<>()).add(name);
        }


        //update kv
        kv.put(name, varName + " in " + xq);
        return varName + " in " + xq;
    }

    @Override
    public String visitWHERE_CONDITION(ExpressionGrammarParser.WHERE_CONDITIONContext ctx) {
        return "where " + this.visit(ctx.cond()) + "\n";
    }

    @Override
    public String visitWHERE_NONE(ExpressionGrammarParser.WHERE_NONEContext ctx) {
        return "";
    }

    @Override
    public String visitReturnClause(ExpressionGrammarParser.ReturnClauseContext ctx) {
        /*
           $x : [x1, x2]
           $Y : [y1, y2]
         */

        //System.out.println("visit " + ctx.getClass().getName());

        returnSyntax = this.visit(ctx.xq());

        return "return " + returnSyntax + "\n";
    }

    @Override
    public String visitCOND_AND(ExpressionGrammarParser.COND_ANDContext ctx) {

        return this.visit(ctx.cond(0)) + " and " + this.visit(ctx.cond(1));
    }


    @Override
    public String visitCOND_EQUAL(ExpressionGrammarParser.COND_EQUALContext ctx) {
        String xq = this.visit(ctx.xq(0));
        String xq2 = this.visit(ctx.xq(1));

        boolean xqString = ctx.xq(0) instanceof ExpressionGrammarParser.XQ_STRINGContext;
        boolean xqString2 = ctx.xq(1) instanceof ExpressionGrammarParser.XQ_STRINGContext;

        if(xqString  && xqString2){
            //how does it affect the result
            result = result & (xq.equals(xq2));
        }else if(xqString){
            whereEqStringConstantMap.computeIfAbsent(getVarName(xq2),k -> new ArrayList<>()).add(xq);
        }else if(xqString2){
            whereEqStringConstantMap.computeIfAbsent(getVarName(xq),k -> new ArrayList<>()).add(xq2);
        }else{
            String name = getVarName(xq);
            String name2 = getVarName(xq2);
            whereMap.computeIfAbsent(name,k -> new ArrayList<>()).add(name2);
            whereMap.computeIfAbsent(name2,k -> new ArrayList<>()).add(name);
        }

        return xq + " eq " + xq2;
    }

    public String getVarName(String path){
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while(i < path.length() && path.charAt(i) != '/'){
            sb.append(path.charAt(i++));
        }

        return sb.toString();
    }

    @Override
    public String visitDocName(ExpressionGrammarParser.DocNameContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());
        //get filename
        String name = this.visit(ctx.fileName());

        return "doc(" + name + ")";
    }

    @Override
    public String visitVar(ExpressionGrammarParser.VarContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());
        return "$" + ctx.NAME().toString();
    }

    @Override
    public String visitFileName(ExpressionGrammarParser.FileNameContext ctx) {
        //System.out.println("visit " + ctx.getClass().getName());
        return ctx.STRING().toString();
    }

    @Override
    public String visitStringConst(ExpressionGrammarParser.StringConstContext ctx) {
        return ctx.STRING().toString();
    }

    public int getNumOfGraphComponents(){
        parent = getParentNode();

        Set<String> visited = new HashSet<>();
        for(String n : parent){
            if(!visited.contains(n)) {
                dfs(n, visited);
                cnt++;
            }
        }
        return parent.size();
    }

    public List<String> getParentNode(){
        List<String> result = new ArrayList<>();
        Set<String> keySet = map.keySet();

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            for(String n : entry.getValue()){
                inDegree.put(n, inDegree.getOrDefault(n, 0) + 1);
            }
        }

        for(String key : keySet){
            if(!inDegree.containsKey(key)){
                result.add(key);
            }
        }
        return result;

    }

    public void dfs(String node, Set<String> visited){
        visited.add(node);
        if (!group.containsKey(cnt)){
            group.put(cnt, new ArrayList<>());
        }
        group.get(cnt).add(node);

         if(!map.containsKey(node)){
             return;
         }
         for(String n : map.get(node)){
             if(visited.contains(n)) continue;
             dfs(n, visited);
         }

         return;
    }

    public String generateJoinSyntax(){
        List<Integer> keys = new ArrayList<>(group.keySet());
        StringBuilder sb = new StringBuilder();
        Set<String> preSet = new HashSet<>();
        List<String> nodes = group.get(0);
        for(String n : nodes){
            preSet.add(n);
        }

        for(int i = 0; i < cnt; i++){
            for(String node : group.get(i)){
                from.put(node, i);
            }
        }

        for(int i = 0; i < cnt; i++){
            for(String node : group.get(i)){
                if(!whereMap.containsKey(node)) continue;
                for(String neighbor : whereMap.get(node)){
                    link.computeIfAbsent(i, k-> new HashSet<>()).add(from.get(neighbor));
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        sb.append(forLoop(0));
        visited.add(0);
        construct(0, visited, preSet, sb);

        /*
           start from forloop 0
           [] data structures to hold variables of forloops
           [] <- variables in 0
           choose one forloop that is connected by a var in var[] and not visited
           join both
           append var[]
         */
//        String pre = "join( " + forLoop(0) + ", \n" + forLoop(1) + ",\n" + getWhereClause(1, preSet) + ")";
//        if(cnt == 2){
//            sb.append(pre);
//            sb.append("\n");
//        }
//
//        for(int i= 2 ; i < group.size(); i++) {
//            pre = "join( " + pre + ",\n" + forLoop(i) + ",\n" + getWhereClause(i, preSet) + ")";
//            if(i == group.size() - 1){
//                sb.append(pre);
//                sb.append("\n");
//            }
//        }
        sb.insert(0, "for $tuple in ");
        sb.append(getFinalReturnSyntax());
        return sb.toString();
    }

    public String forLoop(int num){
        StringBuilder sb = new StringBuilder();
        sb.append("for ");
        Set<String> node = new HashSet<>(group.get(num));

        String groupParent = null;
        for(String n : parent){
            if(node.contains(n)){
                groupParent = n;
            }
        }

        Deque<String> q = new ArrayDeque<>();
        q.offerLast(groupParent);

        List<String> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();
        List<String> keys2 = new ArrayList<>();
        List<String> values2 = new ArrayList<>();


        while(!q.isEmpty()){
            String n = q.pollFirst();
            if(whereEqStringConstantMap.containsKey(n)){
                for(String value : whereEqStringConstantMap.get(n)){
                    keys.add(n);
                    values.add(value);
                }
            }
            if(whereMap.containsKey(n)){
                for(String value: whereMap.get(n)){
                    if(from.get(value) == num) {
                        keys2.add(n);
                        values2.add(value);
                    }
                }
            }

            sb.append(kv.get(n));
            sb.append(",\n");
            if(!map.containsKey(n)) continue;
            for(String children : map.get(n)){
                q.offerLast(children);
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("\n");

        if(keys.size() != 0 && values.size() != 0 || keys2.size() != 0 && values2.size() != 0) sb.append("where ");
        if(keys.size() != 0 && values.size() != 0){

            for(int i = 0; i < keys.size(); i++){
                sb.append("$" + keys.get(i) + " eq " + values.get(i) + "\n");
                if(i != keys.size() - 1 || i == keys.size() - 1 && keys2.size() != 0 && values2.size() != 0){
                    sb.append("and ");
                }
            }
        }

        if(keys2.size() != 0 && values2.size() != 0){
            for(int i = 0; i < keys2.size(); i++){
                sb.append("$" + keys2.get(i) + " eq " + "$" + values2.get(i) + "\n");
                if(i != keys2.size() - 1){
                    sb.append("and ");
                }
            }
        }




        sb.append(getReturnClause(num));
        return sb.toString();
    }

    public void construct(int i, Set<Integer> visited, Set<String> preSet, StringBuilder sb){
        for(int neighbor : link.get(i)){
            if(!visited.contains(neighbor)) {
                visited.add(neighbor);
                sb.insert(0, "join( ");
                sb.append(",\n" + forLoop(neighbor) + ",\n" + getWhereClause(neighbor, preSet)+ ")");
                construct(neighbor, visited, preSet, sb);
            }
        }
    }

    public String getWhereClause(int curr, Set<String> preSet){
        List<String> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();

        Set<String> set = new HashSet(group.get(curr));
        for(String n : set){
            if(whereMap.containsKey(n)){
                for(String value: whereMap.get(n)){
                        if (preSet.contains(value)) {
                            keys.add(value);
                            values.add(n);
                        }
                }

            }
        }

        preSet.addAll(set);

        return keys.toString() + ", " + values.toString();
    }

    public String getReturnClause(int curr){
        StringBuilder sb = new StringBuilder();
        sb.append("return <tuple>{\n");
        List<String> list = group.get(curr);
        for(int i = 0; i < list.size(); i++){
            String n = list.get(i);
            sb.append("<" + n + ">{$" + n + "}" + "</" + n + ">");
            if(i != list.size() - 1) sb.append(",");
            sb.append("\n");

        }
        sb.append("}</tuple>");
        return sb.toString();
    }

    public String getFinalReturnSyntax(){
        //find all variable name and replace them with $ tuple/ varName /*
        for(List<String> name : group.values()){
            for(String n : name) {
                //{$var => $tuple/n/*
                String d  = "{$" + n;
                if(returnSyntax.contains(d)){
                    returnSyntax = returnSyntax.replaceAll("\\{\\$" + n, "\\{\\$tuple/" + n + "/*");
                }
            }
        }
        return "\nreturn " + returnSyntax;
    }
}
