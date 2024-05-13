// Generated from /home/andres/Escritorio/compilador/hinner/hm.g4 by ANTLR 4.13.1
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
		T__9=10, T__10=11, NUM=12, VAR=13, WS=14;
	public static final int
		RULE_root = 0, RULE_tipus = 1, RULE_basic = 2, RULE_expr = 3, RULE_abstraccio = 4, 
		RULE_aplicacio = 5, RULE_var = 6, RULE_num = 7, RULE_op = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "tipus", "basic", "expr", "abstraccio", "aplicacio", "var", "num", 
			"op"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'::'", "'->'", "'N'", "'B'", "'\\'", "'('", "')'", "'*'", "'/'", 
			"'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"NUM", "VAR", "WS"
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
	public static class ExpressioContext extends RootContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpressioContext(RootContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EndfileContext extends RootContext {
		public TerminalNode EOF() { return getToken(hmParser.EOF, 0); }
		public EndfileContext(RootContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DefTipusContext extends RootContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TipusContext tipus() {
			return getRuleContext(TipusContext.class,0);
		}
		public DefTipusContext(RootContext ctx) { copyFrom(ctx); }
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			setState(24);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new ExpressioContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				expr();
				}
				break;
			case 2:
				_localctx = new EndfileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				match(EOF);
				}
				break;
			case 3:
				_localctx = new DefTipusContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(20);
				expr();
				setState(21);
				match(T__0);
				setState(22);
				tipus();
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
	public static class TipusBasicContext extends TipusContext {
		public BasicContext basic() {
			return getRuleContext(BasicContext.class,0);
		}
		public TipusBasicContext(TipusContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TipusFuncContext extends TipusContext {
		public BasicContext basic() {
			return getRuleContext(BasicContext.class,0);
		}
		public TipusContext tipus() {
			return getRuleContext(TipusContext.class,0);
		}
		public TipusFuncContext(TipusContext ctx) { copyFrom(ctx); }
	}

	public final TipusContext tipus() throws RecognitionException {
		TipusContext _localctx = new TipusContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tipus);
		try {
			setState(31);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new TipusBasicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				basic();
				}
				break;
			case 2:
				_localctx = new TipusFuncContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				basic();
				setState(28);
				match(T__1);
				setState(29);
				tipus();
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
	public static class BasicContext extends ParserRuleContext {
		public BasicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basic; }
	}

	public final BasicContext basic() throws RecognitionException {
		BasicContext _localctx = new BasicContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_basic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
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
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				abstraccio();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				aplicacio(0);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				var();
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(38);
				num();
				}
				break;
			case T__7:
			case T__8:
			case T__9:
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(39);
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
			setState(42);
			match(T__4);
			setState(43);
			var();
			setState(44);
			match(T__1);
			setState(45);
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

			setState(48);
			match(T__5);
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(49);
				abstraccio();
				}
				break;
			case T__7:
			case T__8:
			case T__9:
			case T__10:
				{
				setState(50);
				op();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(53);
			match(T__6);
			setState(54);
			expr();
			}
			_ctx.stop = _input.LT(-1);
			setState(60);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RecursivaAplicacioContext(new AplicacioContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_aplicacio);
					setState(56);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(57);
					expr();
					}
					} 
				}
				setState(62);
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
			setState(63);
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
			setState(65);
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
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				_localctx = new MultOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(T__7);
				}
				break;
			case T__8:
				_localctx = new DivOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(T__8);
				}
				break;
			case T__9:
				_localctx = new SumOpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				match(T__9);
				}
				break;
			case T__10:
				_localctx = new RestaOpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				match(T__10);
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
		"\u0004\u0001\u000eJ\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0003\u0000\u0019\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001 \b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		")\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u00054\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		";\b\u0005\n\u0005\f\u0005>\t\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bH\b\b\u0001\b\u0000"+
		"\u0001\n\t\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0000\u0001\u0001"+
		"\u0000\u0003\u0004L\u0000\u0018\u0001\u0000\u0000\u0000\u0002\u001f\u0001"+
		"\u0000\u0000\u0000\u0004!\u0001\u0000\u0000\u0000\u0006(\u0001\u0000\u0000"+
		"\u0000\b*\u0001\u0000\u0000\u0000\n/\u0001\u0000\u0000\u0000\f?\u0001"+
		"\u0000\u0000\u0000\u000eA\u0001\u0000\u0000\u0000\u0010G\u0001\u0000\u0000"+
		"\u0000\u0012\u0019\u0003\u0006\u0003\u0000\u0013\u0019\u0005\u0000\u0000"+
		"\u0001\u0014\u0015\u0003\u0006\u0003\u0000\u0015\u0016\u0005\u0001\u0000"+
		"\u0000\u0016\u0017\u0003\u0002\u0001\u0000\u0017\u0019\u0001\u0000\u0000"+
		"\u0000\u0018\u0012\u0001\u0000\u0000\u0000\u0018\u0013\u0001\u0000\u0000"+
		"\u0000\u0018\u0014\u0001\u0000\u0000\u0000\u0019\u0001\u0001\u0000\u0000"+
		"\u0000\u001a \u0003\u0004\u0002\u0000\u001b\u001c\u0003\u0004\u0002\u0000"+
		"\u001c\u001d\u0005\u0002\u0000\u0000\u001d\u001e\u0003\u0002\u0001\u0000"+
		"\u001e \u0001\u0000\u0000\u0000\u001f\u001a\u0001\u0000\u0000\u0000\u001f"+
		"\u001b\u0001\u0000\u0000\u0000 \u0003\u0001\u0000\u0000\u0000!\"\u0007"+
		"\u0000\u0000\u0000\"\u0005\u0001\u0000\u0000\u0000#)\u0003\b\u0004\u0000"+
		"$)\u0003\n\u0005\u0000%)\u0003\f\u0006\u0000&)\u0003\u000e\u0007\u0000"+
		"\')\u0003\u0010\b\u0000(#\u0001\u0000\u0000\u0000($\u0001\u0000\u0000"+
		"\u0000(%\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000(\'\u0001\u0000"+
		"\u0000\u0000)\u0007\u0001\u0000\u0000\u0000*+\u0005\u0005\u0000\u0000"+
		"+,\u0003\f\u0006\u0000,-\u0005\u0002\u0000\u0000-.\u0003\u0006\u0003\u0000"+
		".\t\u0001\u0000\u0000\u0000/0\u0006\u0005\uffff\uffff\u000003\u0005\u0006"+
		"\u0000\u000014\u0003\b\u0004\u000024\u0003\u0010\b\u000031\u0001\u0000"+
		"\u0000\u000032\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000056\u0005"+
		"\u0007\u0000\u000067\u0003\u0006\u0003\u00007<\u0001\u0000\u0000\u0000"+
		"89\n\u0002\u0000\u00009;\u0003\u0006\u0003\u0000:8\u0001\u0000\u0000\u0000"+
		";>\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000"+
		"\u0000=\u000b\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000?@\u0005"+
		"\r\u0000\u0000@\r\u0001\u0000\u0000\u0000AB\u0005\f\u0000\u0000B\u000f"+
		"\u0001\u0000\u0000\u0000CH\u0005\b\u0000\u0000DH\u0005\t\u0000\u0000E"+
		"H\u0005\n\u0000\u0000FH\u0005\u000b\u0000\u0000GC\u0001\u0000\u0000\u0000"+
		"GD\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GF\u0001\u0000\u0000"+
		"\u0000H\u0011\u0001\u0000\u0000\u0000\u0006\u0018\u001f(3<G";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}