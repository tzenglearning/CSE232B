package visitor;

import java.util.ArrayList;
import java.util.List;

import edu.ucsd.CSE232B.parsers.ExpressionGrammarBaseVisitor;
import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser.ExpContext;
import edu.ucsd.CSE232B.parsers.ExpressionGrammarParser.ProgContext;
import expression.DataContext;

public class ProgramBuilder extends ExpressionGrammarBaseVisitor<DataContext>{
    @Override
    public DataContext visitProg(ProgContext ctx){
        final ExpressionBuilder expressionBuilder = new ExpressionBuilder();
        final DataContext dataContext = expressionBuilder.visit(ctx.xq(0));

        return dataContext;
    }
}
