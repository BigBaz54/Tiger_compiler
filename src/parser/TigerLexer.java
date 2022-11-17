// Generated from ./TigerLexer.g4 by ANTLR 4.9.2

    package parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TigerLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, LBRACK=3, RBRACK=4, LBRACE=5, RBRACE=6, COLON=7, ASSIGN=8, 
		DOT=9, COMMA=10, SEMI=11, PLUS=12, MINUS=13, TIMES=14, DIVIDE=15, EQ=16, 
		NEQ=17, LT=18, LE=19, GT=20, GE=21, AND=22, OR=23, ARRAY=24, BREAK=25, 
		DO=26, ELSE=27, END=28, FOR=29, FUNCTION=30, IF=31, IN=32, LET=33, NIL=34, 
		OF=35, THEN=36, TO=37, TYPE=38, VAR=39, WHILE=40, ID=41, INTLIT=42, STRINGLIT=43, 
		COMMENT=44, PRINT=45, FLUSH=46, GETCHAR=47, ORD=48, CHR=49, SIZE=50, SUBSTR=51, 
		CONCAT=52, NOT=53, EXIT=54, INT=55, STRING=56, WS=57;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LPAREN", "RPAREN", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "COLON", 
			"ASSIGN", "DOT", "COMMA", "SEMI", "PLUS", "MINUS", "TIMES", "DIVIDE", 
			"EQ", "NEQ", "LT", "LE", "GT", "GE", "AND", "OR", "ARRAY", "BREAK", "DO", 
			"ELSE", "END", "FOR", "FUNCTION", "IF", "IN", "LET", "NIL", "OF", "THEN", 
			"TO", "TYPE", "VAR", "WHILE", "ID", "INTLIT", "STRINGLIT", "COMMENT", 
			"PRINT", "FLUSH", "GETCHAR", "ORD", "CHR", "SIZE", "SUBSTR", "CONCAT", 
			"NOT", "EXIT", "INT", "STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "':'", "':='", "'.'", 
			"','", "';'", "'+'", "'-'", "'*'", "'/'", "'='", "'<>'", "'<'", "'<='", 
			"'>'", "'>='", "'&'", "'|'", "'array'", "'break'", "'do'", "'else'", 
			"'end'", "'for'", "'function'", "'if'", "'in'", "'let'", "'nil'", "'of'", 
			"'then'", "'to'", "'type'", "'var'", "'while'", null, null, null, null, 
			"'print'", "'flush'", "'getchar'", "'ord'", "'chr'", "'size'", "'substr'", 
			"'concat'", "'not'", "'exit'", "'int'", "'string'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "COLON", 
			"ASSIGN", "DOT", "COMMA", "SEMI", "PLUS", "MINUS", "TIMES", "DIVIDE", 
			"EQ", "NEQ", "LT", "LE", "GT", "GE", "AND", "OR", "ARRAY", "BREAK", "DO", 
			"ELSE", "END", "FOR", "FUNCTION", "IF", "IN", "LET", "NIL", "OF", "THEN", 
			"TO", "TYPE", "VAR", "WHILE", "ID", "INTLIT", "STRINGLIT", "COMMENT", 
			"PRINT", "FLUSH", "GETCHAR", "ORD", "CHR", "SIZE", "SUBSTR", "CONCAT", 
			"NOT", "EXIT", "INT", "STRING", "WS"
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


	public TigerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TigerLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2;\u015e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3"+
		"\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3"+
		"\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\7*\u00f7\n*\f*\16*\u00fa\13"+
		"*\3+\6+\u00fd\n+\r+\16+\u00fe\3,\3,\7,\u0103\n,\f,\16,\u0106\13,\3,\3"+
		",\3-\3-\3-\3-\7-\u010e\n-\f-\16-\u0111\13-\3-\3-\3-\3-\3-\3.\3.\3.\3."+
		"\3.\3.\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61"+
		"\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66"+
		"\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38\38\39\39\39\39\39\39\39\3"+
		":\3:\3:\3:\3\u010f\2;\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63"+
		"e\64g\65i\66k\67m8o9q:s;\3\2\6\4\2C\\c|\6\2\62;C\\aac|\6\2\"#%(*]_\u0080"+
		"\5\2\13\f\17\17\"\"\2\u0161\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2"+
		"\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i"+
		"\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\3u\3\2"+
		"\2\2\5w\3\2\2\2\7y\3\2\2\2\t{\3\2\2\2\13}\3\2\2\2\r\177\3\2\2\2\17\u0081"+
		"\3\2\2\2\21\u0083\3\2\2\2\23\u0086\3\2\2\2\25\u0088\3\2\2\2\27\u008a\3"+
		"\2\2\2\31\u008c\3\2\2\2\33\u008e\3\2\2\2\35\u0090\3\2\2\2\37\u0092\3\2"+
		"\2\2!\u0094\3\2\2\2#\u0096\3\2\2\2%\u0099\3\2\2\2\'\u009b\3\2\2\2)\u009e"+
		"\3\2\2\2+\u00a0\3\2\2\2-\u00a3\3\2\2\2/\u00a5\3\2\2\2\61\u00a7\3\2\2\2"+
		"\63\u00ad\3\2\2\2\65\u00b3\3\2\2\2\67\u00b6\3\2\2\29\u00bb\3\2\2\2;\u00bf"+
		"\3\2\2\2=\u00c3\3\2\2\2?\u00cc\3\2\2\2A\u00cf\3\2\2\2C\u00d2\3\2\2\2E"+
		"\u00d6\3\2\2\2G\u00da\3\2\2\2I\u00dd\3\2\2\2K\u00e2\3\2\2\2M\u00e5\3\2"+
		"\2\2O\u00ea\3\2\2\2Q\u00ee\3\2\2\2S\u00f4\3\2\2\2U\u00fc\3\2\2\2W\u0100"+
		"\3\2\2\2Y\u0109\3\2\2\2[\u0117\3\2\2\2]\u011d\3\2\2\2_\u0123\3\2\2\2a"+
		"\u012b\3\2\2\2c\u012f\3\2\2\2e\u0133\3\2\2\2g\u0138\3\2\2\2i\u013f\3\2"+
		"\2\2k\u0146\3\2\2\2m\u014a\3\2\2\2o\u014f\3\2\2\2q\u0153\3\2\2\2s\u015a"+
		"\3\2\2\2uv\7*\2\2v\4\3\2\2\2wx\7+\2\2x\6\3\2\2\2yz\7]\2\2z\b\3\2\2\2{"+
		"|\7_\2\2|\n\3\2\2\2}~\7}\2\2~\f\3\2\2\2\177\u0080\7\177\2\2\u0080\16\3"+
		"\2\2\2\u0081\u0082\7<\2\2\u0082\20\3\2\2\2\u0083\u0084\7<\2\2\u0084\u0085"+
		"\7?\2\2\u0085\22\3\2\2\2\u0086\u0087\7\60\2\2\u0087\24\3\2\2\2\u0088\u0089"+
		"\7.\2\2\u0089\26\3\2\2\2\u008a\u008b\7=\2\2\u008b\30\3\2\2\2\u008c\u008d"+
		"\7-\2\2\u008d\32\3\2\2\2\u008e\u008f\7/\2\2\u008f\34\3\2\2\2\u0090\u0091"+
		"\7,\2\2\u0091\36\3\2\2\2\u0092\u0093\7\61\2\2\u0093 \3\2\2\2\u0094\u0095"+
		"\7?\2\2\u0095\"\3\2\2\2\u0096\u0097\7>\2\2\u0097\u0098\7@\2\2\u0098$\3"+
		"\2\2\2\u0099\u009a\7>\2\2\u009a&\3\2\2\2\u009b\u009c\7>\2\2\u009c\u009d"+
		"\7?\2\2\u009d(\3\2\2\2\u009e\u009f\7@\2\2\u009f*\3\2\2\2\u00a0\u00a1\7"+
		"@\2\2\u00a1\u00a2\7?\2\2\u00a2,\3\2\2\2\u00a3\u00a4\7(\2\2\u00a4.\3\2"+
		"\2\2\u00a5\u00a6\7~\2\2\u00a6\60\3\2\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9"+
		"\7t\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7c\2\2\u00ab\u00ac\7{\2\2\u00ac"+
		"\62\3\2\2\2\u00ad\u00ae\7d\2\2\u00ae\u00af\7t\2\2\u00af\u00b0\7g\2\2\u00b0"+
		"\u00b1\7c\2\2\u00b1\u00b2\7m\2\2\u00b2\64\3\2\2\2\u00b3\u00b4\7f\2\2\u00b4"+
		"\u00b5\7q\2\2\u00b5\66\3\2\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7n\2\2\u00b8"+
		"\u00b9\7u\2\2\u00b9\u00ba\7g\2\2\u00ba8\3\2\2\2\u00bb\u00bc\7g\2\2\u00bc"+
		"\u00bd\7p\2\2\u00bd\u00be\7f\2\2\u00be:\3\2\2\2\u00bf\u00c0\7h\2\2\u00c0"+
		"\u00c1\7q\2\2\u00c1\u00c2\7t\2\2\u00c2<\3\2\2\2\u00c3\u00c4\7h\2\2\u00c4"+
		"\u00c5\7w\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7\7e\2\2\u00c7\u00c8\7v\2\2"+
		"\u00c8\u00c9\7k\2\2\u00c9\u00ca\7q\2\2\u00ca\u00cb\7p\2\2\u00cb>\3\2\2"+
		"\2\u00cc\u00cd\7k\2\2\u00cd\u00ce\7h\2\2\u00ce@\3\2\2\2\u00cf\u00d0\7"+
		"k\2\2\u00d0\u00d1\7p\2\2\u00d1B\3\2\2\2\u00d2\u00d3\7n\2\2\u00d3\u00d4"+
		"\7g\2\2\u00d4\u00d5\7v\2\2\u00d5D\3\2\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8"+
		"\7k\2\2\u00d8\u00d9\7n\2\2\u00d9F\3\2\2\2\u00da\u00db\7q\2\2\u00db\u00dc"+
		"\7h\2\2\u00dcH\3\2\2\2\u00dd\u00de\7v\2\2\u00de\u00df\7j\2\2\u00df\u00e0"+
		"\7g\2\2\u00e0\u00e1\7p\2\2\u00e1J\3\2\2\2\u00e2\u00e3\7v\2\2\u00e3\u00e4"+
		"\7q\2\2\u00e4L\3\2\2\2\u00e5\u00e6\7v\2\2\u00e6\u00e7\7{\2\2\u00e7\u00e8"+
		"\7r\2\2\u00e8\u00e9\7g\2\2\u00e9N\3\2\2\2\u00ea\u00eb\7x\2\2\u00eb\u00ec"+
		"\7c\2\2\u00ec\u00ed\7t\2\2\u00edP\3\2\2\2\u00ee\u00ef\7y\2\2\u00ef\u00f0"+
		"\7j\2\2\u00f0\u00f1\7k\2\2\u00f1\u00f2\7n\2\2\u00f2\u00f3\7g\2\2\u00f3"+
		"R\3\2\2\2\u00f4\u00f8\t\2\2\2\u00f5\u00f7\t\3\2\2\u00f6\u00f5\3\2\2\2"+
		"\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9T\3"+
		"\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fd\4\62;\2\u00fc\u00fb\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ffV\3\2\2\2"+
		"\u0100\u0104\7$\2\2\u0101\u0103\t\4\2\2\u0102\u0101\3\2\2\2\u0103\u0106"+
		"\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106"+
		"\u0104\3\2\2\2\u0107\u0108\7$\2\2\u0108X\3\2\2\2\u0109\u010a\7\61\2\2"+
		"\u010a\u010b\7,\2\2\u010b\u010f\3\2\2\2\u010c\u010e\13\2\2\2\u010d\u010c"+
		"\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110"+
		"\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\7,\2\2\u0113\u0114\7\61"+
		"\2\2\u0114\u0115\3\2\2\2\u0115\u0116\b-\2\2\u0116Z\3\2\2\2\u0117\u0118"+
		"\7r\2\2\u0118\u0119\7t\2\2\u0119\u011a\7k\2\2\u011a\u011b\7p\2\2\u011b"+
		"\u011c\7v\2\2\u011c\\\3\2\2\2\u011d\u011e\7h\2\2\u011e\u011f\7n\2\2\u011f"+
		"\u0120\7w\2\2\u0120\u0121\7u\2\2\u0121\u0122\7j\2\2\u0122^\3\2\2\2\u0123"+
		"\u0124\7i\2\2\u0124\u0125\7g\2\2\u0125\u0126\7v\2\2\u0126\u0127\7e\2\2"+
		"\u0127\u0128\7j\2\2\u0128\u0129\7c\2\2\u0129\u012a\7t\2\2\u012a`\3\2\2"+
		"\2\u012b\u012c\7q\2\2\u012c\u012d\7t\2\2\u012d\u012e\7f\2\2\u012eb\3\2"+
		"\2\2\u012f\u0130\7e\2\2\u0130\u0131\7j\2\2\u0131\u0132\7t\2\2\u0132d\3"+
		"\2\2\2\u0133\u0134\7u\2\2\u0134\u0135\7k\2\2\u0135\u0136\7|\2\2\u0136"+
		"\u0137\7g\2\2\u0137f\3\2\2\2\u0138\u0139\7u\2\2\u0139\u013a\7w\2\2\u013a"+
		"\u013b\7d\2\2\u013b\u013c\7u\2\2\u013c\u013d\7v\2\2\u013d\u013e\7t\2\2"+
		"\u013eh\3\2\2\2\u013f\u0140\7e\2\2\u0140\u0141\7q\2\2\u0141\u0142\7p\2"+
		"\2\u0142\u0143\7e\2\2\u0143\u0144\7c\2\2\u0144\u0145\7v\2\2\u0145j\3\2"+
		"\2\2\u0146\u0147\7p\2\2\u0147\u0148\7q\2\2\u0148\u0149\7v\2\2\u0149l\3"+
		"\2\2\2\u014a\u014b\7g\2\2\u014b\u014c\7z\2\2\u014c\u014d\7k\2\2\u014d"+
		"\u014e\7v\2\2\u014en\3\2\2\2\u014f\u0150\7k\2\2\u0150\u0151\7p\2\2\u0151"+
		"\u0152\7v\2\2\u0152p\3\2\2\2\u0153\u0154\7u\2\2\u0154\u0155\7v\2\2\u0155"+
		"\u0156\7t\2\2\u0156\u0157\7k\2\2\u0157\u0158\7p\2\2\u0158\u0159\7i\2\2"+
		"\u0159r\3\2\2\2\u015a\u015b\t\5\2\2\u015b\u015c\3\2\2\2\u015c\u015d\b"+
		":\2\2\u015dt\3\2\2\2\7\2\u00f8\u00fe\u0104\u010f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}