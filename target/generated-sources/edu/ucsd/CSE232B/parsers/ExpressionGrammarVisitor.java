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
	 * Visit a parse tree produced by {@link ExpressionGrammarParser#docName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocName(ExpressionGrammarParser.DocNameContext ctx);
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