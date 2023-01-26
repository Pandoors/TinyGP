// Generated from java-escape by ANTLR 4.11.1
package visitor;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BobaroLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, INT_VAL=2, OR=3, AND=4, EQUAL=5, NOT_EQUAL=6, GREATER=7, LESS=8, 
		GREATER_EQUAL=9, LESS_EQUAL=10, BRACKET_L=11, BRACKET_R=12, SQ_BRACKET_L=13, 
		SQ_BRACKET_R=14, PARENT_L=15, PARENT_R=16, ADD_=17, SUBTRACT_=18, MULTIPLY=19, 
		DIVIDE=20, MODULO=21, IF=22, ELSE=23, WHILE=24, SEMICOLON=25, COMMA=26, 
		READ_OR_IN=27, IDENTIFIER=28, WS=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "INT_VAL", "OR", "AND", "EQUAL", "NOT_EQUAL", "GREATER", "LESS", 
			"GREATER_EQUAL", "LESS_EQUAL", "BRACKET_L", "BRACKET_R", "SQ_BRACKET_L", 
			"SQ_BRACKET_R", "PARENT_L", "PARENT_R", "ADD_", "SUBTRACT_", "MULTIPLY", 
			"DIVIDE", "MODULO", "IF", "ELSE", "WHILE", "SEMICOLON", "COMMA", "READ_OR_IN", 
			"IDENTIFIER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'printl('", null, "'||'", "'&&'", "'='", "'!='", "'>'", "'<'", 
			"'>='", "'<='", "'('", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'if'", "'else'", "'while'", "';'", "','", "'sysIn()'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "INT_VAL", "OR", "AND", "EQUAL", "NOT_EQUAL", "GREATER", 
			"LESS", "GREATER_EQUAL", "LESS_EQUAL", "BRACKET_L", "BRACKET_R", "SQ_BRACKET_L", 
			"SQ_BRACKET_R", "PARENT_L", "PARENT_R", "ADD_", "SUBTRACT_", "MULTIPLY", 
			"DIVIDE", "MODULO", "IF", "ELSE", "WHILE", "SEMICOLON", "COMMA", "READ_OR_IN", 
			"IDENTIFIER", "WS"
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


	public BobaroLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Bobaro.g4"; }

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
		"\u0004\u0000\u001d\u009d\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0005\u0001F\b\u0001\n\u0001\f\u0001I\t\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0001\u001b\u0005\u001b\u0092\b\u001b\n\u001b\f\u001b\u0095\t\u001b\u0001"+
		"\u001c\u0004\u001c\u0098\b\u001c\u000b\u001c\f\u001c\u0099\u0001\u001c"+
		"\u0001\u001c\u0000\u0000\u001d\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013"+
		"\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d"+
		"\u0001\u0000\u0004\u0001\u000009\u0002\u0000AZaz\u0003\u000009AZaz\u0003"+
		"\u0000\t\n\r\r  \u009f\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u0000"+
		"7\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0001;\u0001"+
		"\u0000\u0000\u0000\u0003C\u0001\u0000\u0000\u0000\u0005J\u0001\u0000\u0000"+
		"\u0000\u0007M\u0001\u0000\u0000\u0000\tP\u0001\u0000\u0000\u0000\u000b"+
		"R\u0001\u0000\u0000\u0000\rU\u0001\u0000\u0000\u0000\u000fW\u0001\u0000"+
		"\u0000\u0000\u0011Y\u0001\u0000\u0000\u0000\u0013\\\u0001\u0000\u0000"+
		"\u0000\u0015_\u0001\u0000\u0000\u0000\u0017a\u0001\u0000\u0000\u0000\u0019"+
		"c\u0001\u0000\u0000\u0000\u001be\u0001\u0000\u0000\u0000\u001dg\u0001"+
		"\u0000\u0000\u0000\u001fi\u0001\u0000\u0000\u0000!k\u0001\u0000\u0000"+
		"\u0000#m\u0001\u0000\u0000\u0000%o\u0001\u0000\u0000\u0000\'q\u0001\u0000"+
		"\u0000\u0000)s\u0001\u0000\u0000\u0000+u\u0001\u0000\u0000\u0000-x\u0001"+
		"\u0000\u0000\u0000/}\u0001\u0000\u0000\u00001\u0083\u0001\u0000\u0000"+
		"\u00003\u0085\u0001\u0000\u0000\u00005\u0087\u0001\u0000\u0000\u00007"+
		"\u008f\u0001\u0000\u0000\u00009\u0097\u0001\u0000\u0000\u0000;<\u0005"+
		"p\u0000\u0000<=\u0005r\u0000\u0000=>\u0005i\u0000\u0000>?\u0005n\u0000"+
		"\u0000?@\u0005t\u0000\u0000@A\u0005l\u0000\u0000AB\u0005(\u0000\u0000"+
		"B\u0002\u0001\u0000\u0000\u0000CG\u0007\u0000\u0000\u0000DF\u0007\u0000"+
		"\u0000\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000GE\u0001"+
		"\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000H\u0004\u0001\u0000\u0000"+
		"\u0000IG\u0001\u0000\u0000\u0000JK\u0005|\u0000\u0000KL\u0005|\u0000\u0000"+
		"L\u0006\u0001\u0000\u0000\u0000MN\u0005&\u0000\u0000NO\u0005&\u0000\u0000"+
		"O\b\u0001\u0000\u0000\u0000PQ\u0005=\u0000\u0000Q\n\u0001\u0000\u0000"+
		"\u0000RS\u0005!\u0000\u0000ST\u0005=\u0000\u0000T\f\u0001\u0000\u0000"+
		"\u0000UV\u0005>\u0000\u0000V\u000e\u0001\u0000\u0000\u0000WX\u0005<\u0000"+
		"\u0000X\u0010\u0001\u0000\u0000\u0000YZ\u0005>\u0000\u0000Z[\u0005=\u0000"+
		"\u0000[\u0012\u0001\u0000\u0000\u0000\\]\u0005<\u0000\u0000]^\u0005=\u0000"+
		"\u0000^\u0014\u0001\u0000\u0000\u0000_`\u0005(\u0000\u0000`\u0016\u0001"+
		"\u0000\u0000\u0000ab\u0005)\u0000\u0000b\u0018\u0001\u0000\u0000\u0000"+
		"cd\u0005[\u0000\u0000d\u001a\u0001\u0000\u0000\u0000ef\u0005]\u0000\u0000"+
		"f\u001c\u0001\u0000\u0000\u0000gh\u0005{\u0000\u0000h\u001e\u0001\u0000"+
		"\u0000\u0000ij\u0005}\u0000\u0000j \u0001\u0000\u0000\u0000kl\u0005+\u0000"+
		"\u0000l\"\u0001\u0000\u0000\u0000mn\u0005-\u0000\u0000n$\u0001\u0000\u0000"+
		"\u0000op\u0005*\u0000\u0000p&\u0001\u0000\u0000\u0000qr\u0005/\u0000\u0000"+
		"r(\u0001\u0000\u0000\u0000st\u0005%\u0000\u0000t*\u0001\u0000\u0000\u0000"+
		"uv\u0005i\u0000\u0000vw\u0005f\u0000\u0000w,\u0001\u0000\u0000\u0000x"+
		"y\u0005e\u0000\u0000yz\u0005l\u0000\u0000z{\u0005s\u0000\u0000{|\u0005"+
		"e\u0000\u0000|.\u0001\u0000\u0000\u0000}~\u0005w\u0000\u0000~\u007f\u0005"+
		"h\u0000\u0000\u007f\u0080\u0005i\u0000\u0000\u0080\u0081\u0005l\u0000"+
		"\u0000\u0081\u0082\u0005e\u0000\u0000\u00820\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0005;\u0000\u0000\u00842\u0001\u0000\u0000\u0000\u0085\u0086\u0005"+
		",\u0000\u0000\u00864\u0001\u0000\u0000\u0000\u0087\u0088\u0005s\u0000"+
		"\u0000\u0088\u0089\u0005y\u0000\u0000\u0089\u008a\u0005s\u0000\u0000\u008a"+
		"\u008b\u0005I\u0000\u0000\u008b\u008c\u0005n\u0000\u0000\u008c\u008d\u0005"+
		"(\u0000\u0000\u008d\u008e\u0005)\u0000\u0000\u008e6\u0001\u0000\u0000"+
		"\u0000\u008f\u0093\u0007\u0001\u0000\u0000\u0090\u0092\u0007\u0002\u0000"+
		"\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000\u0000"+
		"\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000"+
		"\u0000\u00948\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000"+
		"\u0096\u0098\u0007\u0003\u0000\u0000\u0097\u0096\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0006\u001c\u0000\u0000\u009c:\u0001\u0000\u0000\u0000\u0004"+
		"\u0000G\u0093\u0099\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}