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
		T__0=1, INT_VAL=2, OR=3, AND=4, EQUAL=5, NOT_EQUAL=6, GREATER=7, LESS=8, 
		GREATER_EQUAL=9, LESS_EQUAL=10, BRACKET_L=11, BRACKET_R=12, SQ_BRACKET_L=13, 
		SQ_BRACKET_R=14, PARENT_L=15, PARENT_R=16, ADD_=17, SUBTRACT_=18, MULTIPLY=19, 
		DIVIDE=20, MODULO=21, IF=22, ELSE=23, WHILE=24, SEMICOLON=25, COMMA=26, 
		READ_OR_IN=27, IDENTIFIER=28, WS=29;
	public static final int
		RULE_program = 0, RULE_writeOrOut = 1, RULE_math_symbol = 2, RULE_num_val = 3, 
		RULE_math_expr = 4, RULE_if_statement = 5, RULE_logic_condition = 6, RULE_comparison = 7, 
		RULE_logic_statement = 8, RULE_logic_operator = 9, RULE_comparator = 10, 
		RULE_while_loop = 11, RULE_instruction = 12, RULE_instruction_general = 13, 
		RULE_modification = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "writeOrOut", "math_symbol", "num_val", "math_expr", "if_statement", 
			"logic_condition", "comparison", "logic_statement", "logic_operator", 
			"comparator", "while_loop", "instruction", "instruction_general", "modification"
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
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			instruction_general();
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
		public TerminalNode BRACKET_R() { return getToken(BobaroParser.BRACKET_R, 0); }
		public TerminalNode SEMICOLON() { return getToken(BobaroParser.SEMICOLON, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BobaroParser.IDENTIFIER, 0); }
		public TerminalNode INT_VAL() { return getToken(BobaroParser.INT_VAL, 0); }
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
		enterRule(_localctx, 2, RULE_writeOrOut);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__0);
			setState(33);
			_la = _input.LA(1);
			if ( !(_la==INT_VAL || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(34);
			match(BRACKET_R);
			setState(35);
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
		enterRule(_localctx, 4, RULE_math_symbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
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
		enterRule(_localctx, 6, RULE_num_val);
		int _la;
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ADD_ || _la==SUBTRACT_) {
					{
					setState(39);
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

				setState(42);
				match(INT_VAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ADD_ || _la==SUBTRACT_) {
					{
					setState(43);
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

				setState(46);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_math_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_L:
				{
				setState(50);
				match(BRACKET_L);
				setState(51);
				math_expr(0);
				setState(52);
				match(BRACKET_R);
				}
				break;
			case INT_VAL:
			case ADD_:
			case SUBTRACT_:
			case IDENTIFIER:
				{
				setState(54);
				num_val();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Math_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_math_expr);
					setState(57);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(58);
					math_symbol();
					setState(59);
					math_expr(4);
					}
					} 
				}
				setState(65);
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
		enterRule(_localctx, 10, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(IF);
			setState(67);
			logic_condition();
			setState(68);
			match(PARENT_L);
			setState(69);
			instruction_general();
			setState(70);
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
		enterRule(_localctx, 12, RULE_logic_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(BRACKET_L);
			setState(73);
			logic_statement();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR || _la==AND) {
				{
				{
				setState(74);
				logic_operator();
				setState(75);
				logic_statement();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
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
		enterRule(_localctx, 14, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			num_val();
			setState(85);
			comparator();
			setState(86);
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
		public Num_valContext num_val() {
			return getRuleContext(Num_valContext.class,0);
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
		enterRule(_localctx, 16, RULE_logic_statement);
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				comparison();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				num_val();
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
		enterRule(_localctx, 18, RULE_logic_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
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
		enterRule(_localctx, 20, RULE_comparator);
		try {
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQUAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				match(EQUAL);
				setState(95);
				match(EQUAL);
				}
				break;
			case NOT_EQUAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				match(NOT_EQUAL);
				}
				break;
			case GREATER:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(GREATER);
				}
				break;
			case LESS:
				enterOuterAlt(_localctx, 4);
				{
				setState(98);
				match(LESS);
				}
				break;
			case GREATER_EQUAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(99);
				match(GREATER_EQUAL);
				}
				break;
			case LESS_EQUAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(100);
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

	public static class While_loopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(BobaroParser.WHILE, 0); }
		public Logic_conditionContext logic_condition() {
			return getRuleContext(Logic_conditionContext.class,0);
		}
		public TerminalNode PARENT_L() { return getToken(BobaroParser.PARENT_L, 0); }
		public Instruction_generalContext instruction_general() {
			return getRuleContext(Instruction_generalContext.class,0);
		}
		public TerminalNode PARENT_R() { return getToken(BobaroParser.PARENT_R, 0); }
		public While_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_loop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BobaroVisitor ) return ((BobaroVisitor<? extends T>)visitor).visitWhile_loop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_loopContext while_loop() throws RecognitionException {
		While_loopContext _localctx = new While_loopContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_while_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(WHILE);
			setState(104);
			logic_condition();
			setState(105);
			match(PARENT_L);
			setState(106);
			instruction_general();
			setState(107);
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
		public ModificationContext modification() {
			return getRuleContext(ModificationContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BobaroParser.SEMICOLON, 0); }
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public While_loopContext while_loop() {
			return getRuleContext(While_loopContext.class,0);
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
		enterRule(_localctx, 24, RULE_instruction);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				modification();
				setState(110);
				match(SEMICOLON);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				if_statement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				while_loop();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
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
		enterRule(_localctx, 26, RULE_instruction_general);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << IF) | (1L << WHILE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(117);
				instruction();
				}
				}
				setState(122);
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
		public TerminalNode READ_OR_IN() { return getToken(BobaroParser.READ_OR_IN, 0); }
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
		enterRule(_localctx, 28, RULE_modification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(IDENTIFIER);
			setState(124);
			match(EQUAL);
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_VAL:
			case BRACKET_L:
			case ADD_:
			case SUBTRACT_:
			case IDENTIFIER:
				{
				setState(125);
				math_expr(0);
				}
				break;
			case READ_OR_IN:
				{
				setState(126);
				match(READ_OR_IN);
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
		case 4:
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
		"\u0004\u0001\u001d\u0082\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0003\u0003)\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003-\b\u0003\u0001\u0003\u0003\u00030\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"8\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		">\b\u0004\n\u0004\f\u0004A\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006N\b\u0006\n\u0006\f\u0006Q\t\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0003\b[\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0003\nf\b\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\ft\b\f\u0001\r\u0005\rw\b\r\n\r\f\rz"+
		"\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0080"+
		"\b\u000e\u0001\u000e\u0000\u0001\b\u000f\u0000\u0002\u0004\u0006\b\n\f"+
		"\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0004\u0002\u0000"+
		"\u0002\u0002\u001c\u001c\u0001\u0000\u0011\u0014\u0001\u0000\u0011\u0012"+
		"\u0001\u0000\u0003\u0004\u0083\u0000\u001e\u0001\u0000\u0000\u0000\u0002"+
		" \u0001\u0000\u0000\u0000\u0004%\u0001\u0000\u0000\u0000\u0006/\u0001"+
		"\u0000\u0000\u0000\b7\u0001\u0000\u0000\u0000\nB\u0001\u0000\u0000\u0000"+
		"\fH\u0001\u0000\u0000\u0000\u000eT\u0001\u0000\u0000\u0000\u0010Z\u0001"+
		"\u0000\u0000\u0000\u0012\\\u0001\u0000\u0000\u0000\u0014e\u0001\u0000"+
		"\u0000\u0000\u0016g\u0001\u0000\u0000\u0000\u0018s\u0001\u0000\u0000\u0000"+
		"\u001ax\u0001\u0000\u0000\u0000\u001c{\u0001\u0000\u0000\u0000\u001e\u001f"+
		"\u0003\u001a\r\u0000\u001f\u0001\u0001\u0000\u0000\u0000 !\u0005\u0001"+
		"\u0000\u0000!\"\u0007\u0000\u0000\u0000\"#\u0005\f\u0000\u0000#$\u0005"+
		"\u0019\u0000\u0000$\u0003\u0001\u0000\u0000\u0000%&\u0007\u0001\u0000"+
		"\u0000&\u0005\u0001\u0000\u0000\u0000\')\u0007\u0002\u0000\u0000(\'\u0001"+
		"\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000"+
		"*0\u0005\u0002\u0000\u0000+-\u0007\u0002\u0000\u0000,+\u0001\u0000\u0000"+
		"\u0000,-\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.0\u0005\u001c"+
		"\u0000\u0000/(\u0001\u0000\u0000\u0000/,\u0001\u0000\u0000\u00000\u0007"+
		"\u0001\u0000\u0000\u000012\u0006\u0004\uffff\uffff\u000023\u0005\u000b"+
		"\u0000\u000034\u0003\b\u0004\u000045\u0005\f\u0000\u000058\u0001\u0000"+
		"\u0000\u000068\u0003\u0006\u0003\u000071\u0001\u0000\u0000\u000076\u0001"+
		"\u0000\u0000\u00008?\u0001\u0000\u0000\u00009:\n\u0003\u0000\u0000:;\u0003"+
		"\u0004\u0002\u0000;<\u0003\b\u0004\u0004<>\u0001\u0000\u0000\u0000=9\u0001"+
		"\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000"+
		"?@\u0001\u0000\u0000\u0000@\t\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000"+
		"\u0000BC\u0005\u0016\u0000\u0000CD\u0003\f\u0006\u0000DE\u0005\u000f\u0000"+
		"\u0000EF\u0003\u001a\r\u0000FG\u0005\u0010\u0000\u0000G\u000b\u0001\u0000"+
		"\u0000\u0000HI\u0005\u000b\u0000\u0000IO\u0003\u0010\b\u0000JK\u0003\u0012"+
		"\t\u0000KL\u0003\u0010\b\u0000LN\u0001\u0000\u0000\u0000MJ\u0001\u0000"+
		"\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001"+
		"\u0000\u0000\u0000PR\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000"+
		"RS\u0005\f\u0000\u0000S\r\u0001\u0000\u0000\u0000TU\u0003\u0006\u0003"+
		"\u0000UV\u0003\u0014\n\u0000VW\u0003\u0006\u0003\u0000W\u000f\u0001\u0000"+
		"\u0000\u0000X[\u0003\u000e\u0007\u0000Y[\u0003\u0006\u0003\u0000ZX\u0001"+
		"\u0000\u0000\u0000ZY\u0001\u0000\u0000\u0000[\u0011\u0001\u0000\u0000"+
		"\u0000\\]\u0007\u0003\u0000\u0000]\u0013\u0001\u0000\u0000\u0000^_\u0005"+
		"\u0005\u0000\u0000_f\u0005\u0005\u0000\u0000`f\u0005\u0006\u0000\u0000"+
		"af\u0005\u0007\u0000\u0000bf\u0005\b\u0000\u0000cf\u0005\t\u0000\u0000"+
		"df\u0005\n\u0000\u0000e^\u0001\u0000\u0000\u0000e`\u0001\u0000\u0000\u0000"+
		"ea\u0001\u0000\u0000\u0000eb\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000"+
		"\u0000ed\u0001\u0000\u0000\u0000f\u0015\u0001\u0000\u0000\u0000gh\u0005"+
		"\u0018\u0000\u0000hi\u0003\f\u0006\u0000ij\u0005\u000f\u0000\u0000jk\u0003"+
		"\u001a\r\u0000kl\u0005\u0010\u0000\u0000l\u0017\u0001\u0000\u0000\u0000"+
		"mn\u0003\u001c\u000e\u0000no\u0005\u0019\u0000\u0000ot\u0001\u0000\u0000"+
		"\u0000pt\u0003\n\u0005\u0000qt\u0003\u0016\u000b\u0000rt\u0003\u0002\u0001"+
		"\u0000sm\u0001\u0000\u0000\u0000sp\u0001\u0000\u0000\u0000sq\u0001\u0000"+
		"\u0000\u0000sr\u0001\u0000\u0000\u0000t\u0019\u0001\u0000\u0000\u0000"+
		"uw\u0003\u0018\f\u0000vu\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000"+
		"xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y\u001b\u0001\u0000"+
		"\u0000\u0000zx\u0001\u0000\u0000\u0000{|\u0005\u001c\u0000\u0000|\u007f"+
		"\u0005\u0005\u0000\u0000}\u0080\u0003\b\u0004\u0000~\u0080\u0005\u001b"+
		"\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f~\u0001\u0000\u0000\u0000"+
		"\u0080\u001d\u0001\u0000\u0000\u0000\u000b(,/7?OZesx\u007f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}