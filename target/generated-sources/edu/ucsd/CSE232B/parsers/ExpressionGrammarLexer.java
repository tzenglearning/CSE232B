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
		STRING=1, ESCAPE=2, DOC=3, DOCUMENT=4, DOLLAR=5, AT=6, SLASH=7, SPEC_EQUAL=8, 
		EQUAL=9, TEXT_FUNC=10, PATH_SYMBOL=11, AND=12, OR=13, NEGATE=14, LPR=15, 
		RPR=16, LAB=17, RAB=18, LCB=19, RCB=20, LSQ=21, RSQ=22, QUOTE=23, COMMA=24, 
		FOR=25, IN=26, LET=27, DEFINEEQ=28, WHERE=29, RETURN=30, EMPTY=31, SOME=32, 
		SATISFIES=33, JOIN=34, NAME=35, WS=36;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"STRING", "ESCAPE", "DOC", "D", "O", "C", "DOCUMENT", "DOLLAR", "AT", 
			"SLASH", "SPEC_EQUAL", "EQUAL", "TEXT_FUNC", "PATH_SYMBOL", "AND", "OR", 
			"NEGATE", "LPR", "RPR", "LAB", "RAB", "LCB", "RCB", "LSQ", "RSQ", "QUOTE", 
			"COMMA", "FOR", "IN", "LET", "DEFINEEQ", "WHERE", "RETURN", "EMPTY", 
			"SOME", "SATISFIES", "JOIN", "NAME", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2&\u00fb\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\7\2U\n\2"+
		"\f\2\16\2X\13\2\3\2\3\2\3\2\3\2\7\2^\n\2\f\2\16\2a\13\2\3\2\5\2d\n\2\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\5\13\u0083\n\13\3\f\3"+
		"\f\3\f\3\f\5\f\u0089\n\f\3\r\3\r\3\r\5\r\u008e\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\5\17\u0098\n\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\7\'\u00f0\n\'\f\'\16\'\u00f3\13\'"+
		"\3(\6(\u00f6\n(\r(\16(\u00f7\3(\3(\2\2)\3\3\5\4\7\5\t\2\13\2\r\2\17\6"+
		"\21\7\23\b\25\t\27\n\31\13\33\f\35\r\37\16!\17#\20%\21\'\22)\23+\24-\25"+
		"/\26\61\27\63\30\65\31\67\329\33;\34=\35?\36A\37C E!G\"I#K$M%O&\3\2\f"+
		"\4\2$$^^\4\2))^^\5\2$$))^^\4\2FFff\4\2QQqq\4\2EEee\4\2,,\60\60\4\2C\\"+
		"c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u0102\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3c\3\2\2\2\5e\3"+
		"\2\2\2\7h\3\2\2\2\tl\3\2\2\2\13n\3\2\2\2\rp\3\2\2\2\17r\3\2\2\2\21{\3"+
		"\2\2\2\23}\3\2\2\2\25\u0082\3\2\2\2\27\u0088\3\2\2\2\31\u008d\3\2\2\2"+
		"\33\u008f\3\2\2\2\35\u0097\3\2\2\2\37\u0099\3\2\2\2!\u009d\3\2\2\2#\u00a0"+
		"\3\2\2\2%\u00a4\3\2\2\2\'\u00a6\3\2\2\2)\u00a8\3\2\2\2+\u00aa\3\2\2\2"+
		"-\u00ac\3\2\2\2/\u00ae\3\2\2\2\61\u00b0\3\2\2\2\63\u00b2\3\2\2\2\65\u00b4"+
		"\3\2\2\2\67\u00b6\3\2\2\29\u00b8\3\2\2\2;\u00bc\3\2\2\2=\u00bf\3\2\2\2"+
		"?\u00c3\3\2\2\2A\u00c6\3\2\2\2C\u00cc\3\2\2\2E\u00d3\3\2\2\2G\u00d9\3"+
		"\2\2\2I\u00de\3\2\2\2K\u00e8\3\2\2\2M\u00ed\3\2\2\2O\u00f5\3\2\2\2QV\7"+
		"$\2\2RU\5\5\3\2SU\n\2\2\2TR\3\2\2\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3"+
		"\2\2\2WY\3\2\2\2XV\3\2\2\2Yd\7$\2\2Z_\7)\2\2[^\5\5\3\2\\^\n\3\2\2][\3"+
		"\2\2\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_\3\2\2\2bd"+
		"\7)\2\2cQ\3\2\2\2cZ\3\2\2\2d\4\3\2\2\2ef\7^\2\2fg\t\4\2\2g\6\3\2\2\2h"+
		"i\5\t\5\2ij\5\13\6\2jk\5\r\7\2k\b\3\2\2\2lm\t\5\2\2m\n\3\2\2\2no\t\6\2"+
		"\2o\f\3\2\2\2pq\t\7\2\2q\16\3\2\2\2rs\7f\2\2st\7q\2\2tu\7e\2\2uv\7w\2"+
		"\2vw\7o\2\2wx\7g\2\2xy\7p\2\2yz\7v\2\2z\20\3\2\2\2{|\7&\2\2|\22\3\2\2"+
		"\2}~\7B\2\2~\24\3\2\2\2\177\u0083\7\61\2\2\u0080\u0081\7\61\2\2\u0081"+
		"\u0083\7\61\2\2\u0082\177\3\2\2\2\u0082\u0080\3\2\2\2\u0083\26\3\2\2\2"+
		"\u0084\u0085\7?\2\2\u0085\u0089\7?\2\2\u0086\u0087\7k\2\2\u0087\u0089"+
		"\7u\2\2\u0088\u0084\3\2\2\2\u0088\u0086\3\2\2\2\u0089\30\3\2\2\2\u008a"+
		"\u008b\7g\2\2\u008b\u008e\7s\2\2\u008c\u008e\7?\2\2\u008d\u008a\3\2\2"+
		"\2\u008d\u008c\3\2\2\2\u008e\32\3\2\2\2\u008f\u0090\7v\2\2\u0090\u0091"+
		"\7g\2\2\u0091\u0092\7z\2\2\u0092\u0093\7v\2\2\u0093\34\3\2\2\2\u0094\u0098"+
		"\t\b\2\2\u0095\u0096\7\60\2\2\u0096\u0098\7\60\2\2\u0097\u0094\3\2\2\2"+
		"\u0097\u0095\3\2\2\2\u0098\36\3\2\2\2\u0099\u009a\7c\2\2\u009a\u009b\7"+
		"p\2\2\u009b\u009c\7f\2\2\u009c \3\2\2\2\u009d\u009e\7q\2\2\u009e\u009f"+
		"\7t\2\2\u009f\"\3\2\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7q\2\2\u00a2\u00a3"+
		"\7v\2\2\u00a3$\3\2\2\2\u00a4\u00a5\7*\2\2\u00a5&\3\2\2\2\u00a6\u00a7\7"+
		"+\2\2\u00a7(\3\2\2\2\u00a8\u00a9\7>\2\2\u00a9*\3\2\2\2\u00aa\u00ab\7@"+
		"\2\2\u00ab,\3\2\2\2\u00ac\u00ad\7}\2\2\u00ad.\3\2\2\2\u00ae\u00af\7\177"+
		"\2\2\u00af\60\3\2\2\2\u00b0\u00b1\7]\2\2\u00b1\62\3\2\2\2\u00b2\u00b3"+
		"\7_\2\2\u00b3\64\3\2\2\2\u00b4\u00b5\7$\2\2\u00b5\66\3\2\2\2\u00b6\u00b7"+
		"\7.\2\2\u00b78\3\2\2\2\u00b8\u00b9\7h\2\2\u00b9\u00ba\7q\2\2\u00ba\u00bb"+
		"\7t\2\2\u00bb:\3\2\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7p\2\2\u00be<\3"+
		"\2\2\2\u00bf\u00c0\7n\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2\7v\2\2\u00c2"+
		">\3\2\2\2\u00c3\u00c4\7<\2\2\u00c4\u00c5\7?\2\2\u00c5@\3\2\2\2\u00c6\u00c7"+
		"\7y\2\2\u00c7\u00c8\7j\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\7t\2\2\u00ca"+
		"\u00cb\7g\2\2\u00cbB\3\2\2\2\u00cc\u00cd\7t\2\2\u00cd\u00ce\7g\2\2\u00ce"+
		"\u00cf\7v\2\2\u00cf\u00d0\7w\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2\7p\2\2"+
		"\u00d2D\3\2\2\2\u00d3\u00d4\7g\2\2\u00d4\u00d5\7o\2\2\u00d5\u00d6\7r\2"+
		"\2\u00d6\u00d7\7v\2\2\u00d7\u00d8\7{\2\2\u00d8F\3\2\2\2\u00d9\u00da\7"+
		"u\2\2\u00da\u00db\7q\2\2\u00db\u00dc\7o\2\2\u00dc\u00dd\7g\2\2\u00ddH"+
		"\3\2\2\2\u00de\u00df\7u\2\2\u00df\u00e0\7c\2\2\u00e0\u00e1\7v\2\2\u00e1"+
		"\u00e2\7k\2\2\u00e2\u00e3\7u\2\2\u00e3\u00e4\7h\2\2\u00e4\u00e5\7k\2\2"+
		"\u00e5\u00e6\7g\2\2\u00e6\u00e7\7u\2\2\u00e7J\3\2\2\2\u00e8\u00e9\7l\2"+
		"\2\u00e9\u00ea\7q\2\2\u00ea\u00eb\7k\2\2\u00eb\u00ec\7p\2\2\u00ecL\3\2"+
		"\2\2\u00ed\u00f1\t\t\2\2\u00ee\u00f0\t\n\2\2\u00ef\u00ee\3\2\2\2\u00f0"+
		"\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2N\3\2\2\2"+
		"\u00f3\u00f1\3\2\2\2\u00f4\u00f6\t\13\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f7"+
		"\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9"+
		"\u00fa\b(\2\2\u00faP\3\2\2\2\16\2TV]_c\u0082\u0088\u008d\u0097\u00f1\u00f7"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}