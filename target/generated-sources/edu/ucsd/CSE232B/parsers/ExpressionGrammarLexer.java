// Generated from ExpressionGrammar.g4 by ANTLR 4.7.2

package edu.ucsd.CSE232B.parsers;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STRING=1, ESCAPE=2, DOC=3, AT=4, SLASH=5, SPEC_EQUAL=6, EQUAL=7, TEXT_FUNC=8, 
		PATH_SYMBOL=9, AND=10, OR=11, NEGATE=12, LPR=13, RPR=14, LSQ=15, RSQ=16, 
		QUOTE=17, COMMA=18, NAME=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"STRING", "ESCAPE", "DOC", "D", "O", "C", "AT", "SLASH", "SPEC_EQUAL", 
			"EQUAL", "TEXT_FUNC", "PATH_SYMBOL", "AND", "OR", "NEGATE", "LPR", "RPR", 
			"LSQ", "RSQ", "QUOTE", "COMMA", "NAME", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'@'", null, null, "'='", "'text'", null, "'and'", 
			"'or'", "'not'", "'('", "')'", "'['", "']'", "'\"'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "STRING", "ESCAPE", "DOC", "AT", "SLASH", "SPEC_EQUAL", "EQUAL", 
			"TEXT_FUNC", "PATH_SYMBOL", "AND", "OR", "NEGATE", "LPR", "RPR", "LSQ", 
			"RSQ", "QUOTE", "COMMA", "NAME", "WS"
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


	public ExpressionGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ExpressionGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0092\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\7\2\65\n\2\f\2\16\28\13\2\3\2\3\2\3\2\3\2\7\2>\n\2\f\2\16\2A"+
		"\13\2\3\2\5\2D\n\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\t\5\tX\n\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n`\n\n\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\5\rl\n\r\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\7\27\u0087\n\27\f\27\16\27\u008a\13\27"+
		"\3\30\6\30\u008d\n\30\r\30\16\30\u008e\3\30\3\30\2\2\31\3\3\5\4\7\5\t"+
		"\2\13\2\r\2\17\6\21\7\23\b\25\t\27\n\31\13\33\f\35\r\37\16!\17#\20%\21"+
		"\'\22)\23+\24-\25/\26\3\2\f\4\2$$^^\4\2))^^\5\2$$))^^\4\2FFff\4\2QQqq"+
		"\4\2EEee\4\2,,\60\60\4\2C\\c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u0099"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3C\3\2\2\2\5E\3\2\2\2\7H\3\2\2\2\t"+
		"L\3\2\2\2\13N\3\2\2\2\rP\3\2\2\2\17R\3\2\2\2\21W\3\2\2\2\23_\3\2\2\2\25"+
		"a\3\2\2\2\27c\3\2\2\2\31k\3\2\2\2\33m\3\2\2\2\35q\3\2\2\2\37t\3\2\2\2"+
		"!x\3\2\2\2#z\3\2\2\2%|\3\2\2\2\'~\3\2\2\2)\u0080\3\2\2\2+\u0082\3\2\2"+
		"\2-\u0084\3\2\2\2/\u008c\3\2\2\2\61\66\7$\2\2\62\65\5\5\3\2\63\65\n\2"+
		"\2\2\64\62\3\2\2\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2"+
		"\2\679\3\2\2\28\66\3\2\2\29D\7$\2\2:?\7)\2\2;>\5\5\3\2<>\n\3\2\2=;\3\2"+
		"\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BD\7)"+
		"\2\2C\61\3\2\2\2C:\3\2\2\2D\4\3\2\2\2EF\7^\2\2FG\t\4\2\2G\6\3\2\2\2HI"+
		"\5\t\5\2IJ\5\13\6\2JK\5\r\7\2K\b\3\2\2\2LM\t\5\2\2M\n\3\2\2\2NO\t\6\2"+
		"\2O\f\3\2\2\2PQ\t\7\2\2Q\16\3\2\2\2RS\7B\2\2S\20\3\2\2\2TX\7\61\2\2UV"+
		"\7\61\2\2VX\7\61\2\2WT\3\2\2\2WU\3\2\2\2X\22\3\2\2\2YZ\7g\2\2Z`\7s\2\2"+
		"[\\\7?\2\2\\`\7?\2\2]^\7k\2\2^`\7u\2\2_Y\3\2\2\2_[\3\2\2\2_]\3\2\2\2`"+
		"\24\3\2\2\2ab\7?\2\2b\26\3\2\2\2cd\7v\2\2de\7g\2\2ef\7z\2\2fg\7v\2\2g"+
		"\30\3\2\2\2hl\t\b\2\2ij\7\60\2\2jl\7\60\2\2kh\3\2\2\2ki\3\2\2\2l\32\3"+
		"\2\2\2mn\7c\2\2no\7p\2\2op\7f\2\2p\34\3\2\2\2qr\7q\2\2rs\7t\2\2s\36\3"+
		"\2\2\2tu\7p\2\2uv\7q\2\2vw\7v\2\2w \3\2\2\2xy\7*\2\2y\"\3\2\2\2z{\7+\2"+
		"\2{$\3\2\2\2|}\7]\2\2}&\3\2\2\2~\177\7_\2\2\177(\3\2\2\2\u0080\u0081\7"+
		"$\2\2\u0081*\3\2\2\2\u0082\u0083\7.\2\2\u0083,\3\2\2\2\u0084\u0088\t\t"+
		"\2\2\u0085\u0087\t\n\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089.\3\2\2\2\u008a\u0088\3\2\2\2"+
		"\u008b\u008d\t\13\2\2\u008c\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c"+
		"\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\b\30\2\2"+
		"\u0091\60\3\2\2\2\r\2\64\66=?CW_k\u0088\u008e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}