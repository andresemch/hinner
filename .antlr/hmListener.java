// Generated from /home/andres/Escritorio/compilador/hinner/hm.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link hmParser}.
 */
public interface hmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code expressio}
	 * labeled alternative in {@link hmParser#root}.
	 * @param ctx the parse tree
	 */
	void enterExpressio(hmParser.ExpressioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressio}
	 * labeled alternative in {@link hmParser#root}.
	 * @param ctx the parse tree
	 */
	void exitExpressio(hmParser.ExpressioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code endfile}
	 * labeled alternative in {@link hmParser#root}.
	 * @param ctx the parse tree
	 */
	void enterEndfile(hmParser.EndfileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code endfile}
	 * labeled alternative in {@link hmParser#root}.
	 * @param ctx the parse tree
	 */
	void exitEndfile(hmParser.EndfileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code defTipus}
	 * labeled alternative in {@link hmParser#root}.
	 * @param ctx the parse tree
	 */
	void enterDefTipus(hmParser.DefTipusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code defTipus}
	 * labeled alternative in {@link hmParser#root}.
	 * @param ctx the parse tree
	 */
	void exitDefTipus(hmParser.DefTipusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tipusBasic}
	 * labeled alternative in {@link hmParser#tipus}.
	 * @param ctx the parse tree
	 */
	void enterTipusBasic(hmParser.TipusBasicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tipusBasic}
	 * labeled alternative in {@link hmParser#tipus}.
	 * @param ctx the parse tree
	 */
	void exitTipusBasic(hmParser.TipusBasicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tipusFunc}
	 * labeled alternative in {@link hmParser#tipus}.
	 * @param ctx the parse tree
	 */
	void enterTipusFunc(hmParser.TipusFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tipusFunc}
	 * labeled alternative in {@link hmParser#tipus}.
	 * @param ctx the parse tree
	 */
	void exitTipusFunc(hmParser.TipusFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link hmParser#basic}.
	 * @param ctx the parse tree
	 */
	void enterBasic(hmParser.BasicContext ctx);
	/**
	 * Exit a parse tree produced by {@link hmParser#basic}.
	 * @param ctx the parse tree
	 */
	void exitBasic(hmParser.BasicContext ctx);
	/**
	 * Enter a parse tree produced by {@link hmParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(hmParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link hmParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(hmParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link hmParser#abstraccio}.
	 * @param ctx the parse tree
	 */
	void enterAbstraccio(hmParser.AbstraccioContext ctx);
	/**
	 * Exit a parse tree produced by {@link hmParser#abstraccio}.
	 * @param ctx the parse tree
	 */
	void exitAbstraccio(hmParser.AbstraccioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code recursivaAplicacio}
	 * labeled alternative in {@link hmParser#aplicacio}.
	 * @param ctx the parse tree
	 */
	void enterRecursivaAplicacio(hmParser.RecursivaAplicacioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code recursivaAplicacio}
	 * labeled alternative in {@link hmParser#aplicacio}.
	 * @param ctx the parse tree
	 */
	void exitRecursivaAplicacio(hmParser.RecursivaAplicacioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentesiAplicacio}
	 * labeled alternative in {@link hmParser#aplicacio}.
	 * @param ctx the parse tree
	 */
	void enterParentesiAplicacio(hmParser.ParentesiAplicacioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentesiAplicacio}
	 * labeled alternative in {@link hmParser#aplicacio}.
	 * @param ctx the parse tree
	 */
	void exitParentesiAplicacio(hmParser.ParentesiAplicacioContext ctx);
	/**
	 * Enter a parse tree produced by {@link hmParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(hmParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link hmParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(hmParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link hmParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(hmParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link hmParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(hmParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multOp}
	 * labeled alternative in {@link hmParser#op}.
	 * @param ctx the parse tree
	 */
	void enterMultOp(hmParser.MultOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multOp}
	 * labeled alternative in {@link hmParser#op}.
	 * @param ctx the parse tree
	 */
	void exitMultOp(hmParser.MultOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divOp}
	 * labeled alternative in {@link hmParser#op}.
	 * @param ctx the parse tree
	 */
	void enterDivOp(hmParser.DivOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divOp}
	 * labeled alternative in {@link hmParser#op}.
	 * @param ctx the parse tree
	 */
	void exitDivOp(hmParser.DivOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sumOp}
	 * labeled alternative in {@link hmParser#op}.
	 * @param ctx the parse tree
	 */
	void enterSumOp(hmParser.SumOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sumOp}
	 * labeled alternative in {@link hmParser#op}.
	 * @param ctx the parse tree
	 */
	void exitSumOp(hmParser.SumOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code restaOp}
	 * labeled alternative in {@link hmParser#op}.
	 * @param ctx the parse tree
	 */
	void enterRestaOp(hmParser.RestaOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code restaOp}
	 * labeled alternative in {@link hmParser#op}.
	 * @param ctx the parse tree
	 */
	void exitRestaOp(hmParser.RestaOpContext ctx);
}