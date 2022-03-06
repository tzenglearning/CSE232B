// Generated from ExpressionGrammar.g4 by ANTLR 4.7.2

package edu.ucsd.CSE232B.parsers;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STRING=1, ESCAPE=2, DOC=3, DOCUMENT=4, DOLLAR=5, AT=6, SLASH=7, SPEC_EQUAL=8, 
		EQUAL=9, TEXT_FUNC=10, PATH_SYMBOL=11, AND=12, OR=13, NEGATE=14, LPR=15, 
		RPR=16, LAB=17, RAB=18, LCB=19, RCB=20, LSQ=21, RSQ=22, QUOTE=23, COMMA=24, 
		FOR=25, IN=26, LET=27, DEFINEEQ=28, WHERE=29, RETURN=30, EMPTY=31, SOME=32, 
		SATISFIES=33, JOIN=34, NAME=35, WS=36;
	public static final int
		RULE_prog = 0, RULE_exp = 1, RULE_rp = 2, RULE_tagName = 3, RULE_attName = 4, 
		RULE_filter = 5, RULE_xq = 6, RULE_namelist = 7, RULE_forClause = 8, RULE_items = 9, 
		RULE_item = 10, RULE_letClause = 11, RULE_definitions = 12, RULE_definition = 13, 
		RULE_whereClause = 14, RULE_returnClause = 15, RULE_cond = 16, RULE_docName = 17, 
		RULE_var = 18, RULE_fileName = 19, RULE_stringConst = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "exp", "rp", "tagName", "attName", "filter", "xq", "namelist", 
			"forClause", "items", "item", "letClause", "definitions", "definition", 
			"whereClause", "returnClause", "cond", "docName", "var", "fileName", 
			"stringConst"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'document'", "'$'", "'@'", null, null, null, 
			"'text'", null, "'and'", "'or'", "'not'", "'('", "')'", "'<'", "'>'", 
			"'{'", "'}'", "'['", "']'", "'\"'", "','", "'for'", "'in'", "'let'", 
			"':='", "'where'", "'return'", "'empty'", "'some'", "'satisfies'", "'join'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "STRING", "ESCAPE", "DOC", "DOCUMENT", "DOLLAR", "AT", "SLASH", 
			"SPEC_EQUAL", "EQUAL", "TEXT_FUNC", "PATH_SYMBOL", "AND", "OR", "NEGATE", 
			"LPR", "RPR", "LAB", "RAB", "LCB", "RCB", "LSQ", "RSQ", "QUOTE", "COMMA", 
			"FOR", "IN", "LET", "DEFINEEQ", "WHERE", "RETURN", "EMPTY", "SOME", "SATISFIES", 
			"JOIN", "NAME", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ExpressionGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExpressionGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ExpressionGrammarParser.EOF, 0); }
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(44);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(42);
					xq(0);
					}
					break;
				case 2:
					{
					setState(43);
					exp();
					}
					break;
				}
				}
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << DOC) | (1L << DOCUMENT) | (1L << DOLLAR) | (1L << LPR) | (1L << LAB) | (1L << FOR) | (1L << LET) | (1L << JOIN))) != 0) );
			setState(48);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public DocNameContext docName() {
			return getRuleContext(DocNameContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(ExpressionGrammarParser.SLASH, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			docName();
			setState(51);
			match(SLASH);
			setState(52);
			rp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RpContext extends ParserRuleContext {
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
	 
		public RpContext() { }
		public void copyFrom(RpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Rp_ParenContext extends RpContext {
		public TerminalNode LPR() { return getToken(ExpressionGrammarParser.LPR, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode RPR() { return getToken(ExpressionGrammarParser.RPR, 0); }
		public Rp_ParenContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterRp_Paren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitRp_Paren(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitRp_Paren(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_PathsymbolContext extends RpContext {
		public TerminalNode PATH_SYMBOL() { return getToken(ExpressionGrammarParser.PATH_SYMBOL, 0); }
		public Rp_PathsymbolContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterRp_Pathsymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitRp_Pathsymbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitRp_Pathsymbol(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_FilterContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode LSQ() { return getToken(ExpressionGrammarParser.LSQ, 0); }
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public TerminalNode RSQ() { return getToken(ExpressionGrammarParser.RSQ, 0); }
		public Rp_FilterContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterRp_Filter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitRp_Filter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitRp_Filter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_SlashContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public TerminalNode SLASH() { return getToken(ExpressionGrammarParser.SLASH, 0); }
		public Rp_SlashContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterRp_Slash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitRp_Slash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitRp_Slash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_TagNameContext extends RpContext {
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public Rp_TagNameContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterRp_TagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitRp_TagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitRp_TagName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_AttNameContext extends RpContext {
		public TerminalNode AT() { return getToken(ExpressionGrammarParser.AT, 0); }
		public AttNameContext attName() {
			return getRuleContext(AttNameContext.class,0);
		}
		public Rp_AttNameContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterRp_AttName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitRp_AttName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitRp_AttName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_TextContext extends RpContext {
		public TerminalNode TEXT_FUNC() { return getToken(ExpressionGrammarParser.TEXT_FUNC, 0); }
		public TerminalNode LPR() { return getToken(ExpressionGrammarParser.LPR, 0); }
		public TerminalNode RPR() { return getToken(ExpressionGrammarParser.RPR, 0); }
		public Rp_TextContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterRp_Text(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitRp_Text(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitRp_Text(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Rp_CommaContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(ExpressionGrammarParser.COMMA, 0); }
		public Rp_CommaContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterRp_Comma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitRp_Comma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitRp_Comma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				_localctx = new Rp_TagNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(55);
				tagName();
				}
				break;
			case AT:
				{
				_localctx = new Rp_AttNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				match(AT);
				setState(57);
				attName();
				}
				break;
			case PATH_SYMBOL:
				{
				_localctx = new Rp_PathsymbolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(58);
				match(PATH_SYMBOL);
				}
				break;
			case TEXT_FUNC:
				{
				_localctx = new Rp_TextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59);
				match(TEXT_FUNC);
				setState(60);
				match(LPR);
				setState(61);
				match(RPR);
				}
				break;
			case LPR:
				{
				_localctx = new Rp_ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62);
				match(LPR);
				setState(63);
				rp(0);
				setState(64);
				match(RPR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(79);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new Rp_SlashContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(68);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(69);
						match(SLASH);
						setState(70);
						rp(4);
						}
						break;
					case 2:
						{
						_localctx = new Rp_CommaContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(71);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(72);
						match(COMMA);
						setState(73);
						rp(2);
						}
						break;
					case 3:
						{
						_localctx = new Rp_FilterContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(74);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(75);
						match(LSQ);
						setState(76);
						filter(0);
						setState(77);
						match(RSQ);
						}
						break;
					}
					} 
				}
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TagNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(ExpressionGrammarParser.NAME, 0); }
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tagName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(ExpressionGrammarParser.NAME, 0); }
		public AttNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterAttName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitAttName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitAttName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttNameContext attName() throws RecognitionException {
		AttNameContext _localctx = new AttNameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilterContext extends ParserRuleContext {
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
	 
		public FilterContext() { }
		public void copyFrom(FilterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Filter_OrContext extends FilterContext {
		public List<FilterContext> filter() {
			return getRuleContexts(FilterContext.class);
		}
		public FilterContext filter(int i) {
			return getRuleContext(FilterContext.class,i);
		}
		public TerminalNode OR() { return getToken(ExpressionGrammarParser.OR, 0); }
		public Filter_OrContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterFilter_Or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitFilter_Or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitFilter_Or(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Filter_AndContext extends FilterContext {
		public List<FilterContext> filter() {
			return getRuleContexts(FilterContext.class);
		}
		public FilterContext filter(int i) {
			return getRuleContext(FilterContext.class,i);
		}
		public TerminalNode AND() { return getToken(ExpressionGrammarParser.AND, 0); }
		public Filter_AndContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterFilter_And(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitFilter_And(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitFilter_And(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Filter_NotContext extends FilterContext {
		public TerminalNode NEGATE() { return getToken(ExpressionGrammarParser.NEGATE, 0); }
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public Filter_NotContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterFilter_Not(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitFilter_Not(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitFilter_Not(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Filter_EqContext extends FilterContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(ExpressionGrammarParser.EQUAL, 0); }
		public TerminalNode STRING() { return getToken(ExpressionGrammarParser.STRING, 0); }
		public Filter_EqContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterFilter_Eq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitFilter_Eq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitFilter_Eq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Filter_SpecEqContext extends FilterContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public TerminalNode SPEC_EQUAL() { return getToken(ExpressionGrammarParser.SPEC_EQUAL, 0); }
		public Filter_SpecEqContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterFilter_SpecEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitFilter_SpecEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitFilter_SpecEq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Filter_RpContext extends FilterContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public Filter_RpContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterFilter_Rp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitFilter_Rp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitFilter_Rp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Filter_ParenContext extends FilterContext {
		public TerminalNode LPR() { return getToken(ExpressionGrammarParser.LPR, 0); }
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public TerminalNode RPR() { return getToken(ExpressionGrammarParser.RPR, 0); }
		public Filter_ParenContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterFilter_Paren(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitFilter_Paren(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitFilter_Paren(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterContext filter() throws RecognitionException {
		return filter(0);
	}

	private FilterContext filter(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FilterContext _localctx = new FilterContext(_ctx, _parentState);
		FilterContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_filter, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new Filter_RpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(89);
				rp(0);
				}
				break;
			case 2:
				{
				_localctx = new Filter_EqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				rp(0);
				setState(91);
				match(EQUAL);
				setState(94);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case AT:
				case TEXT_FUNC:
				case PATH_SYMBOL:
				case LPR:
				case NAME:
					{
					setState(92);
					rp(0);
					}
					break;
				case STRING:
					{
					setState(93);
					match(STRING);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				{
				_localctx = new Filter_SpecEqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				rp(0);
				setState(97);
				match(SPEC_EQUAL);
				setState(98);
				rp(0);
				}
				break;
			case 4:
				{
				_localctx = new Filter_ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				match(LPR);
				setState(101);
				filter(0);
				setState(102);
				match(RPR);
				}
				break;
			case 5:
				{
				_localctx = new Filter_NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104);
				match(NEGATE);
				setState(105);
				filter(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(114);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new Filter_AndContext(new FilterContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_filter);
						setState(108);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(109);
						match(AND);
						setState(110);
						filter(4);
						}
						break;
					case 2:
						{
						_localctx = new Filter_OrContext(new FilterContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_filter);
						setState(111);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(112);
						match(OR);
						setState(113);
						filter(3);
						}
						break;
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class XqContext extends ParserRuleContext {
		public XqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xq; }
	 
		public XqContext() { }
		public void copyFrom(XqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class XQ_PRContext extends XqContext {
		public TerminalNode LPR() { return getToken(ExpressionGrammarParser.LPR, 0); }
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TerminalNode RPR() { return getToken(ExpressionGrammarParser.RPR, 0); }
		public XQ_PRContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterXQ_PR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitXQ_PR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitXQ_PR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQ_TAGNAMEContext extends XqContext {
		public List<TerminalNode> LAB() { return getTokens(ExpressionGrammarParser.LAB); }
		public TerminalNode LAB(int i) {
			return getToken(ExpressionGrammarParser.LAB, i);
		}
		public List<TagNameContext> tagName() {
			return getRuleContexts(TagNameContext.class);
		}
		public TagNameContext tagName(int i) {
			return getRuleContext(TagNameContext.class,i);
		}
		public List<TerminalNode> RAB() { return getTokens(ExpressionGrammarParser.RAB); }
		public TerminalNode RAB(int i) {
			return getToken(ExpressionGrammarParser.RAB, i);
		}
		public TerminalNode LCB() { return getToken(ExpressionGrammarParser.LCB, 0); }
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TerminalNode RCB() { return getToken(ExpressionGrammarParser.RCB, 0); }
		public TerminalNode SLASH() { return getToken(ExpressionGrammarParser.SLASH, 0); }
		public XQ_TAGNAMEContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterXQ_TAGNAME(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitXQ_TAGNAME(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitXQ_TAGNAME(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQ_SLASHContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(ExpressionGrammarParser.SLASH, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XQ_SLASHContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterXQ_SLASH(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitXQ_SLASH(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitXQ_SLASH(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQ_LETContext extends XqContext {
		public TerminalNode LET() { return getToken(ExpressionGrammarParser.LET, 0); }
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public XQ_LETContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterXQ_LET(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitXQ_LET(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitXQ_LET(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQ_STRINGContext extends XqContext {
		public StringConstContext stringConst() {
			return getRuleContext(StringConstContext.class,0);
		}
		public XQ_STRINGContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterXQ_STRING(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitXQ_STRING(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitXQ_STRING(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQ_JOINContext extends XqContext {
		public TerminalNode JOIN() { return getToken(ExpressionGrammarParser.JOIN, 0); }
		public TerminalNode LPR() { return getToken(ExpressionGrammarParser.LPR, 0); }
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExpressionGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExpressionGrammarParser.COMMA, i);
		}
		public List<TerminalNode> LSQ() { return getTokens(ExpressionGrammarParser.LSQ); }
		public TerminalNode LSQ(int i) {
			return getToken(ExpressionGrammarParser.LSQ, i);
		}
		public List<NamelistContext> namelist() {
			return getRuleContexts(NamelistContext.class);
		}
		public NamelistContext namelist(int i) {
			return getRuleContext(NamelistContext.class,i);
		}
		public List<TerminalNode> RSQ() { return getTokens(ExpressionGrammarParser.RSQ); }
		public TerminalNode RSQ(int i) {
			return getToken(ExpressionGrammarParser.RSQ, i);
		}
		public TerminalNode RPR() { return getToken(ExpressionGrammarParser.RPR, 0); }
		public XQ_JOINContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterXQ_JOIN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitXQ_JOIN(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitXQ_JOIN(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQ_EXPContext extends XqContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public XQ_EXPContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterXQ_EXP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitXQ_EXP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitXQ_EXP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQ_VARContext extends XqContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public XQ_VARContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterXQ_VAR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitXQ_VAR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitXQ_VAR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQ_COMMAContext extends XqContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(ExpressionGrammarParser.COMMA, 0); }
		public XQ_COMMAContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterXQ_COMMA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitXQ_COMMA(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitXQ_COMMA(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XQ_FORContext extends XqContext {
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public ReturnClauseContext returnClause() {
			return getRuleContext(ReturnClauseContext.class,0);
		}
		public XQ_FORContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterXQ_FOR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitXQ_FOR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitXQ_FOR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XqContext xq() throws RecognitionException {
		return xq(0);
	}

	private XqContext xq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XqContext _localctx = new XqContext(_ctx, _parentState);
		XqContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_xq, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOLLAR:
				{
				_localctx = new XQ_VARContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(120);
				var();
				}
				break;
			case STRING:
				{
				_localctx = new XQ_STRINGContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				stringConst();
				}
				break;
			case DOC:
			case DOCUMENT:
				{
				_localctx = new XQ_EXPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				exp();
				}
				break;
			case LPR:
				{
				_localctx = new XQ_PRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				match(LPR);
				setState(124);
				xq(0);
				setState(125);
				match(RPR);
				}
				break;
			case LAB:
				{
				_localctx = new XQ_TAGNAMEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				match(LAB);
				setState(128);
				tagName();
				setState(129);
				match(RAB);
				setState(130);
				match(LCB);
				setState(131);
				xq(0);
				setState(132);
				match(RCB);
				setState(133);
				match(LAB);
				setState(134);
				match(SLASH);
				setState(135);
				tagName();
				setState(136);
				match(RAB);
				}
				break;
			case FOR:
				{
				_localctx = new XQ_FORContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138);
				forClause();
				setState(139);
				letClause();
				setState(140);
				whereClause();
				setState(141);
				returnClause();
				}
				break;
			case LET:
				{
				_localctx = new XQ_LETContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(LET);
				setState(144);
				definitions();
				}
				break;
			case JOIN:
				{
				_localctx = new XQ_JOINContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				match(JOIN);
				setState(146);
				match(LPR);
				setState(147);
				xq(0);
				setState(148);
				match(COMMA);
				setState(149);
				xq(0);
				setState(150);
				match(COMMA);
				setState(151);
				match(LSQ);
				setState(152);
				namelist();
				setState(153);
				match(RSQ);
				setState(154);
				match(COMMA);
				setState(155);
				match(LSQ);
				setState(156);
				namelist();
				setState(157);
				match(RSQ);
				setState(158);
				match(RPR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(168);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new XQ_COMMAContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(162);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(163);
						match(COMMA);
						setState(164);
						xq(6);
						}
						break;
					case 2:
						{
						_localctx = new XQ_SLASHContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(165);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(166);
						match(SLASH);
						setState(167);
						rp(0);
						}
						break;
					}
					} 
				}
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NamelistContext extends ParserRuleContext {
		public NamelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namelist; }
	 
		public NamelistContext() { }
		public void copyFrom(NamelistContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NAME_MULTIPLEContext extends NamelistContext {
		public TerminalNode NAME() { return getToken(ExpressionGrammarParser.NAME, 0); }
		public TerminalNode COMMA() { return getToken(ExpressionGrammarParser.COMMA, 0); }
		public NamelistContext namelist() {
			return getRuleContext(NamelistContext.class,0);
		}
		public NAME_MULTIPLEContext(NamelistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterNAME_MULTIPLE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitNAME_MULTIPLE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitNAME_MULTIPLE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NAME_ONEContext extends NamelistContext {
		public TerminalNode NAME() { return getToken(ExpressionGrammarParser.NAME, 0); }
		public NAME_ONEContext(NamelistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterNAME_ONE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitNAME_ONE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitNAME_ONE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamelistContext namelist() throws RecognitionException {
		NamelistContext _localctx = new NamelistContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_namelist);
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new NAME_MULTIPLEContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				match(NAME);
				setState(174);
				match(COMMA);
				setState(175);
				namelist();
				}
				break;
			case 2:
				_localctx = new NAME_ONEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(NAME);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForClauseContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(ExpressionGrammarParser.FOR, 0); }
		public ItemsContext items() {
			return getRuleContext(ItemsContext.class,0);
		}
		public ForClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterForClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitForClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitForClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForClauseContext forClause() throws RecognitionException {
		ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_forClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(FOR);
			setState(180);
			items();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ItemsContext extends ParserRuleContext {
		public ItemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_items; }
	 
		public ItemsContext() { }
		public void copyFrom(ItemsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ITEM_ONEContext extends ItemsContext {
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public ITEM_ONEContext(ItemsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterITEM_ONE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitITEM_ONE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitITEM_ONE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ITEM_MULTIPLEContext extends ItemsContext {
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ExpressionGrammarParser.COMMA, 0); }
		public ItemsContext items() {
			return getRuleContext(ItemsContext.class,0);
		}
		public ITEM_MULTIPLEContext(ItemsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterITEM_MULTIPLE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitITEM_MULTIPLE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitITEM_MULTIPLE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemsContext items() throws RecognitionException {
		ItemsContext _localctx = new ItemsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_items);
		try {
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new ITEM_MULTIPLEContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				item();
				setState(183);
				match(COMMA);
				setState(184);
				items();
				}
				break;
			case 2:
				_localctx = new ITEM_ONEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				item();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ItemContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode IN() { return getToken(ExpressionGrammarParser.IN, 0); }
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_item);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			var();
			setState(190);
			match(IN);
			setState(191);
			xq(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LetClauseContext extends ParserRuleContext {
		public LetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letClause; }
	 
		public LetClauseContext() { }
		public void copyFrom(LetClauseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LET_NONEContext extends LetClauseContext {
		public LET_NONEContext(LetClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterLET_NONE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitLET_NONE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitLET_NONE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LET_DEFContext extends LetClauseContext {
		public TerminalNode LET() { return getToken(ExpressionGrammarParser.LET, 0); }
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public LET_DEFContext(LetClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterLET_DEF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitLET_DEF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitLET_DEF(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetClauseContext letClause() throws RecognitionException {
		LetClauseContext _localctx = new LetClauseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_letClause);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LET:
				_localctx = new LET_DEFContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				match(LET);
				setState(194);
				definitions();
				}
				break;
			case WHERE:
			case RETURN:
				_localctx = new LET_NONEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionsContext extends ParserRuleContext {
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
	 
		public DefinitionsContext() { }
		public void copyFrom(DefinitionsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DEF_ONEContext extends DefinitionsContext {
		public DefinitionContext definition() {
			return getRuleContext(DefinitionContext.class,0);
		}
		public DEF_ONEContext(DefinitionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterDEF_ONE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitDEF_ONE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitDEF_ONE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DEF_MUTIPLEContext extends DefinitionsContext {
		public DefinitionContext definition() {
			return getRuleContext(DefinitionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ExpressionGrammarParser.COMMA, 0); }
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public DEF_MUTIPLEContext(DefinitionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterDEF_MUTIPLE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitDEF_MUTIPLE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitDEF_MUTIPLE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_definitions);
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new DEF_MUTIPLEContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				definition();
				setState(199);
				match(COMMA);
				setState(200);
				definitions();
				}
				break;
			case 2:
				_localctx = new DEF_ONEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				definition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode DEFINEEQ() { return getToken(ExpressionGrammarParser.DEFINEEQ, 0); }
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			var();
			setState(206);
			match(DEFINEEQ);
			setState(207);
			xq(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereClauseContext extends ParserRuleContext {
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
	 
		public WhereClauseContext() { }
		public void copyFrom(WhereClauseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WHERE_NONEContext extends WhereClauseContext {
		public WHERE_NONEContext(WhereClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterWHERE_NONE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitWHERE_NONE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitWHERE_NONE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WHERE_CONDITIONContext extends WhereClauseContext {
		public TerminalNode WHERE() { return getToken(ExpressionGrammarParser.WHERE, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public WHERE_CONDITIONContext(WhereClauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterWHERE_CONDITION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitWHERE_CONDITION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitWHERE_CONDITION(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whereClause);
		try {
			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHERE:
				_localctx = new WHERE_CONDITIONContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(WHERE);
				setState(210);
				cond(0);
				}
				break;
			case RETURN:
				_localctx = new WHERE_NONEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnClauseContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(ExpressionGrammarParser.RETURN, 0); }
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public ReturnClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterReturnClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitReturnClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitReturnClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(RETURN);
			setState(215);
			xq(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondContext extends ParserRuleContext {
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
	 
		public CondContext() { }
		public void copyFrom(CondContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class COND_SPEQUALContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public TerminalNode SPEC_EQUAL() { return getToken(ExpressionGrammarParser.SPEC_EQUAL, 0); }
		public COND_SPEQUALContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterCOND_SPEQUAL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitCOND_SPEQUAL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitCOND_SPEQUAL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class COND_PRContext extends CondContext {
		public TerminalNode LPR() { return getToken(ExpressionGrammarParser.LPR, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public TerminalNode RPR() { return getToken(ExpressionGrammarParser.RPR, 0); }
		public COND_PRContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterCOND_PR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitCOND_PR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitCOND_PR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class COND_ANDContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public TerminalNode AND() { return getToken(ExpressionGrammarParser.AND, 0); }
		public COND_ANDContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterCOND_AND(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitCOND_AND(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitCOND_AND(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class COND_EMPTYContext extends CondContext {
		public TerminalNode EMPTY() { return getToken(ExpressionGrammarParser.EMPTY, 0); }
		public TerminalNode LPR() { return getToken(ExpressionGrammarParser.LPR, 0); }
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TerminalNode RPR() { return getToken(ExpressionGrammarParser.RPR, 0); }
		public COND_EMPTYContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterCOND_EMPTY(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitCOND_EMPTY(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitCOND_EMPTY(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class COND_SATISFYContext extends CondContext {
		public TerminalNode SOME() { return getToken(ExpressionGrammarParser.SOME, 0); }
		public ItemsContext items() {
			return getRuleContext(ItemsContext.class,0);
		}
		public TerminalNode SATISFIES() { return getToken(ExpressionGrammarParser.SATISFIES, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public COND_SATISFYContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterCOND_SATISFY(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitCOND_SATISFY(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitCOND_SATISFY(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class COND_NEGATEContext extends CondContext {
		public TerminalNode NEGATE() { return getToken(ExpressionGrammarParser.NEGATE, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public COND_NEGATEContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterCOND_NEGATE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitCOND_NEGATE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitCOND_NEGATE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class COND_ORContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public TerminalNode OR() { return getToken(ExpressionGrammarParser.OR, 0); }
		public COND_ORContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterCOND_OR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitCOND_OR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitCOND_OR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class COND_EQUALContext extends CondContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(ExpressionGrammarParser.EQUAL, 0); }
		public COND_EQUALContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterCOND_EQUAL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitCOND_EQUAL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitCOND_EQUAL(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_cond, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				_localctx = new COND_EQUALContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(218);
				xq(0);
				setState(219);
				match(EQUAL);
				setState(220);
				xq(0);
				}
				break;
			case 2:
				{
				_localctx = new COND_SPEQUALContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222);
				xq(0);
				setState(223);
				match(SPEC_EQUAL);
				setState(224);
				xq(0);
				}
				break;
			case 3:
				{
				_localctx = new COND_EMPTYContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				match(EMPTY);
				setState(227);
				match(LPR);
				setState(228);
				xq(0);
				setState(229);
				match(RPR);
				}
				break;
			case 4:
				{
				_localctx = new COND_SATISFYContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				match(SOME);
				setState(232);
				items();
				setState(233);
				match(SATISFIES);
				setState(234);
				cond(5);
				}
				break;
			case 5:
				{
				_localctx = new COND_PRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236);
				match(LPR);
				setState(237);
				cond(0);
				setState(238);
				match(RPR);
				}
				break;
			case 6:
				{
				_localctx = new COND_NEGATEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240);
				match(NEGATE);
				setState(241);
				cond(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(250);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new COND_ANDContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(244);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(245);
						match(AND);
						setState(246);
						cond(4);
						}
						break;
					case 2:
						{
						_localctx = new COND_ORContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(247);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(248);
						match(OR);
						setState(249);
						cond(3);
						}
						break;
					}
					} 
				}
				setState(254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DocNameContext extends ParserRuleContext {
		public TerminalNode LPR() { return getToken(ExpressionGrammarParser.LPR, 0); }
		public FileNameContext fileName() {
			return getRuleContext(FileNameContext.class,0);
		}
		public TerminalNode RPR() { return getToken(ExpressionGrammarParser.RPR, 0); }
		public TerminalNode DOC() { return getToken(ExpressionGrammarParser.DOC, 0); }
		public TerminalNode DOCUMENT() { return getToken(ExpressionGrammarParser.DOCUMENT, 0); }
		public DocNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_docName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterDocName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitDocName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitDocName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocNameContext docName() throws RecognitionException {
		DocNameContext _localctx = new DocNameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_docName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_la = _input.LA(1);
			if ( !(_la==DOC || _la==DOCUMENT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(256);
			match(LPR);
			setState(257);
			fileName();
			setState(258);
			match(RPR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode DOLLAR() { return getToken(ExpressionGrammarParser.DOLLAR, 0); }
		public TerminalNode NAME() { return getToken(ExpressionGrammarParser.NAME, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(DOLLAR);
			setState(261);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FileNameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ExpressionGrammarParser.STRING, 0); }
		public FileNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterFileName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitFileName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitFileName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileNameContext fileName() throws RecognitionException {
		FileNameContext _localctx = new FileNameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fileName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringConstContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ExpressionGrammarParser.STRING, 0); }
		public StringConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringConst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).enterStringConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionGrammarListener ) ((ExpressionGrammarListener)listener).exitStringConst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionGrammarVisitor ) return ((ExpressionGrammarVisitor<? extends T>)visitor).visitStringConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringConstContext stringConst() throws RecognitionException {
		StringConstContext _localctx = new StringConstContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stringConst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 5:
			return filter_sempred((FilterContext)_localctx, predIndex);
		case 6:
			return xq_sempred((XqContext)_localctx, predIndex);
		case 16:
			return cond_sempred((CondContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 1);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean filter_sempred(FilterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean xq_sempred(XqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u010e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\6\2/\n\2\r\2\16\2\60"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4E\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4R\n\4\f\4\16"+
		"\4U\13\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7a\n\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7m\n\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7u\n\7"+
		"\f\7\16\7x\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a3\n\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\7\b\u00ab\n\b\f\b\16\b\u00ae\13\b\3\t\3\t\3\t\3\t\5\t\u00b4\n"+
		"\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13\u00be\n\13\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\5\r\u00c7\n\r\3\16\3\16\3\16\3\16\3\16\5\16\u00ce\n\16"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u00d7\n\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00f5\n\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\7\22\u00fd\n\22\f\22\16\22\u0100\13\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\2\6\6\f\16"+
		"\"\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\3\3\2\5\6\2\u011d"+
		"\2.\3\2\2\2\4\64\3\2\2\2\6D\3\2\2\2\bV\3\2\2\2\nX\3\2\2\2\fl\3\2\2\2\16"+
		"\u00a2\3\2\2\2\20\u00b3\3\2\2\2\22\u00b5\3\2\2\2\24\u00bd\3\2\2\2\26\u00bf"+
		"\3\2\2\2\30\u00c6\3\2\2\2\32\u00cd\3\2\2\2\34\u00cf\3\2\2\2\36\u00d6\3"+
		"\2\2\2 \u00d8\3\2\2\2\"\u00f4\3\2\2\2$\u0101\3\2\2\2&\u0106\3\2\2\2(\u0109"+
		"\3\2\2\2*\u010b\3\2\2\2,/\5\16\b\2-/\5\4\3\2.,\3\2\2\2.-\3\2\2\2/\60\3"+
		"\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\63\7\2\2\3\63\3\3\2"+
		"\2\2\64\65\5$\23\2\65\66\7\t\2\2\66\67\5\6\4\2\67\5\3\2\2\289\b\4\1\2"+
		"9E\5\b\5\2:;\7\b\2\2;E\5\n\6\2<E\7\r\2\2=>\7\f\2\2>?\7\21\2\2?E\7\22\2"+
		"\2@A\7\21\2\2AB\5\6\4\2BC\7\22\2\2CE\3\2\2\2D8\3\2\2\2D:\3\2\2\2D<\3\2"+
		"\2\2D=\3\2\2\2D@\3\2\2\2ES\3\2\2\2FG\f\5\2\2GH\7\t\2\2HR\5\6\4\6IJ\f\3"+
		"\2\2JK\7\32\2\2KR\5\6\4\4LM\f\4\2\2MN\7\27\2\2NO\5\f\7\2OP\7\30\2\2PR"+
		"\3\2\2\2QF\3\2\2\2QI\3\2\2\2QL\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T"+
		"\7\3\2\2\2US\3\2\2\2VW\7%\2\2W\t\3\2\2\2XY\7%\2\2Y\13\3\2\2\2Z[\b\7\1"+
		"\2[m\5\6\4\2\\]\5\6\4\2]`\7\13\2\2^a\5\6\4\2_a\7\3\2\2`^\3\2\2\2`_\3\2"+
		"\2\2am\3\2\2\2bc\5\6\4\2cd\7\n\2\2de\5\6\4\2em\3\2\2\2fg\7\21\2\2gh\5"+
		"\f\7\2hi\7\22\2\2im\3\2\2\2jk\7\20\2\2km\5\f\7\3lZ\3\2\2\2l\\\3\2\2\2"+
		"lb\3\2\2\2lf\3\2\2\2lj\3\2\2\2mv\3\2\2\2no\f\5\2\2op\7\16\2\2pu\5\f\7"+
		"\6qr\f\4\2\2rs\7\17\2\2su\5\f\7\5tn\3\2\2\2tq\3\2\2\2ux\3\2\2\2vt\3\2"+
		"\2\2vw\3\2\2\2w\r\3\2\2\2xv\3\2\2\2yz\b\b\1\2z\u00a3\5&\24\2{\u00a3\5"+
		"*\26\2|\u00a3\5\4\3\2}~\7\21\2\2~\177\5\16\b\2\177\u0080\7\22\2\2\u0080"+
		"\u00a3\3\2\2\2\u0081\u0082\7\23\2\2\u0082\u0083\5\b\5\2\u0083\u0084\7"+
		"\24\2\2\u0084\u0085\7\25\2\2\u0085\u0086\5\16\b\2\u0086\u0087\7\26\2\2"+
		"\u0087\u0088\7\23\2\2\u0088\u0089\7\t\2\2\u0089\u008a\5\b\5\2\u008a\u008b"+
		"\7\24\2\2\u008b\u00a3\3\2\2\2\u008c\u008d\5\22\n\2\u008d\u008e\5\30\r"+
		"\2\u008e\u008f\5\36\20\2\u008f\u0090\5 \21\2\u0090\u00a3\3\2\2\2\u0091"+
		"\u0092\7\35\2\2\u0092\u00a3\5\32\16\2\u0093\u0094\7$\2\2\u0094\u0095\7"+
		"\21\2\2\u0095\u0096\5\16\b\2\u0096\u0097\7\32\2\2\u0097\u0098\5\16\b\2"+
		"\u0098\u0099\7\32\2\2\u0099\u009a\7\27\2\2\u009a\u009b\5\20\t\2\u009b"+
		"\u009c\7\30\2\2\u009c\u009d\7\32\2\2\u009d\u009e\7\27\2\2\u009e\u009f"+
		"\5\20\t\2\u009f\u00a0\7\30\2\2\u00a0\u00a1\7\22\2\2\u00a1\u00a3\3\2\2"+
		"\2\u00a2y\3\2\2\2\u00a2{\3\2\2\2\u00a2|\3\2\2\2\u00a2}\3\2\2\2\u00a2\u0081"+
		"\3\2\2\2\u00a2\u008c\3\2\2\2\u00a2\u0091\3\2\2\2\u00a2\u0093\3\2\2\2\u00a3"+
		"\u00ac\3\2\2\2\u00a4\u00a5\f\7\2\2\u00a5\u00a6\7\32\2\2\u00a6\u00ab\5"+
		"\16\b\b\u00a7\u00a8\f\b\2\2\u00a8\u00a9\7\t\2\2\u00a9\u00ab\5\6\4\2\u00aa"+
		"\u00a4\3\2\2\2\u00aa\u00a7\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\17\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0"+
		"\7%\2\2\u00b0\u00b1\7\32\2\2\u00b1\u00b4\5\20\t\2\u00b2\u00b4\7%\2\2\u00b3"+
		"\u00af\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\21\3\2\2\2\u00b5\u00b6\7\33\2"+
		"\2\u00b6\u00b7\5\24\13\2\u00b7\23\3\2\2\2\u00b8\u00b9\5\26\f\2\u00b9\u00ba"+
		"\7\32\2\2\u00ba\u00bb\5\24\13\2\u00bb\u00be\3\2\2\2\u00bc\u00be\5\26\f"+
		"\2\u00bd\u00b8\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\25\3\2\2\2\u00bf\u00c0"+
		"\5&\24\2\u00c0\u00c1\7\34\2\2\u00c1\u00c2\5\16\b\2\u00c2\27\3\2\2\2\u00c3"+
		"\u00c4\7\35\2\2\u00c4\u00c7\5\32\16\2\u00c5\u00c7\3\2\2\2\u00c6\u00c3"+
		"\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\31\3\2\2\2\u00c8\u00c9\5\34\17\2\u00c9"+
		"\u00ca\7\32\2\2\u00ca\u00cb\5\32\16\2\u00cb\u00ce\3\2\2\2\u00cc\u00ce"+
		"\5\34\17\2\u00cd\u00c8\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\33\3\2\2\2\u00cf"+
		"\u00d0\5&\24\2\u00d0\u00d1\7\36\2\2\u00d1\u00d2\5\16\b\2\u00d2\35\3\2"+
		"\2\2\u00d3\u00d4\7\37\2\2\u00d4\u00d7\5\"\22\2\u00d5\u00d7\3\2\2\2\u00d6"+
		"\u00d3\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\37\3\2\2\2\u00d8\u00d9\7 \2\2"+
		"\u00d9\u00da\5\16\b\2\u00da!\3\2\2\2\u00db\u00dc\b\22\1\2\u00dc\u00dd"+
		"\5\16\b\2\u00dd\u00de\7\13\2\2\u00de\u00df\5\16\b\2\u00df\u00f5\3\2\2"+
		"\2\u00e0\u00e1\5\16\b\2\u00e1\u00e2\7\n\2\2\u00e2\u00e3\5\16\b\2\u00e3"+
		"\u00f5\3\2\2\2\u00e4\u00e5\7!\2\2\u00e5\u00e6\7\21\2\2\u00e6\u00e7\5\16"+
		"\b\2\u00e7\u00e8\7\22\2\2\u00e8\u00f5\3\2\2\2\u00e9\u00ea\7\"\2\2\u00ea"+
		"\u00eb\5\24\13\2\u00eb\u00ec\7#\2\2\u00ec\u00ed\5\"\22\7\u00ed\u00f5\3"+
		"\2\2\2\u00ee\u00ef\7\21\2\2\u00ef\u00f0\5\"\22\2\u00f0\u00f1\7\22\2\2"+
		"\u00f1\u00f5\3\2\2\2\u00f2\u00f3\7\20\2\2\u00f3\u00f5\5\"\22\3\u00f4\u00db"+
		"\3\2\2\2\u00f4\u00e0\3\2\2\2\u00f4\u00e4\3\2\2\2\u00f4\u00e9\3\2\2\2\u00f4"+
		"\u00ee\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00fe\3\2\2\2\u00f6\u00f7\f\5"+
		"\2\2\u00f7\u00f8\7\16\2\2\u00f8\u00fd\5\"\22\6\u00f9\u00fa\f\4\2\2\u00fa"+
		"\u00fb\7\17\2\2\u00fb\u00fd\5\"\22\5\u00fc\u00f6\3\2\2\2\u00fc\u00f9\3"+
		"\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"#\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\t\2\2\2\u0102\u0103\7\21\2\2"+
		"\u0103\u0104\5(\25\2\u0104\u0105\7\22\2\2\u0105%\3\2\2\2\u0106\u0107\7"+
		"\7\2\2\u0107\u0108\7%\2\2\u0108\'\3\2\2\2\u0109\u010a\7\3\2\2\u010a)\3"+
		"\2\2\2\u010b\u010c\7\3\2\2\u010c+\3\2\2\2\26.\60DQS`ltv\u00a2\u00aa\u00ac"+
		"\u00b3\u00bd\u00c6\u00cd\u00d6\u00f4\u00fc\u00fe";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}