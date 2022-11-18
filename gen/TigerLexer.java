// Generated from /home/louis/Documents/projet/serrand1u/TigerLexer.g4 by ANTLR 4.10.1

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
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

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
		"\u0004\u00009\u015c\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u00027\u00077\u00028\u00078\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001"+
		" \u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'"+
		"\u0001\'\u0001(\u0001(\u0005(\u00f5\b(\n(\f(\u00f8\t(\u0001)\u0004)\u00fb"+
		"\b)\u000b)\f)\u00fc\u0001*\u0001*\u0005*\u0101\b*\n*\f*\u0104\t*\u0001"+
		"*\u0001*\u0001+\u0001+\u0001+\u0001+\u0005+\u010c\b+\n+\f+\u010f\t+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001"+
		",\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001"+
		".\u0001.\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u0001/\u00010\u0001"+
		"0\u00010\u00010\u00011\u00011\u00011\u00011\u00011\u00012\u00012\u0001"+
		"2\u00012\u00012\u00012\u00012\u00013\u00013\u00013\u00013\u00013\u0001"+
		"3\u00013\u00014\u00014\u00014\u00014\u00015\u00015\u00015\u00015\u0001"+
		"5\u00016\u00016\u00016\u00016\u00017\u00017\u00017\u00017\u00017\u0001"+
		"7\u00017\u00018\u00018\u00018\u00018\u0001\u010d\u00009\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a"+
		"5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/"+
		"_0a1c2e3g4i5k6m7o8q9\u0001\u0000\u0004\u0002\u0000AZaz\u0004\u000009A"+
		"Z__az\u0004\u0000 !#&([]~\u0003\u0000\t\n\r\r  \u015f\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000"+
		"\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000"+
		"\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005"+
		"\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000"+
		"\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000"+
		"\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C"+
		"\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000"+
		"\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000"+
		"\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q"+
		"\u0001\u0000\u0000\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000"+
		"\u0000\u0000\u0000W\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000"+
		"\u0000[\u0001\u0000\u0000\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_"+
		"\u0001\u0000\u0000\u0000\u0000a\u0001\u0000\u0000\u0000\u0000c\u0001\u0000"+
		"\u0000\u0000\u0000e\u0001\u0000\u0000\u0000\u0000g\u0001\u0000\u0000\u0000"+
		"\u0000i\u0001\u0000\u0000\u0000\u0000k\u0001\u0000\u0000\u0000\u0000m"+
		"\u0001\u0000\u0000\u0000\u0000o\u0001\u0000\u0000\u0000\u0000q\u0001\u0000"+
		"\u0000\u0000\u0001s\u0001\u0000\u0000\u0000\u0003u\u0001\u0000\u0000\u0000"+
		"\u0005w\u0001\u0000\u0000\u0000\u0007y\u0001\u0000\u0000\u0000\t{\u0001"+
		"\u0000\u0000\u0000\u000b}\u0001\u0000\u0000\u0000\r\u007f\u0001\u0000"+
		"\u0000\u0000\u000f\u0081\u0001\u0000\u0000\u0000\u0011\u0084\u0001\u0000"+
		"\u0000\u0000\u0013\u0086\u0001\u0000\u0000\u0000\u0015\u0088\u0001\u0000"+
		"\u0000\u0000\u0017\u008a\u0001\u0000\u0000\u0000\u0019\u008c\u0001\u0000"+
		"\u0000\u0000\u001b\u008e\u0001\u0000\u0000\u0000\u001d\u0090\u0001\u0000"+
		"\u0000\u0000\u001f\u0092\u0001\u0000\u0000\u0000!\u0094\u0001\u0000\u0000"+
		"\u0000#\u0097\u0001\u0000\u0000\u0000%\u0099\u0001\u0000\u0000\u0000\'"+
		"\u009c\u0001\u0000\u0000\u0000)\u009e\u0001\u0000\u0000\u0000+\u00a1\u0001"+
		"\u0000\u0000\u0000-\u00a3\u0001\u0000\u0000\u0000/\u00a5\u0001\u0000\u0000"+
		"\u00001\u00ab\u0001\u0000\u0000\u00003\u00b1\u0001\u0000\u0000\u00005"+
		"\u00b4\u0001\u0000\u0000\u00007\u00b9\u0001\u0000\u0000\u00009\u00bd\u0001"+
		"\u0000\u0000\u0000;\u00c1\u0001\u0000\u0000\u0000=\u00ca\u0001\u0000\u0000"+
		"\u0000?\u00cd\u0001\u0000\u0000\u0000A\u00d0\u0001\u0000\u0000\u0000C"+
		"\u00d4\u0001\u0000\u0000\u0000E\u00d8\u0001\u0000\u0000\u0000G\u00db\u0001"+
		"\u0000\u0000\u0000I\u00e0\u0001\u0000\u0000\u0000K\u00e3\u0001\u0000\u0000"+
		"\u0000M\u00e8\u0001\u0000\u0000\u0000O\u00ec\u0001\u0000\u0000\u0000Q"+
		"\u00f2\u0001\u0000\u0000\u0000S\u00fa\u0001\u0000\u0000\u0000U\u00fe\u0001"+
		"\u0000\u0000\u0000W\u0107\u0001\u0000\u0000\u0000Y\u0115\u0001\u0000\u0000"+
		"\u0000[\u011b\u0001\u0000\u0000\u0000]\u0121\u0001\u0000\u0000\u0000_"+
		"\u0129\u0001\u0000\u0000\u0000a\u012d\u0001\u0000\u0000\u0000c\u0131\u0001"+
		"\u0000\u0000\u0000e\u0136\u0001\u0000\u0000\u0000g\u013d\u0001\u0000\u0000"+
		"\u0000i\u0144\u0001\u0000\u0000\u0000k\u0148\u0001\u0000\u0000\u0000m"+
		"\u014d\u0001\u0000\u0000\u0000o\u0151\u0001\u0000\u0000\u0000q\u0158\u0001"+
		"\u0000\u0000\u0000st\u0005(\u0000\u0000t\u0002\u0001\u0000\u0000\u0000"+
		"uv\u0005)\u0000\u0000v\u0004\u0001\u0000\u0000\u0000wx\u0005[\u0000\u0000"+
		"x\u0006\u0001\u0000\u0000\u0000yz\u0005]\u0000\u0000z\b\u0001\u0000\u0000"+
		"\u0000{|\u0005{\u0000\u0000|\n\u0001\u0000\u0000\u0000}~\u0005}\u0000"+
		"\u0000~\f\u0001\u0000\u0000\u0000\u007f\u0080\u0005:\u0000\u0000\u0080"+
		"\u000e\u0001\u0000\u0000\u0000\u0081\u0082\u0005:\u0000\u0000\u0082\u0083"+
		"\u0005=\u0000\u0000\u0083\u0010\u0001\u0000\u0000\u0000\u0084\u0085\u0005"+
		".\u0000\u0000\u0085\u0012\u0001\u0000\u0000\u0000\u0086\u0087\u0005,\u0000"+
		"\u0000\u0087\u0014\u0001\u0000\u0000\u0000\u0088\u0089\u0005;\u0000\u0000"+
		"\u0089\u0016\u0001\u0000\u0000\u0000\u008a\u008b\u0005+\u0000\u0000\u008b"+
		"\u0018\u0001\u0000\u0000\u0000\u008c\u008d\u0005-\u0000\u0000\u008d\u001a"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0005*\u0000\u0000\u008f\u001c\u0001"+
		"\u0000\u0000\u0000\u0090\u0091\u0005/\u0000\u0000\u0091\u001e\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0005=\u0000\u0000\u0093 \u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0005<\u0000\u0000\u0095\u0096\u0005>\u0000\u0000\u0096\""+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0005<\u0000\u0000\u0098$\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0005<\u0000\u0000\u009a\u009b\u0005=\u0000\u0000"+
		"\u009b&\u0001\u0000\u0000\u0000\u009c\u009d\u0005>\u0000\u0000\u009d("+
		"\u0001\u0000\u0000\u0000\u009e\u009f\u0005>\u0000\u0000\u009f\u00a0\u0005"+
		"=\u0000\u0000\u00a0*\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005&\u0000"+
		"\u0000\u00a2,\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005|\u0000\u0000\u00a4"+
		".\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005a\u0000\u0000\u00a6\u00a7\u0005"+
		"r\u0000\u0000\u00a7\u00a8\u0005r\u0000\u0000\u00a8\u00a9\u0005a\u0000"+
		"\u0000\u00a9\u00aa\u0005y\u0000\u0000\u00aa0\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u0005b\u0000\u0000\u00ac\u00ad\u0005r\u0000\u0000\u00ad\u00ae\u0005"+
		"e\u0000\u0000\u00ae\u00af\u0005a\u0000\u0000\u00af\u00b0\u0005k\u0000"+
		"\u0000\u00b02\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005d\u0000\u0000\u00b2"+
		"\u00b3\u0005o\u0000\u0000\u00b34\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005"+
		"e\u0000\u0000\u00b5\u00b6\u0005l\u0000\u0000\u00b6\u00b7\u0005s\u0000"+
		"\u0000\u00b7\u00b8\u0005e\u0000\u0000\u00b86\u0001\u0000\u0000\u0000\u00b9"+
		"\u00ba\u0005e\u0000\u0000\u00ba\u00bb\u0005n\u0000\u0000\u00bb\u00bc\u0005"+
		"d\u0000\u0000\u00bc8\u0001\u0000\u0000\u0000\u00bd\u00be\u0005f\u0000"+
		"\u0000\u00be\u00bf\u0005o\u0000\u0000\u00bf\u00c0\u0005r\u0000\u0000\u00c0"+
		":\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005f\u0000\u0000\u00c2\u00c3\u0005"+
		"u\u0000\u0000\u00c3\u00c4\u0005n\u0000\u0000\u00c4\u00c5\u0005c\u0000"+
		"\u0000\u00c5\u00c6\u0005t\u0000\u0000\u00c6\u00c7\u0005i\u0000\u0000\u00c7"+
		"\u00c8\u0005o\u0000\u0000\u00c8\u00c9\u0005n\u0000\u0000\u00c9<\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cb\u0005i\u0000\u0000\u00cb\u00cc\u0005f\u0000"+
		"\u0000\u00cc>\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005i\u0000\u0000\u00ce"+
		"\u00cf\u0005n\u0000\u0000\u00cf@\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005"+
		"l\u0000\u0000\u00d1\u00d2\u0005e\u0000\u0000\u00d2\u00d3\u0005t\u0000"+
		"\u0000\u00d3B\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005n\u0000\u0000\u00d5"+
		"\u00d6\u0005i\u0000\u0000\u00d6\u00d7\u0005l\u0000\u0000\u00d7D\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d9\u0005o\u0000\u0000\u00d9\u00da\u0005f\u0000"+
		"\u0000\u00daF\u0001\u0000\u0000\u0000\u00db\u00dc\u0005t\u0000\u0000\u00dc"+
		"\u00dd\u0005h\u0000\u0000\u00dd\u00de\u0005e\u0000\u0000\u00de\u00df\u0005"+
		"n\u0000\u0000\u00dfH\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005t\u0000"+
		"\u0000\u00e1\u00e2\u0005o\u0000\u0000\u00e2J\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e4\u0005t\u0000\u0000\u00e4\u00e5\u0005y\u0000\u0000\u00e5\u00e6\u0005"+
		"p\u0000\u0000\u00e6\u00e7\u0005e\u0000\u0000\u00e7L\u0001\u0000\u0000"+
		"\u0000\u00e8\u00e9\u0005v\u0000\u0000\u00e9\u00ea\u0005a\u0000\u0000\u00ea"+
		"\u00eb\u0005r\u0000\u0000\u00ebN\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005"+
		"w\u0000\u0000\u00ed\u00ee\u0005h\u0000\u0000\u00ee\u00ef\u0005i\u0000"+
		"\u0000\u00ef\u00f0\u0005l\u0000\u0000\u00f0\u00f1\u0005e\u0000\u0000\u00f1"+
		"P\u0001\u0000\u0000\u0000\u00f2\u00f6\u0007\u0000\u0000\u0000\u00f3\u00f5"+
		"\u0007\u0001\u0000\u0000\u00f4\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f8"+
		"\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f6\u00f7"+
		"\u0001\u0000\u0000\u0000\u00f7R\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fb\u000209\u0000\u00fa\u00f9\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fdT\u0001\u0000\u0000\u0000"+
		"\u00fe\u0102\u0005\"\u0000\u0000\u00ff\u0101\u0007\u0002\u0000\u0000\u0100"+
		"\u00ff\u0001\u0000\u0000\u0000\u0101\u0104\u0001\u0000\u0000\u0000\u0102"+
		"\u0100\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103"+
		"\u0105\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0105"+
		"\u0106\u0005\"\u0000\u0000\u0106V\u0001\u0000\u0000\u0000\u0107\u0108"+
		"\u0005/\u0000\u0000\u0108\u0109\u0005*\u0000\u0000\u0109\u010d\u0001\u0000"+
		"\u0000\u0000\u010a\u010c\t\u0000\u0000\u0000\u010b\u010a\u0001\u0000\u0000"+
		"\u0000\u010c\u010f\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000"+
		"\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010e\u0110\u0001\u0000\u0000"+
		"\u0000\u010f\u010d\u0001\u0000\u0000\u0000\u0110\u0111\u0005*\u0000\u0000"+
		"\u0111\u0112\u0005/\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113"+
		"\u0114\u0006+\u0000\u0000\u0114X\u0001\u0000\u0000\u0000\u0115\u0116\u0005"+
		"p\u0000\u0000\u0116\u0117\u0005r\u0000\u0000\u0117\u0118\u0005i\u0000"+
		"\u0000\u0118\u0119\u0005n\u0000\u0000\u0119\u011a\u0005t\u0000\u0000\u011a"+
		"Z\u0001\u0000\u0000\u0000\u011b\u011c\u0005f\u0000\u0000\u011c\u011d\u0005"+
		"l\u0000\u0000\u011d\u011e\u0005u\u0000\u0000\u011e\u011f\u0005s\u0000"+
		"\u0000\u011f\u0120\u0005h\u0000\u0000\u0120\\\u0001\u0000\u0000\u0000"+
		"\u0121\u0122\u0005g\u0000\u0000\u0122\u0123\u0005e\u0000\u0000\u0123\u0124"+
		"\u0005t\u0000\u0000\u0124\u0125\u0005c\u0000\u0000\u0125\u0126\u0005h"+
		"\u0000\u0000\u0126\u0127\u0005a\u0000\u0000\u0127\u0128\u0005r\u0000\u0000"+
		"\u0128^\u0001\u0000\u0000\u0000\u0129\u012a\u0005o\u0000\u0000\u012a\u012b"+
		"\u0005r\u0000\u0000\u012b\u012c\u0005d\u0000\u0000\u012c`\u0001\u0000"+
		"\u0000\u0000\u012d\u012e\u0005c\u0000\u0000\u012e\u012f\u0005h\u0000\u0000"+
		"\u012f\u0130\u0005r\u0000\u0000\u0130b\u0001\u0000\u0000\u0000\u0131\u0132"+
		"\u0005s\u0000\u0000\u0132\u0133\u0005i\u0000\u0000\u0133\u0134\u0005z"+
		"\u0000\u0000\u0134\u0135\u0005e\u0000\u0000\u0135d\u0001\u0000\u0000\u0000"+
		"\u0136\u0137\u0005s\u0000\u0000\u0137\u0138\u0005u\u0000\u0000\u0138\u0139"+
		"\u0005b\u0000\u0000\u0139\u013a\u0005s\u0000\u0000\u013a\u013b\u0005t"+
		"\u0000\u0000\u013b\u013c\u0005r\u0000\u0000\u013cf\u0001\u0000\u0000\u0000"+
		"\u013d\u013e\u0005c\u0000\u0000\u013e\u013f\u0005o\u0000\u0000\u013f\u0140"+
		"\u0005n\u0000\u0000\u0140\u0141\u0005c\u0000\u0000\u0141\u0142\u0005a"+
		"\u0000\u0000\u0142\u0143\u0005t\u0000\u0000\u0143h\u0001\u0000\u0000\u0000"+
		"\u0144\u0145\u0005n\u0000\u0000\u0145\u0146\u0005o\u0000\u0000\u0146\u0147"+
		"\u0005t\u0000\u0000\u0147j\u0001\u0000\u0000\u0000\u0148\u0149\u0005e"+
		"\u0000\u0000\u0149\u014a\u0005x\u0000\u0000\u014a\u014b\u0005i\u0000\u0000"+
		"\u014b\u014c\u0005t\u0000\u0000\u014cl\u0001\u0000\u0000\u0000\u014d\u014e"+
		"\u0005i\u0000\u0000\u014e\u014f\u0005n\u0000\u0000\u014f\u0150\u0005t"+
		"\u0000\u0000\u0150n\u0001\u0000\u0000\u0000\u0151\u0152\u0005s\u0000\u0000"+
		"\u0152\u0153\u0005t\u0000\u0000\u0153\u0154\u0005r\u0000\u0000\u0154\u0155"+
		"\u0005i\u0000\u0000\u0155\u0156\u0005n\u0000\u0000\u0156\u0157\u0005g"+
		"\u0000\u0000\u0157p\u0001\u0000\u0000\u0000\u0158\u0159\u0007\u0003\u0000"+
		"\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a\u015b\u00068\u0000\u0000"+
		"\u015br\u0001\u0000\u0000\u0000\u0005\u0000\u00f6\u00fc\u0102\u010d\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}