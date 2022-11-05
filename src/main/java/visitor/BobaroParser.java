// Generated from /Users/bartosz/IdeaProjects/TinyGP/src/main/java/antlr/Bobaro.g4 by ANTLR 4.10.1
package visitor;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BobaroParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, INT_VAL=3, STRING_VAL=4, BOOL=5, NULL=6, COMMENT=7, OR=8, 
		AND=9, EQUAL=10, INT=11, TRUE=12, FALSE=13, STRING=14, NOT_EQUAL=15, GREATER=16, 
		LESS=17, GREATER_EQUAL=18, LESS_EQUAL=19, BRACKET_L=20, BRACKET_R=21, 
		SQ_BRACKET_L=22, SQ_BRACKET_R=23, PARENT_L=24, PARENT_R=25, ADD_=26, SUBTRACT_=27, 
		MULTIPLY=28, DIVIDE=29, MODULO=30, IF=31, ELSE=32, FOR=33, SEMICOLON=34, 
		COMMA=35, IDENTIFIER=36, WS=37;
	public static final int
		RULE_program = 0, RULE_readOrIn = 1, RULE_writeOrOut = 2, RULE_math_symbol = 3, 
		RULE_bool_val = 4, RULE_num_val = 5, RULE_math_expr = 6, RULE_assignment = 7, 
		RULE_if_statement = 8, RULE_logic_condition = 9, RULE_comparison = 10, 
		RULE_logic_statement = 11, RULE_logic_operator = 12, RULE_comparator = 13, 
		RULE_for_loop = 14, RULE_instruction = 15, RULE_instruction_general = 16, 
		RULE_modification = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "readOrIn", "writeOrOut", "math_symbol", "bool_val", "num_val", 
			"math_expr", "assignment", "if_statement", "logic_condition", "comparison", 
			"logic_statement", "logic_operator", "comparator", "for_loop", "instruction", 
			"instruction_general", "modification"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'sysIn()'", "'printl('", null, null, "'boolean'", "'null'", null, 
			"'||'", "'&&'", "'='", "'int'", "'true'", "'false'", "'string'", "'!='", 
			"'>'", "'<'", "'>='", "'<='", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'if'", "'else'", "'for'", "';'", 
			"','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "INT_VAL", "STRING_VAL", "BOOL", "NULL", "COMMENT", 
			"OR", "AND", "EQUAL", "INT", "TRUE", "FALSE", "STRING", "NOT_EQUAL", 
			"GREATER", "LESS", "GREATER_EQUAL", "LESS_EQUAL", "BRACKET_L", "BRACKET_R", 
			"SQ_BRACKET_L", "SQ_BRACKET_R", "PARENT_L", "PARENT_R", "ADD_", "SUBTRACT_", 
			"MULTIPLY", "DIVIDE", "MODULO", "IF", "ELSE", "FOR", "SEMICOLON", "COMMA", 
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

	@Override
	public String getGrammarFileName() { return "Bobaro.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BobaroParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public Instruction_generalContext instruction_general() {
			return getRuleContext(Instruction_generalContext.class,0);
		}
		public TerminalNode EOF() { return getToken(BobaroParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			setState(38);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				instruction_general();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				match(EOF);
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

	public static class ReadOrInContext extends ParserRuleContext {
		public ReadOrInContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readOrIn; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitReadOrIn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadOrInContext readOrIn() throws RecognitionException {
		ReadOrInContext _localctx = new ReadOrInContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_readOrIn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__0);
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

	public static class WriteOrOutContext extends ParserRuleContext {
		public TerminalNode STRING_VAL() { return getToken(BobaroParser.STRING_VAL, 0); }
		public TerminalNode BRACKET_R() { return getToken(BobaroParser.BRACKET_R, 0); }
		public TerminalNode SEMICOLON() { return getToken(BobaroParser.SEMICOLON, 0); }
		public WriteOrOutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeOrOut; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitWriteOrOut(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteOrOutContext writeOrOut() throws RecognitionException {
		WriteOrOutContext _localctx = new WriteOrOutContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_writeOrOut);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__1);
			setState(43);
			match(STRING_VAL);
			setState(44);
			match(BRACKET_R);
			setState(45);
			match(SEMICOLON);
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

	public static class Math_symbolContext extends ParserRuleContext {
		public TerminalNode ADD_() { return getToken(BobaroParser.ADD_, 0); }
		public TerminalNode SUBTRACT_() { return getToken(BobaroParser.SUBTRACT_, 0); }
		public TerminalNode MULTIPLY() { return getToken(BobaroParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(BobaroParser.DIVIDE, 0); }
		public Math_symbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_symbol; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitMath_symbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_symbolContext math_symbol() throws RecognitionException {
		Math_symbolContext _localctx = new Math_symbolContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_math_symbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD_) | (1L << SUBTRACT_) | (1L << MULTIPLY) | (1L << DIVIDE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class Bool_valContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(BobaroParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(BobaroParser.FALSE, 0); }
		public Bool_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_val; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitBool_val(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_valContext bool_val() throws RecognitionException {
		Bool_valContext _localctx = new Bool_valContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bool_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class Num_valContext extends ParserRuleContext {
		public TerminalNode INT_VAL() { return getToken(BobaroParser.INT_VAL, 0); }
		public TerminalNode ADD_() { return getToken(BobaroParser.ADD_, 0); }
		public TerminalNode SUBTRACT_() { return getToken(BobaroParser.SUBTRACT_, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BobaroParser.IDENTIFIER, 0); }
		public Num_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num_val; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitNum_val(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Num_valContext num_val() throws RecognitionException {
		Num_valContext _localctx = new Num_valContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_num_val);
		int _la;
		try {
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ADD_ || _la==SUBTRACT_) {
					{
					setState(51);
					_la = _input.LA(1);
					if ( !(_la==ADD_ || _la==SUBTRACT_) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(54);
				match(INT_VAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ADD_ || _la==SUBTRACT_) {
					{
					setState(55);
					_la = _input.LA(1);
					if ( !(_la==ADD_ || _la==SUBTRACT_) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(58);
				match(IDENTIFIER);
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

	public static class Math_exprContext extends ParserRuleContext {
		public TerminalNode BRACKET_L() { return getToken(BobaroParser.BRACKET_L, 0); }
		public List<Math_exprContext> math_expr() {
			return getRuleContexts(Math_exprContext.class);
		}
		public Math_exprContext math_expr(int i) {
			return getRuleContext(Math_exprContext.class,i);
		}
		public TerminalNode BRACKET_R() { return getToken(BobaroParser.BRACKET_R, 0); }
		public Num_valContext num_val() {
			return getRuleContext(Num_valContext.class,0);
		}
		public Math_symbolContext math_symbol() {
			return getRuleContext(Math_symbolContext.class,0);
		}
		public Math_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitMath_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_exprContext math_expr() throws RecognitionException {
		return math_expr(0);
	}

	private Math_exprContext math_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Math_exprContext _localctx = new Math_exprContext(_ctx, _parentState);
		Math_exprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_math_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_L:
				{
				setState(62);
				match(BRACKET_L);
				setState(63);
				math_expr(0);
				setState(64);
				match(BRACKET_R);
				}
				break;
			case INT_VAL:
			case ADD_:
			case SUBTRACT_:
			case IDENTIFIER:
				{
				setState(66);
				num_val();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(75);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Math_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_math_expr);
					setState(69);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(70);
					math_symbol();
					setState(71);
					math_expr(4);
					}
					} 
				}
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(BobaroParser.INT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BobaroParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(BobaroParser.EQUAL, 0); }
		public Math_exprContext math_expr() {
			return getRuleContext(Math_exprContext.class,0);
		}
		public ReadOrInContext readOrIn() {
			return getRuleContext(ReadOrInContext.class,0);
		}
		public TerminalNode STRING() { return getToken(BobaroParser.STRING, 0); }
		public TerminalNode STRING_VAL() { return getToken(BobaroParser.STRING_VAL, 0); }
		public TerminalNode BOOL() { return getToken(BobaroParser.BOOL, 0); }
		public Bool_valContext bool_val() {
			return getRuleContext(Bool_valContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignment);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(INT);
				setState(79);
				match(IDENTIFIER);
				setState(80);
				match(EQUAL);
				setState(83);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
				case BRACKET_L:
				case ADD_:
				case SUBTRACT_:
				case IDENTIFIER:
					{
					setState(81);
					math_expr(0);
					}
					break;
				case T__0:
					{
					setState(82);
					readOrIn();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(STRING);
				setState(86);
				match(IDENTIFIER);
				setState(87);
				match(EQUAL);
				setState(90);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING_VAL:
					{
					setState(88);
					match(STRING_VAL);
					}
					break;
				case T__0:
					{
					setState(89);
					readOrIn();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(92);
				match(BOOL);
				setState(93);
				match(IDENTIFIER);
				setState(94);
				match(EQUAL);
				setState(97);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TRUE:
				case FALSE:
					{
					setState(95);
					bool_val();
					}
					break;
				case T__0:
					{
					setState(96);
					readOrIn();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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

	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(BobaroParser.IF, 0); }
		public Logic_conditionContext logic_condition() {
			return getRuleContext(Logic_conditionContext.class,0);
		}
		public TerminalNode PARENT_L() { return getToken(BobaroParser.PARENT_L, 0); }
		public Instruction_generalContext instruction_general() {
			return getRuleContext(Instruction_generalContext.class,0);
		}
		public TerminalNode PARENT_R() { return getToken(BobaroParser.PARENT_R, 0); }
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(IF);
			setState(102);
			logic_condition();
			setState(103);
			match(PARENT_L);
			setState(104);
			instruction_general();
			setState(105);
			match(PARENT_R);
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

	public static class Logic_conditionContext extends ParserRuleContext {
		public TerminalNode BRACKET_L() { return getToken(BobaroParser.BRACKET_L, 0); }
		public List<Logic_statementContext> logic_statement() {
			return getRuleContexts(Logic_statementContext.class);
		}
		public Logic_statementContext logic_statement(int i) {
			return getRuleContext(Logic_statementContext.class,i);
		}
		public TerminalNode BRACKET_R() { return getToken(BobaroParser.BRACKET_R, 0); }
		public List<Logic_operatorContext> logic_operator() {
			return getRuleContexts(Logic_operatorContext.class);
		}
		public Logic_operatorContext logic_operator(int i) {
			return getRuleContext(Logic_operatorContext.class,i);
		}
		public Logic_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitLogic_condition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logic_conditionContext logic_condition() throws RecognitionException {
		Logic_conditionContext _localctx = new Logic_conditionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_logic_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(BRACKET_L);
			setState(108);
			logic_statement();
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR || _la==AND) {
				{
				{
				setState(109);
				logic_operator();
				setState(110);
				logic_statement();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			match(BRACKET_R);
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

	public static class ComparisonContext extends ParserRuleContext {
		public List<Num_valContext> num_val() {
			return getRuleContexts(Num_valContext.class);
		}
		public Num_valContext num_val(int i) {
			return getRuleContext(Num_valContext.class,i);
		}
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			num_val();
			setState(120);
			comparator();
			setState(121);
			num_val();
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

	public static class Logic_statementContext extends ParserRuleContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public Bool_valContext bool_val() {
			return getRuleContext(Bool_valContext.class,0);
		}
		public Logic_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitLogic_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logic_statementContext logic_statement() throws RecognitionException {
		Logic_statementContext _localctx = new Logic_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_logic_statement);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_VAL:
			case ADD_:
			case SUBTRACT_:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				comparison();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				bool_val();
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

	public static class Logic_operatorContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(BobaroParser.OR, 0); }
		public TerminalNode AND() { return getToken(BobaroParser.AND, 0); }
		public Logic_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_operator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitLogic_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logic_operatorContext logic_operator() throws RecognitionException {
		Logic_operatorContext _localctx = new Logic_operatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_logic_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !(_la==OR || _la==AND) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class ComparatorContext extends ParserRuleContext {
		public List<TerminalNode> EQUAL() { return getTokens(BobaroParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(BobaroParser.EQUAL, i);
		}
		public TerminalNode NOT_EQUAL() { return getToken(BobaroParser.NOT_EQUAL, 0); }
		public TerminalNode GREATER() { return getToken(BobaroParser.GREATER, 0); }
		public TerminalNode LESS() { return getToken(BobaroParser.LESS, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(BobaroParser.GREATER_EQUAL, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(BobaroParser.LESS_EQUAL, 0); }
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comparator);
		try {
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQUAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(EQUAL);
				setState(130);
				match(EQUAL);
				}
				break;
			case NOT_EQUAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(NOT_EQUAL);
				}
				break;
			case GREATER:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				match(GREATER);
				}
				break;
			case LESS:
				enterOuterAlt(_localctx, 4);
				{
				setState(133);
				match(LESS);
				}
				break;
			case GREATER_EQUAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(134);
				match(GREATER_EQUAL);
				}
				break;
			case LESS_EQUAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(135);
				match(LESS_EQUAL);
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

	public static class For_loopContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(BobaroParser.FOR, 0); }
		public TerminalNode BRACKET_L() { return getToken(BobaroParser.BRACKET_L, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(BobaroParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(BobaroParser.SEMICOLON, i);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public ModificationContext modification() {
			return getRuleContext(ModificationContext.class,0);
		}
		public TerminalNode BRACKET_R() { return getToken(BobaroParser.BRACKET_R, 0); }
		public TerminalNode PARENT_L() { return getToken(BobaroParser.PARENT_L, 0); }
		public Instruction_generalContext instruction_general() {
			return getRuleContext(Instruction_generalContext.class,0);
		}
		public TerminalNode PARENT_R() { return getToken(BobaroParser.PARENT_R, 0); }
		public For_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_loop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitFor_loop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_loopContext for_loop() throws RecognitionException {
		For_loopContext _localctx = new For_loopContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_for_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(FOR);
			setState(139);
			match(BRACKET_L);
			setState(140);
			assignment();
			setState(141);
			match(SEMICOLON);
			setState(142);
			comparison();
			setState(143);
			match(SEMICOLON);
			setState(144);
			modification();
			setState(145);
			match(BRACKET_R);
			setState(146);
			match(PARENT_L);
			setState(147);
			instruction_general();
			setState(148);
			match(PARENT_R);
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

	public static class InstructionContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BobaroParser.SEMICOLON, 0); }
		public ModificationContext modification() {
			return getRuleContext(ModificationContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public For_loopContext for_loop() {
			return getRuleContext(For_loopContext.class,0);
		}
		public WriteOrOutContext writeOrOut() {
			return getRuleContext(WriteOrOutContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_instruction);
		try {
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case INT:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				assignment();
				setState(151);
				match(SEMICOLON);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				modification();
				setState(154);
				match(SEMICOLON);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				if_statement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				for_loop();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 5);
				{
				setState(158);
				writeOrOut();
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

	public static class Instruction_generalContext extends ParserRuleContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(BobaroParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(BobaroParser.COMMENT, i);
		}
		public Instruction_generalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction_general; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitInstruction_general(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Instruction_generalContext instruction_general() throws RecognitionException {
		Instruction_generalContext _localctx = new Instruction_generalContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_instruction_general);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << BOOL) | (1L << COMMENT) | (1L << INT) | (1L << STRING) | (1L << IF) | (1L << FOR) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(163);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
				case BOOL:
				case INT:
				case STRING:
				case IF:
				case FOR:
				case IDENTIFIER:
					{
					setState(161);
					instruction();
					}
					break;
				case COMMENT:
					{
					setState(162);
					match(COMMENT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ModificationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BobaroParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(BobaroParser.EQUAL, 0); }
		public Math_exprContext math_expr() {
			return getRuleContext(Math_exprContext.class,0);
		}
		public ReadOrInContext readOrIn() {
			return getRuleContext(ReadOrInContext.class,0);
		}
		public ModificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitModification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModificationContext modification() throws RecognitionException {
		ModificationContext _localctx = new ModificationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_modification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(IDENTIFIER);
			setState(169);
			match(EQUAL);
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_VAL:
			case BRACKET_L:
			case ADD_:
			case SUBTRACT_:
			case IDENTIFIER:
				{
				setState(170);
				math_expr(0);
				}
				break;
			case T__0:
				{
				setState(171);
				readOrIn();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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
		case 6:
			return math_expr_sempred((Math_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean math_expr_sempred(Math_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u00af\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0003\u0000\'\b\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0003\u00055\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u00059\b\u0005\u0001\u0005\u0003\u0005<\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006D\b"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006J\b"+
		"\u0006\n\u0006\f\u0006M\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007T\b\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007[\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007b\b\u0007\u0003"+
		"\u0007d\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\tq\b\t\n\t\f\tt\t\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0003\u000b"+
		"~\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u0089\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00a0\b\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u00a4\b\u0010"+
		"\n\u0010\f\u0010\u00a7\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u00ad\b\u0011\u0001\u0011\u0000\u0001\f\u0012\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"\u0000\u0004\u0001\u0000\u001a\u001d\u0001\u0000\f\r\u0001\u0000"+
		"\u001a\u001b\u0001\u0000\b\t\u00b5\u0000&\u0001\u0000\u0000\u0000\u0002"+
		"(\u0001\u0000\u0000\u0000\u0004*\u0001\u0000\u0000\u0000\u0006/\u0001"+
		"\u0000\u0000\u0000\b1\u0001\u0000\u0000\u0000\n;\u0001\u0000\u0000\u0000"+
		"\fC\u0001\u0000\u0000\u0000\u000ec\u0001\u0000\u0000\u0000\u0010e\u0001"+
		"\u0000\u0000\u0000\u0012k\u0001\u0000\u0000\u0000\u0014w\u0001\u0000\u0000"+
		"\u0000\u0016}\u0001\u0000\u0000\u0000\u0018\u007f\u0001\u0000\u0000\u0000"+
		"\u001a\u0088\u0001\u0000\u0000\u0000\u001c\u008a\u0001\u0000\u0000\u0000"+
		"\u001e\u009f\u0001\u0000\u0000\u0000 \u00a5\u0001\u0000\u0000\u0000\""+
		"\u00a8\u0001\u0000\u0000\u0000$\'\u0003 \u0010\u0000%\'\u0005\u0000\u0000"+
		"\u0001&$\u0001\u0000\u0000\u0000&%\u0001\u0000\u0000\u0000\'\u0001\u0001"+
		"\u0000\u0000\u0000()\u0005\u0001\u0000\u0000)\u0003\u0001\u0000\u0000"+
		"\u0000*+\u0005\u0002\u0000\u0000+,\u0005\u0004\u0000\u0000,-\u0005\u0015"+
		"\u0000\u0000-.\u0005\"\u0000\u0000.\u0005\u0001\u0000\u0000\u0000/0\u0007"+
		"\u0000\u0000\u00000\u0007\u0001\u0000\u0000\u000012\u0007\u0001\u0000"+
		"\u00002\t\u0001\u0000\u0000\u000035\u0007\u0002\u0000\u000043\u0001\u0000"+
		"\u0000\u000045\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u00006<\u0005"+
		"\u0003\u0000\u000079\u0007\u0002\u0000\u000087\u0001\u0000\u0000\u0000"+
		"89\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:<\u0005$\u0000\u0000"+
		";4\u0001\u0000\u0000\u0000;8\u0001\u0000\u0000\u0000<\u000b\u0001\u0000"+
		"\u0000\u0000=>\u0006\u0006\uffff\uffff\u0000>?\u0005\u0014\u0000\u0000"+
		"?@\u0003\f\u0006\u0000@A\u0005\u0015\u0000\u0000AD\u0001\u0000\u0000\u0000"+
		"BD\u0003\n\u0005\u0000C=\u0001\u0000\u0000\u0000CB\u0001\u0000\u0000\u0000"+
		"DK\u0001\u0000\u0000\u0000EF\n\u0003\u0000\u0000FG\u0003\u0006\u0003\u0000"+
		"GH\u0003\f\u0006\u0004HJ\u0001\u0000\u0000\u0000IE\u0001\u0000\u0000\u0000"+
		"JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000"+
		"\u0000L\r\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NO\u0005\u000b"+
		"\u0000\u0000OP\u0005$\u0000\u0000PS\u0005\n\u0000\u0000QT\u0003\f\u0006"+
		"\u0000RT\u0003\u0002\u0001\u0000SQ\u0001\u0000\u0000\u0000SR\u0001\u0000"+
		"\u0000\u0000Td\u0001\u0000\u0000\u0000UV\u0005\u000e\u0000\u0000VW\u0005"+
		"$\u0000\u0000WZ\u0005\n\u0000\u0000X[\u0005\u0004\u0000\u0000Y[\u0003"+
		"\u0002\u0001\u0000ZX\u0001\u0000\u0000\u0000ZY\u0001\u0000\u0000\u0000"+
		"[d\u0001\u0000\u0000\u0000\\]\u0005\u0005\u0000\u0000]^\u0005$\u0000\u0000"+
		"^a\u0005\n\u0000\u0000_b\u0003\b\u0004\u0000`b\u0003\u0002\u0001\u0000"+
		"a_\u0001\u0000\u0000\u0000a`\u0001\u0000\u0000\u0000bd\u0001\u0000\u0000"+
		"\u0000cN\u0001\u0000\u0000\u0000cU\u0001\u0000\u0000\u0000c\\\u0001\u0000"+
		"\u0000\u0000d\u000f\u0001\u0000\u0000\u0000ef\u0005\u001f\u0000\u0000"+
		"fg\u0003\u0012\t\u0000gh\u0005\u0018\u0000\u0000hi\u0003 \u0010\u0000"+
		"ij\u0005\u0019\u0000\u0000j\u0011\u0001\u0000\u0000\u0000kl\u0005\u0014"+
		"\u0000\u0000lr\u0003\u0016\u000b\u0000mn\u0003\u0018\f\u0000no\u0003\u0016"+
		"\u000b\u0000oq\u0001\u0000\u0000\u0000pm\u0001\u0000\u0000\u0000qt\u0001"+
		"\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000"+
		"su\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000uv\u0005\u0015\u0000"+
		"\u0000v\u0013\u0001\u0000\u0000\u0000wx\u0003\n\u0005\u0000xy\u0003\u001a"+
		"\r\u0000yz\u0003\n\u0005\u0000z\u0015\u0001\u0000\u0000\u0000{~\u0003"+
		"\u0014\n\u0000|~\u0003\b\u0004\u0000}{\u0001\u0000\u0000\u0000}|\u0001"+
		"\u0000\u0000\u0000~\u0017\u0001\u0000\u0000\u0000\u007f\u0080\u0007\u0003"+
		"\u0000\u0000\u0080\u0019\u0001\u0000\u0000\u0000\u0081\u0082\u0005\n\u0000"+
		"\u0000\u0082\u0089\u0005\n\u0000\u0000\u0083\u0089\u0005\u000f\u0000\u0000"+
		"\u0084\u0089\u0005\u0010\u0000\u0000\u0085\u0089\u0005\u0011\u0000\u0000"+
		"\u0086\u0089\u0005\u0012\u0000\u0000\u0087\u0089\u0005\u0013\u0000\u0000"+
		"\u0088\u0081\u0001\u0000\u0000\u0000\u0088\u0083\u0001\u0000\u0000\u0000"+
		"\u0088\u0084\u0001\u0000\u0000\u0000\u0088\u0085\u0001\u0000\u0000\u0000"+
		"\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000"+
		"\u0089\u001b\u0001\u0000\u0000\u0000\u008a\u008b\u0005!\u0000\u0000\u008b"+
		"\u008c\u0005\u0014\u0000\u0000\u008c\u008d\u0003\u000e\u0007\u0000\u008d"+
		"\u008e\u0005\"\u0000\u0000\u008e\u008f\u0003\u0014\n\u0000\u008f\u0090"+
		"\u0005\"\u0000\u0000\u0090\u0091\u0003\"\u0011\u0000\u0091\u0092\u0005"+
		"\u0015\u0000\u0000\u0092\u0093\u0005\u0018\u0000\u0000\u0093\u0094\u0003"+
		" \u0010\u0000\u0094\u0095\u0005\u0019\u0000\u0000\u0095\u001d\u0001\u0000"+
		"\u0000\u0000\u0096\u0097\u0003\u000e\u0007\u0000\u0097\u0098\u0005\"\u0000"+
		"\u0000\u0098\u00a0\u0001\u0000\u0000\u0000\u0099\u009a\u0003\"\u0011\u0000"+
		"\u009a\u009b\u0005\"\u0000\u0000\u009b\u00a0\u0001\u0000\u0000\u0000\u009c"+
		"\u00a0\u0003\u0010\b\u0000\u009d\u00a0\u0003\u001c\u000e\u0000\u009e\u00a0"+
		"\u0003\u0004\u0002\u0000\u009f\u0096\u0001\u0000\u0000\u0000\u009f\u0099"+
		"\u0001\u0000\u0000\u0000\u009f\u009c\u0001\u0000\u0000\u0000\u009f\u009d"+
		"\u0001\u0000\u0000\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u001f"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a4\u0003\u001e\u000f\u0000\u00a2\u00a4"+
		"\u0005\u0007\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6!\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005"+
		"$\u0000\u0000\u00a9\u00ac\u0005\n\u0000\u0000\u00aa\u00ad\u0003\f\u0006"+
		"\u0000\u00ab\u00ad\u0003\u0002\u0001\u0000\u00ac\u00aa\u0001\u0000\u0000"+
		"\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad#\u0001\u0000\u0000\u0000"+
		"\u0011&48;CKSZacr}\u0088\u009f\u00a3\u00a5\u00ac";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}