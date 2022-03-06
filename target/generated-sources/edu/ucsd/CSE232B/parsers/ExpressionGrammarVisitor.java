// Generated from ExpressionGrammar.g4 by ANTLR 4.7.2

package edu.ucsd.CSE232B.parsers;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpressionGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpressionGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpressionGrammarParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ExpressionGrammarParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(ExpressionGrammarParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Rp_Paren}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_Paren(ExpressionGrammarParser.Rp_ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Rp_Pathsymbol}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_Pathsymbol(ExpressionGrammarParser.Rp_PathsymbolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Rp_Filter}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_Filter(ExpressionGrammarParser.Rp_FilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Rp_Slash}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_Slash(ExpressionGrammarParser.Rp_SlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Rp_TagName}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_TagName(ExpressionGrammarParser.Rp_TagNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Rp_AttName}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_AttName(ExpressionGrammarParser.Rp_AttNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Rp_Text}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_Text(ExpressionGrammarParser.Rp_TextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Rp_Comma}
	 * labeled alternative in {@link ExpressionGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp_Comma(ExpressionGrammarParser.Rp_CommaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionGrammarParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(ExpressionGrammarParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionGrammarParser#attName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(ExpressionGrammarParser.AttNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Filter_Or}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter_Or(ExpressionGrammarParser.Filter_OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Filter_And}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter_And(ExpressionGrammarParser.Filter_AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Filter_Not}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter_Not(ExpressionGrammarParser.Filter_NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Filter_Eq}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter_Eq(ExpressionGrammarParser.Filter_EqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Filter_SpecEq}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter_SpecEq(ExpressionGrammarParser.Filter_SpecEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Filter_Rp}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter_Rp(ExpressionGrammarParser.Filter_RpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Filter_Paren}
	 * labeled alternative in {@link ExpressionGrammarParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter_Paren(ExpressionGrammarParser.Filter_ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XQ_PR}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXQ_PR(ExpressionGrammarParser.XQ_PRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XQ_TAGNAME}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXQ_TAGNAME(ExpressionGrammarParser.XQ_TAGNAMEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XQ_SLASH}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXQ_SLASH(ExpressionGrammarParser.XQ_SLASHContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XQ_LET}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXQ_LET(ExpressionGrammarParser.XQ_LETContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XQ_STRING}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXQ_STRING(ExpressionGrammarParser.XQ_STRINGContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XQ_JOIN}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXQ_JOIN(ExpressionGrammarParser.XQ_JOINContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XQ_EXP}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXQ_EXP(ExpressionGrammarParser.XQ_EXPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XQ_VAR}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXQ_VAR(ExpressionGrammarParser.XQ_VARContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XQ_COMMA}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXQ_COMMA(ExpressionGrammarParser.XQ_COMMAContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XQ_FOR}
	 * labeled alternative in {@link ExpressionGrammarParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXQ_FOR(ExpressionGrammarParser.XQ_FORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NAME_MULTIPLE}
	 * labeled alternative in {@link ExpressionGrammarParser#namelist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNAME_MULTIPLE(ExpressionGrammarParser.NAME_MULTIPLEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NAME_ONE}
	 * labeled alternative in {@link ExpressionGrammarParser#namelist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNAME_ONE(ExpressionGrammarParser.NAME_ONEContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionGrammarParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(ExpressionGrammarParser.ForClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ITEM_MULTIPLE}
	 * labeled alternative in {@link ExpressionGrammarParser#items}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitITEM_MULTIPLE(ExpressionGrammarParser.ITEM_MULTIPLEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ITEM_ONE}
	 * labeled alternative in {@link ExpressionGrammarParser#items}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitITEM_ONE(ExpressionGrammarParser.ITEM_ONEContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionGrammarParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(ExpressionGrammarParser.ItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LET_DEF}
	 * labeled alternative in {@link ExpressionGrammarParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLET_DEF(ExpressionGrammarParser.LET_DEFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LET_NONE}
	 * labeled alternative in {@link ExpressionGrammarParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLET_NONE(ExpressionGrammarParser.LET_NONEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DEF_MUTIPLE}
	 * labeled alternative in {@link ExpressionGrammarParser#definitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDEF_MUTIPLE(ExpressionGrammarParser.DEF_MUTIPLEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DEF_ONE}
	 * labeled alternative in {@link ExpressionGrammarParser#definitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDEF_ONE(ExpressionGrammarParser.DEF_ONEContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionGrammarParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(ExpressionGrammarParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WHERE_CONDITION}
	 * labeled alternative in {@link ExpressionGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWHERE_CONDITION(ExpressionGrammarParser.WHERE_CONDITIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WHERE_NONE}
	 * labeled alternative in {@link ExpressionGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWHERE_NONE(ExpressionGrammarParser.WHERE_NONEContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionGrammarParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(ExpressionGrammarParser.ReturnClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code COND_SPEQUAL}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCOND_SPEQUAL(ExpressionGrammarParser.COND_SPEQUALContext ctx);
	/**
	 * Visit a parse tree produced by the {@code COND_PR}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCOND_PR(ExpressionGrammarParser.COND_PRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code COND_AND}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCOND_AND(ExpressionGrammarParser.COND_ANDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code COND_EMPTY}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCOND_EMPTY(ExpressionGrammarParser.COND_EMPTYContext ctx);
	/**
	 * Visit a parse tree produced by the {@code COND_SATISFY}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCOND_SATISFY(ExpressionGrammarParser.COND_SATISFYContext ctx);
	/**
	 * Visit a parse tree produced by the {@code COND_NEGATE}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCOND_NEGATE(ExpressionGrammarParser.COND_NEGATEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code COND_OR}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCOND_OR(ExpressionGrammarParser.COND_ORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code COND_EQUAL}
	 * labeled alternative in {@link ExpressionGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCOND_EQUAL(ExpressionGrammarParser.COND_EQUALContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionGrammarParser#docName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocName(ExpressionGrammarParser.DocNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionGrammarParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(ExpressionGrammarParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionGrammarParser#fileName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileName(ExpressionGrammarParser.FileNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionGrammarParser#stringConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConst(ExpressionGrammarParser.StringConstContext ctx);
}