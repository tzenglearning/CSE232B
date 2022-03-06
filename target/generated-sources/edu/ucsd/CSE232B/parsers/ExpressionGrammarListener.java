// Generated from ExpressionGrammar.g4 by ANTLR 4.7.2

package edu.ucsd.CSE232B.parsers;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionGrammarParser}.
 */
public interface ExpressionGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpressionGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExpressionGrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExpressionGrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionGrammarParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(ExpressionGrammarParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionGrammarParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(ExpressionGrammarParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Rp_Paren}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_Paren(ExpressionGrammarParser.Rp_ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Rp_Paren}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_Paren(ExpressionGrammarParser.Rp_ParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Rp_Pathsymbol}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_Pathsymbol(ExpressionGrammarParser.Rp_PathsymbolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Rp_Pathsymbol}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_Pathsymbol(ExpressionGrammarParser.Rp_PathsymbolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Rp_Filter}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_Filter(ExpressionGrammarParser.Rp_FilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Rp_Filter}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_Filter(ExpressionGrammarParser.Rp_FilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Rp_Slash}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_Slash(ExpressionGrammarParser.Rp_SlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Rp_Slash}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_Slash(ExpressionGrammarParser.Rp_SlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Rp_TagName}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_TagName(ExpressionGrammarParser.Rp_TagNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Rp_TagName}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_TagName(ExpressionGrammarParser.Rp_TagNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Rp_AttName}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_AttName(ExpressionGrammarParser.Rp_AttNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Rp_AttName}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_AttName(ExpressionGrammarParser.Rp_AttNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Rp_Text}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_Text(ExpressionGrammarParser.Rp_TextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Rp_Text}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_Text(ExpressionGrammarParser.Rp_TextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Rp_Comma}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp_Comma(ExpressionGrammarParser.Rp_CommaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Rp_Comma}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp_Comma(ExpressionGrammarParser.Rp_CommaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionGrammarParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(ExpressionGrammarParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionGrammarParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(ExpressionGrammarParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionGrammarParser#attName}.
	 * @param ctx the parse tree
	 */
	void enterAttName(ExpressionGrammarParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionGrammarParser#attName}.
	 * @param ctx the parse tree
	 */
	void exitAttName(ExpressionGrammarParser.AttNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Filter_Or}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilter_Or(ExpressionGrammarParser.Filter_OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Filter_Or}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilter_Or(ExpressionGrammarParser.Filter_OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Filter_And}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilter_And(ExpressionGrammarParser.Filter_AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Filter_And}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilter_And(ExpressionGrammarParser.Filter_AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Filter_Not}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilter_Not(ExpressionGrammarParser.Filter_NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Filter_Not}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilter_Not(ExpressionGrammarParser.Filter_NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Filter_Eq}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilter_Eq(ExpressionGrammarParser.Filter_EqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Filter_Eq}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilter_Eq(ExpressionGrammarParser.Filter_EqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Filter_SpecEq}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilter_SpecEq(ExpressionGrammarParser.Filter_SpecEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Filter_SpecEq}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilter_SpecEq(ExpressionGrammarParser.Filter_SpecEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Filter_Rp}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilter_Rp(ExpressionGrammarParser.Filter_RpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Filter_Rp}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilter_Rp(ExpressionGrammarParser.Filter_RpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Filter_Paren}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilter_Paren(ExpressionGrammarParser.Filter_ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Filter_Paren}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilter_Paren(ExpressionGrammarParser.Filter_ParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQ_PR}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQ_PR(ExpressionGrammarParser.XQ_PRContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQ_PR}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQ_PR(ExpressionGrammarParser.XQ_PRContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQ_TAGNAME}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQ_TAGNAME(ExpressionGrammarParser.XQ_TAGNAMEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQ_TAGNAME}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQ_TAGNAME(ExpressionGrammarParser.XQ_TAGNAMEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQ_SLASH}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQ_SLASH(ExpressionGrammarParser.XQ_SLASHContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQ_SLASH}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQ_SLASH(ExpressionGrammarParser.XQ_SLASHContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQ_LET}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQ_LET(ExpressionGrammarParser.XQ_LETContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQ_LET}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQ_LET(ExpressionGrammarParser.XQ_LETContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQ_STRING}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQ_STRING(ExpressionGrammarParser.XQ_STRINGContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQ_STRING}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQ_STRING(ExpressionGrammarParser.XQ_STRINGContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQ_JOIN}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQ_JOIN(ExpressionGrammarParser.XQ_JOINContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQ_JOIN}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQ_JOIN(ExpressionGrammarParser.XQ_JOINContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQ_EXP}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQ_EXP(ExpressionGrammarParser.XQ_EXPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQ_EXP}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQ_EXP(ExpressionGrammarParser.XQ_EXPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQ_VAR}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQ_VAR(ExpressionGrammarParser.XQ_VARContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQ_VAR}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQ_VAR(ExpressionGrammarParser.XQ_VARContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQ_COMMA}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQ_COMMA(ExpressionGrammarParser.XQ_COMMAContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQ_COMMA}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQ_COMMA(ExpressionGrammarParser.XQ_COMMAContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XQ_FOR}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXQ_FOR(ExpressionGrammarParser.XQ_FORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XQ_FOR}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXQ_FOR(ExpressionGrammarParser.XQ_FORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NAME_MULTIPLE}
	 * labeled alternative in {@link ExpressionGrammarParser#namelist}.
	 * @param ctx the parse tree
	 */
	void enterNAME_MULTIPLE(ExpressionGrammarParser.NAME_MULTIPLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NAME_MULTIPLE}
	 * labeled alternative in {@link ExpressionGrammarParser#namelist}.
	 * @param ctx the parse tree
	 */
	void exitNAME_MULTIPLE(ExpressionGrammarParser.NAME_MULTIPLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NAME_ONE}
	 * labeled alternative in {@link ExpressionGrammarParser#namelist}.
	 * @param ctx the parse tree
	 */
	void enterNAME_ONE(ExpressionGrammarParser.NAME_ONEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NAME_ONE}
	 * labeled alternative in {@link ExpressionGrammarParser#namelist}.
	 * @param ctx the parse tree
	 */
	void exitNAME_ONE(ExpressionGrammarParser.NAME_ONEContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionGrammarParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(ExpressionGrammarParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionGrammarParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(ExpressionGrammarParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ITEM_MULTIPLE}
	 * labeled alternative in {@link ExpressionGrammarParser#items}.
	 * @param ctx the parse tree
	 */
	void enterITEM_MULTIPLE(ExpressionGrammarParser.ITEM_MULTIPLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ITEM_MULTIPLE}
	 * labeled alternative in {@link ExpressionGrammarParser#items}.
	 * @param ctx the parse tree
	 */
	void exitITEM_MULTIPLE(ExpressionGrammarParser.ITEM_MULTIPLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ITEM_ONE}
	 * labeled alternative in {@link ExpressionGrammarParser#items}.
	 * @param ctx the parse tree
	 */
	void enterITEM_ONE(ExpressionGrammarParser.ITEM_ONEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ITEM_ONE}
	 * labeled alternative in {@link ExpressionGrammarParser#items}.
	 * @param ctx the parse tree
	 */
	void exitITEM_ONE(ExpressionGrammarParser.ITEM_ONEContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionGrammarParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(ExpressionGrammarParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionGrammarParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(ExpressionGrammarParser.ItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LET_DEF}
	 * labeled alternative in {@link ExpressionGrammarParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLET_DEF(ExpressionGrammarParser.LET_DEFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LET_DEF}
	 * labeled alternative in {@link ExpressionGrammarParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLET_DEF(ExpressionGrammarParser.LET_DEFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LET_NONE}
	 * labeled alternative in {@link ExpressionGrammarParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLET_NONE(ExpressionGrammarParser.LET_NONEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LET_NONE}
	 * labeled alternative in {@link ExpressionGrammarParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLET_NONE(ExpressionGrammarParser.LET_NONEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DEF_MUTIPLE}
	 * labeled alternative in {@link ExpressionGrammarParser#definitions}.
	 * @param ctx the parse tree
	 */
	void enterDEF_MUTIPLE(ExpressionGrammarParser.DEF_MUTIPLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DEF_MUTIPLE}
	 * labeled alternative in {@link ExpressionGrammarParser#definitions}.
	 * @param ctx the parse tree
	 */
	void exitDEF_MUTIPLE(ExpressionGrammarParser.DEF_MUTIPLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DEF_ONE}
	 * labeled alternative in {@link ExpressionGrammarParser#definitions}.
	 * @param ctx the parse tree
	 */
	void enterDEF_ONE(ExpressionGrammarParser.DEF_ONEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DEF_ONE}
	 * labeled alternative in {@link ExpressionGrammarParser#definitions}.
	 * @param ctx the parse tree
	 */
	void exitDEF_ONE(ExpressionGrammarParser.DEF_ONEContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionGrammarParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(ExpressionGrammarParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionGrammarParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(ExpressionGrammarParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WHERE_CONDITION}
	 * labeled alternative in {@link ExpressionGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWHERE_CONDITION(ExpressionGrammarParser.WHERE_CONDITIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WHERE_CONDITION}
	 * labeled alternative in {@link ExpressionGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWHERE_CONDITION(ExpressionGrammarParser.WHERE_CONDITIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WHERE_NONE}
	 * labeled alternative in {@link ExpressionGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWHERE_NONE(ExpressionGrammarParser.WHERE_NONEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WHERE_NONE}
	 * labeled alternative in {@link ExpressionGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWHERE_NONE(ExpressionGrammarParser.WHERE_NONEContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionGrammarParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(ExpressionGrammarParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionGrammarParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(ExpressionGrammarParser.ReturnClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code COND_SPEQUAL}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCOND_SPEQUAL(ExpressionGrammarParser.COND_SPEQUALContext ctx);
	/**
	 * Exit a parse tree produced by the {@code COND_SPEQUAL}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCOND_SPEQUAL(ExpressionGrammarParser.COND_SPEQUALContext ctx);
	/**
	 * Enter a parse tree produced by the {@code COND_PR}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCOND_PR(ExpressionGrammarParser.COND_PRContext ctx);
	/**
	 * Exit a parse tree produced by the {@code COND_PR}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCOND_PR(ExpressionGrammarParser.COND_PRContext ctx);
	/**
	 * Enter a parse tree produced by the {@code COND_AND}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCOND_AND(ExpressionGrammarParser.COND_ANDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code COND_AND}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCOND_AND(ExpressionGrammarParser.COND_ANDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code COND_EMPTY}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCOND_EMPTY(ExpressionGrammarParser.COND_EMPTYContext ctx);
	/**
	 * Exit a parse tree produced by the {@code COND_EMPTY}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCOND_EMPTY(ExpressionGrammarParser.COND_EMPTYContext ctx);
	/**
	 * Enter a parse tree produced by the {@code COND_SATISFY}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCOND_SATISFY(ExpressionGrammarParser.COND_SATISFYContext ctx);
	/**
	 * Exit a parse tree produced by the {@code COND_SATISFY}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCOND_SATISFY(ExpressionGrammarParser.COND_SATISFYContext ctx);
	/**
	 * Enter a parse tree produced by the {@code COND_NEGATE}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCOND_NEGATE(ExpressionGrammarParser.COND_NEGATEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code COND_NEGATE}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCOND_NEGATE(ExpressionGrammarParser.COND_NEGATEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code COND_OR}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCOND_OR(ExpressionGrammarParser.COND_ORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code COND_OR}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCOND_OR(ExpressionGrammarParser.COND_ORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code COND_EQUAL}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCOND_EQUAL(ExpressionGrammarParser.COND_EQUALContext ctx);
	/**
	 * Exit a parse tree produced by the {@code COND_EQUAL}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCOND_EQUAL(ExpressionGrammarParser.COND_EQUALContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionGrammarParser#docName}.
	 * @param ctx the parse tree
	 */
	void enterDocName(ExpressionGrammarParser.DocNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionGrammarParser#docName}.
	 * @param ctx the parse tree
	 */
	void exitDocName(ExpressionGrammarParser.DocNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionGrammarParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(ExpressionGrammarParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionGrammarParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(ExpressionGrammarParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionGrammarParser#fileName}.
	 * @param ctx the parse tree
	 */
	void enterFileName(ExpressionGrammarParser.FileNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionGrammarParser#fileName}.
	 * @param ctx the parse tree
	 */
	void exitFileName(ExpressionGrammarParser.FileNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionGrammarParser#stringConst}.
	 * @param ctx the parse tree
	 */
	void enterStringConst(ExpressionGrammarParser.StringConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionGrammarParser#stringConst}.
	 * @param ctx the parse tree
	 */
	void exitStringConst(ExpressionGrammarParser.StringConstContext ctx);
}