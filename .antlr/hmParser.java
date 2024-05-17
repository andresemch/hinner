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
		NUM=10, VAR=11, TIPUS=12, OP=13, WS=14;
	public static final int
		RULE_root = 0, RULE_exprTipus = 1, RULE_tipus = 2, RULE_elemTipus = 3, 
		RULE_expr = 4, RULE_abstraccio = 5, RULE_aplicacio = 6, RULE_var = 7, 
		RULE_num = 8, RULE_op = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "exprTipus", "tipus", "elemTipus", "expr", "abstraccio", "aplicacio", 
			"var", "num", "op"
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
			setState(23);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new RootExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				expr();
				}
				break;
			case 2:
				_localctx = new RootTipusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				exprTipus();
				}
				break;
			case 3:
				_localctx = new EndfileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(22);
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
	public static class NumTipusContext extends ExprTipusContext {
		public NumContext left;
		public ElemTipusContext right;
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public ElemTipusContext elemTipus() {
			return getRuleContext(ElemTipusContext.class,0);
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
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				_localctx = new NumTipusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				((NumTipusContext)_localctx).left = num();
				setState(26);
				match(T__0);
				setState(27);
				((NumTipusContext)_localctx).right = elemTipus();
				}
				break;
			case T__1:
				_localctx = new OpTipusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				match(T__1);
				setState(30);
				((OpTipusContext)_localctx).left = op();
				setState(31);
				match(T__2);
				setState(32);
				match(T__0);
				setState(33);
				((OpTipusContext)_localctx).right = tipus();
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
		public ElemTipusContext elemTipus() {
			return getRuleContext(ElemTipusContext.class,0);
		}
		public TipusContext tipus() {
			return getRuleContext(TipusContext.class,0);
		}
		public FuncTipusContext(TipusContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BasicTipusContext extends TipusContext {
		public ElemTipusContext elemTipus() {
			return getRuleContext(ElemTipusContext.class,0);
		}
		public BasicTipusContext(TipusContext ctx) { copyFrom(ctx); }
	}

	public final TipusContext tipus() throws RecognitionException {
		TipusContext _localctx = new TipusContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tipus);
		try {
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new FuncTipusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				elemTipus();
				setState(38);
				match(T__3);
				setState(39);
				tipus();
				}
				break;
			case 2:
				_localctx = new BasicTipusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				elemTipus();
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
	public static class ElemTipusContext extends ParserRuleContext {
		public TerminalNode TIPUS() { return getToken(hmParser.TIPUS, 0); }
		public ElemTipusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elemTipus; }
	}

	public final ElemTipusContext elemTipus() throws RecognitionException {
		ElemTipusContext _localctx = new ElemTipusContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_elemTipus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(TIPUS);
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
		enterRule(_localctx, 8, RULE_expr);
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				abstraccio();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				aplicacio(0);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				var();
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				num();
				}
				break;
			case T__5:
			case T__6:
			case T__7:
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
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
		enterRule(_localctx, 10, RULE_abstraccio);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__4);
			setState(54);
			var();
			setState(55);
			match(T__3);
			setState(56);
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_aplicacio, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ParentesiAplicacioContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(59);
			match(T__1);
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(60);
				abstraccio();
				}
				break;
			case T__5:
			case T__6:
			case T__7:
			case T__8:
				{
				setState(61);
				op();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(64);
			match(T__2);
			setState(65);
			expr();
			}
			_ctx.stop = _input.LT(-1);
			setState(71);
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
					setState(67);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(68);
					expr();
					}
					} 
				}
				setState(73);
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
		enterRule(_localctx, 14, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
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
		enterRule(_localctx, 16, RULE_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
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
		enterRule(_localctx, 18, RULE_op);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new MultOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(T__5);
				}
				break;
			case T__6:
				_localctx = new DivOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(T__6);
				}
				break;
			case T__7:
				_localctx = new SumOpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				match(T__7);
				}
				break;
			case T__8:
				_localctx = new RestaOpContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
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
		case 6:
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
		"\u0004\u0001\u000eU\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000"+
		"\u0018\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"$\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002+\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u00044\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006?\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006F\b\u0006\n\u0006\f\u0006"+
		"I\t\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\tS\b\t\u0001\t\u0000\u0001\f\n\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0000\u0000W\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0002#\u0001\u0000\u0000\u0000\u0004*\u0001\u0000\u0000\u0000\u0006,"+
		"\u0001\u0000\u0000\u0000\b3\u0001\u0000\u0000\u0000\n5\u0001\u0000\u0000"+
		"\u0000\f:\u0001\u0000\u0000\u0000\u000eJ\u0001\u0000\u0000\u0000\u0010"+
		"L\u0001\u0000\u0000\u0000\u0012R\u0001\u0000\u0000\u0000\u0014\u0018\u0003"+
		"\b\u0004\u0000\u0015\u0018\u0003\u0002\u0001\u0000\u0016\u0018\u0005\u0000"+
		"\u0000\u0001\u0017\u0014\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000"+
		"\u0000\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018\u0001\u0001\u0000"+
		"\u0000\u0000\u0019\u001a\u0003\u0010\b\u0000\u001a\u001b\u0005\u0001\u0000"+
		"\u0000\u001b\u001c\u0003\u0006\u0003\u0000\u001c$\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0005\u0002\u0000\u0000\u001e\u001f\u0003\u0012\t\u0000\u001f"+
		" \u0005\u0003\u0000\u0000 !\u0005\u0001\u0000\u0000!\"\u0003\u0004\u0002"+
		"\u0000\"$\u0001\u0000\u0000\u0000#\u0019\u0001\u0000\u0000\u0000#\u001d"+
		"\u0001\u0000\u0000\u0000$\u0003\u0001\u0000\u0000\u0000%&\u0003\u0006"+
		"\u0003\u0000&\'\u0005\u0004\u0000\u0000\'(\u0003\u0004\u0002\u0000(+\u0001"+
		"\u0000\u0000\u0000)+\u0003\u0006\u0003\u0000*%\u0001\u0000\u0000\u0000"+
		"*)\u0001\u0000\u0000\u0000+\u0005\u0001\u0000\u0000\u0000,-\u0005\f\u0000"+
		"\u0000-\u0007\u0001\u0000\u0000\u0000.4\u0003\n\u0005\u0000/4\u0003\f"+
		"\u0006\u000004\u0003\u000e\u0007\u000014\u0003\u0010\b\u000024\u0003\u0012"+
		"\t\u00003.\u0001\u0000\u0000\u00003/\u0001\u0000\u0000\u000030\u0001\u0000"+
		"\u0000\u000031\u0001\u0000\u0000\u000032\u0001\u0000\u0000\u00004\t\u0001"+
		"\u0000\u0000\u000056\u0005\u0005\u0000\u000067\u0003\u000e\u0007\u0000"+
		"78\u0005\u0004\u0000\u000089\u0003\b\u0004\u00009\u000b\u0001\u0000\u0000"+
		"\u0000:;\u0006\u0006\uffff\uffff\u0000;>\u0005\u0002\u0000\u0000<?\u0003"+
		"\n\u0005\u0000=?\u0003\u0012\t\u0000><\u0001\u0000\u0000\u0000>=\u0001"+
		"\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@A\u0005\u0003\u0000\u0000"+
		"AB\u0003\b\u0004\u0000BG\u0001\u0000\u0000\u0000CD\n\u0002\u0000\u0000"+
		"DF\u0003\b\u0004\u0000EC\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000"+
		"GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000H\r\u0001\u0000\u0000"+
		"\u0000IG\u0001\u0000\u0000\u0000JK\u0005\u000b\u0000\u0000K\u000f\u0001"+
		"\u0000\u0000\u0000LM\u0005\n\u0000\u0000M\u0011\u0001\u0000\u0000\u0000"+
		"NS\u0005\u0006\u0000\u0000OS\u0005\u0007\u0000\u0000PS\u0005\b\u0000\u0000"+
		"QS\u0005\t\u0000\u0000RN\u0001\u0000\u0000\u0000RO\u0001\u0000\u0000\u0000"+
		"RP\u0001\u0000\u0000\u0000RQ\u0001\u0000\u0000\u0000S\u0013\u0001\u0000"+
		"\u0000\u0000\u0007\u0017#*3>GR";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}