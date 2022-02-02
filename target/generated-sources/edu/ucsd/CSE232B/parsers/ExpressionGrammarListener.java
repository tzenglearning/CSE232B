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