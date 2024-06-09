// Generated from /home/andres/Escritorio/compilador/hinner/entrega/hm.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class hmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		NUM=10, VAR=11, TIPUS=12, OP=13, WS=14;
	public static final int
		RULE_root = 0, RULE_exprTipus = 1, RULE_tipus = 2, RULE_expr = 3, RULE_abstraccio = 4, 
		RULE_aplicacio = 5, RULE_var = 6, RULE_num = 7, RULE_op = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "exprTipus", "tipus", "expr", "abstraccio", "aplicacio", "var", 
			"num", "op"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'::'", "'('", "')'", "'->'", "'\\'", "'*'", "'/'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "NUM", "VAR", 
			"TIPUS", "OP", "WS"
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
	public String getGrammarFileName() { return "hm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public hmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
	 
		public RootContext() { }
		public void copyFrom(RootContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RootExprContext extends RootContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RootExprContext(RootContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RootTipusContext extends RootContext {
		public ExprTipusContext exprTipus() {
			return getRuleContext(ExprTipusContext.class,0);
		}
		public RootTipusContext(RootContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EndfileContext extends RootContext {
		public TerminalNode EOF() { return getToken(hmParser.EOF, 0); }
		public EndfileContext(RootContext ctx) { copyFrom(ctx); }
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			setState(21);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new RootExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				expr();
				}
				break;
			case 2:
				_localctx = new RootTipusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				exprTipus();
				}
				break;
			case 3:
				_localctx = new EndfileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(20);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprTipusContext extends ParserRuleContext {
		public ExprTipusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprTipus; }
	 
		public ExprTipusContext() { }
		public void copyFrom(ExprTipusContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarTipusContext extends ExprTipusContext {
		public VarContext left;
		public TipusContext right;
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TipusContext tipus() {
			return getRuleContext(TipusContext.class,0);
		}
		public VarTipusContext(ExprTipusContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumTipusContext extends ExprTipusContext {
		public NumContext left;
		public TipusContext right;
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public TipusContext tipus() {
			return getRuleContext(TipusContext.class,0);
		}
		public NumTipusContext(ExprTipusContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpTipusContext extends ExprTipusContext {
		public OpContext left;
		public TipusContext right;
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public TipusContext tipus() {
			return getRuleContext(TipusContext.class,0);
		}
		public OpTipusContext(ExprTipusContext ctx) { copyFrom(ctx); }
	}

	public final ExprTipusContext exprTipus() throws RecognitionException {
		ExprTipusContext _localctx = new ExprTipusContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exprTipus);
		try {
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				_localctx = new NumTipusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(23);
				((NumTipusContext)_localctx).left = num();
				setState(24);
				match(T__0);
				setState(25);
				((NumTipusContext)_localctx).right = tipus();
				}
				break;
			case T__1:
				_localctx = new OpTipusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				match(T__1);
				setState(28);
				((OpTipusContext)_localctx).left = op();
				setState(29);
				match(T__2);
				setState(30);
				match(T__0);
				setState(31);
				((OpTipusContext)_localctx).right = tipus();
				}
				break;
			case VAR:
				_localctx = new VarTipusContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				((VarTipusContext)_localctx).left = var();
				setState(34);
				match(T__0);
				setState(35);
				((VarTipusContext)_localctx).right = tipus();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TipusContext extends ParserRuleContext {
		public TipusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipus; }
	 
		public TipusContext() { }
		public void copyFrom(TipusContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncTipusContext extends TipusContext {
		public TerminalNode TIPUS() { return getToken(hmParser.TIPUS, 0); }
		public TipusContext tipus() {
			return getRuleContext(TipusContext.class,0);
		}
		public FuncTipusContext(TipusContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BasicTipusContext extends TipusContext {
		public TerminalNode TIPUS() { return getToken(hmParser.TIPUS, 0); }
		public BasicTipusContext(TipusContext ctx) { copyFrom(ctx); }
	}

	public final TipusContext tipus() throws RecognitionException {
		TipusContext _localctx = new TipusContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tipus);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new FuncTipusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(TIPUS);
				setState(40);
				match(T__3);
				setState(41);
				tipus();
				}
				break;
			case 2:
				_localctx = new BasicTipusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				match(TIPUS);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public AbstraccioContext abstraccio() {
			return getRuleContext(AbstraccioContext.class,0);
		}
		public AplicacioContext aplicacio() {
			return getRuleContext(AplicacioContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr);
		try {
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				abstraccio();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				aplicacio(0);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				var();
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(48);
				num();
				}
				break;
			case T__5:
			case T__6:
			case T__7:
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(49);
				op();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AbstraccioContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AbstraccioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstraccio; }
	}

	public final AbstraccioContext abstraccio() throws RecognitionException {
		AbstraccioContext _localctx = new AbstraccioContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_abstraccio);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__4);
			setState(53);
			var();
			setState(54);
			match(T__3);
			setState(55);
			expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AplicacioContext extends ParserRuleContext {
		public AplicacioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aplicacio; }
	 
		public AplicacioContext() { }
		public void copyFrom(AplicacioContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RecursivaAplicacioContext extends AplicacioContext {
		public AplicacioContext aplicacio() {
			return getRuleContext(AplicacioContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RecursivaAplicacioContext(AplicacioContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParentesiAplicacioContext extends AplicacioContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AbstraccioContext abstraccio() {
			return getRuleContext(AbstraccioContext.class,0);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public ParentesiAplicacioContext(AplicacioContext ctx) { copyFrom(ctx); }
	}

	public final AplicacioContext aplicacio() throws RecognitionException {
		return aplicacio(0);
	}

	private AplicacioContext aplicacio(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AplicacioContext _localctx = new AplicacioContext(_ctx, _parentState);
		AplicacioContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_aplicacio, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ParentesiAplicacioContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(58);
			match(T__1);
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(59);
				abstraccio();
				}
				break;
			case T__5:
			case T__6:
			case T__7:
			case T__8:
				{
				setState(60);
				op();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(63);
			match(T__2);
			setState(64);
			expr();
			}
			_ctx.stop = _input.LT(-1);
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RecursivaAplicacioContext(new AplicacioContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_aplicacio);
					setState(66);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(67);
					expr();
					}
					} 
				}
				setState(72);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(hmParser.VAR, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(VAR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class NumContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(hmParser.NUM, 0); }
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(NUM);
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

	@SuppressWarnings("CheckReturnValue")
	public static class OpContext extends ParserRuleContext {
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
	 
		public OpContext() { }
		public void copyFrom(OpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivOpContext extends OpContext {
		public DivOpContext(OpContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultOpContext extends OpContext {
		public MultOpContext(OpContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RestaOpContext extends OpContext {
		public RestaOpContext(OpContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SumOpContext extends OpContext {
		public SumOpContext(OpContext ctx) { copyFrom(ctx); }
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_op);
		try {
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new MultOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(T__5);
				}
				break;
			case T__6:
				_localctx = new DivOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(T__6);
				}
				break;
			case T__7:
				_localctx = new SumOpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				match(T__7);
				}
				break;
			case T__8:
				_localctx = new RestaOpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				match(T__8);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return aplicacio_sempred((AplicacioContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean aplicacio_sempred(AplicacioContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000eT\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000\u0016\b\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001&\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002,\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00033\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005>\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005E\b\u0005\n\u0005\f\u0005"+
		"H\t\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\bR\b\b\u0001\b\u0000\u0001\n\t\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0000\u0000X\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0002%\u0001\u0000\u0000\u0000\u0004+\u0001\u0000\u0000\u0000\u00062"+
		"\u0001\u0000\u0000\u0000\b4\u0001\u0000\u0000\u0000\n9\u0001\u0000\u0000"+
		"\u0000\fI\u0001\u0000\u0000\u0000\u000eK\u0001\u0000\u0000\u0000\u0010"+
		"Q\u0001\u0000\u0000\u0000\u0012\u0016\u0003\u0006\u0003\u0000\u0013\u0016"+
		"\u0003\u0002\u0001\u0000\u0014\u0016\u0005\u0000\u0000\u0001\u0015\u0012"+
		"\u0001\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0015\u0014"+
		"\u0001\u0000\u0000\u0000\u0016\u0001\u0001\u0000\u0000\u0000\u0017\u0018"+
		"\u0003\u000e\u0007\u0000\u0018\u0019\u0005\u0001\u0000\u0000\u0019\u001a"+
		"\u0003\u0004\u0002\u0000\u001a&\u0001\u0000\u0000\u0000\u001b\u001c\u0005"+
		"\u0002\u0000\u0000\u001c\u001d\u0003\u0010\b\u0000\u001d\u001e\u0005\u0003"+
		"\u0000\u0000\u001e\u001f\u0005\u0001\u0000\u0000\u001f \u0003\u0004\u0002"+
		"\u0000 &\u0001\u0000\u0000\u0000!\"\u0003\f\u0006\u0000\"#\u0005\u0001"+
		"\u0000\u0000#$\u0003\u0004\u0002\u0000$&\u0001\u0000\u0000\u0000%\u0017"+
		"\u0001\u0000\u0000\u0000%\u001b\u0001\u0000\u0000\u0000%!\u0001\u0000"+
		"\u0000\u0000&\u0003\u0001\u0000\u0000\u0000\'(\u0005\f\u0000\u0000()\u0005"+
		"\u0004\u0000\u0000),\u0003\u0004\u0002\u0000*,\u0005\f\u0000\u0000+\'"+
		"\u0001\u0000\u0000\u0000+*\u0001\u0000\u0000\u0000,\u0005\u0001\u0000"+
		"\u0000\u0000-3\u0003\b\u0004\u0000.3\u0003\n\u0005\u0000/3\u0003\f\u0006"+
		"\u000003\u0003\u000e\u0007\u000013\u0003\u0010\b\u00002-\u0001\u0000\u0000"+
		"\u00002.\u0001\u0000\u0000\u00002/\u0001\u0000\u0000\u000020\u0001\u0000"+
		"\u0000\u000021\u0001\u0000\u0000\u00003\u0007\u0001\u0000\u0000\u0000"+
		"45\u0005\u0005\u0000\u000056\u0003\f\u0006\u000067\u0005\u0004\u0000\u0000"+
		"78\u0003\u0006\u0003\u00008\t\u0001\u0000\u0000\u00009:\u0006\u0005\uffff"+
		"\uffff\u0000:=\u0005\u0002\u0000\u0000;>\u0003\b\u0004\u0000<>\u0003\u0010"+
		"\b\u0000=;\u0001\u0000\u0000\u0000=<\u0001\u0000\u0000\u0000>?\u0001\u0000"+
		"\u0000\u0000?@\u0005\u0003\u0000\u0000@A\u0003\u0006\u0003\u0000AF\u0001"+
		"\u0000\u0000\u0000BC\n\u0002\u0000\u0000CE\u0003\u0006\u0003\u0000DB\u0001"+
		"\u0000\u0000\u0000EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000"+
		"FG\u0001\u0000\u0000\u0000G\u000b\u0001\u0000\u0000\u0000HF\u0001\u0000"+
		"\u0000\u0000IJ\u0005\u000b\u0000\u0000J\r\u0001\u0000\u0000\u0000KL\u0005"+
		"\n\u0000\u0000L\u000f\u0001\u0000\u0000\u0000MR\u0005\u0006\u0000\u0000"+
		"NR\u0005\u0007\u0000\u0000OR\u0005\b\u0000\u0000PR\u0005\t\u0000\u0000"+
		"QM\u0001\u0000\u0000\u0000QN\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000"+
		"\u0000QP\u0001\u0000\u0000\u0000R\u0011\u0001\u0000\u0000\u0000\u0007"+
		"\u0015%+2=FQ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}