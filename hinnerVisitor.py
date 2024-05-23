from antlr4 import *
from hmParser import hmParser
from hmVisitor import hmVisitor
from semanticTree import *


class hinnerVisitor(ParseTreeVisitor):

    def __init__(self) -> None:
        self.idsAplicacio = [str(i) for i in range(1, 28)]
        self.idsAbstraccio = [str(i) for i in range(1, 28)]

    # Visit a parse tree produced by hmParser#rootExpr.
    def visitRootExpr(self, ctx: hmParser.RootExprContext):
        [expr] = ctx.getChildren()
        return SemanticTree(self.visit(expr))

    # Visit a parse tree produced by hmParser#rootTipus.
    def visitRootTipus(self, ctx: hmParser.RootTipusContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by hmParser#endfile.
    def visitEndfile(self, ctx: hmParser.EndfileContext):
        return SemanticTree(None)

    ##### TYPE VISITOR #####
    # Start

    # Visit a parse tree produced by hmParser#numTipus.
    def visitNumTipus(self, ctx: hmParser.NumTipusContext):
        symbol = self.visit(ctx.left).val
        type_info = self.visit(ctx.right)

        return {symbol: type_info}

    # Visit a parse tree produced by hmParser#opTipus.
    def visitOpTipus(self, ctx: hmParser.OpTipusContext):
        symbol = self.visit(ctx.left).op.value
        type_info = self.visit(ctx.right)

        return {symbol: type_info}

    # Visit a parse tree produced by hmParser#funcTipus.
    def visitFuncTipus(self, ctx: hmParser.FuncTipusContext):
        left_type = self.visit(ctx.elemTipus())
        right_type = self.visit(ctx.tipus())

        return f"({left_type} -> {right_type})"

    # Visit a parse tree produced by hmParser#basicTipus.
    def visitBasicTipus(self, ctx: hmParser.BasicTipusContext):
        return self.visit(ctx.elemTipus())

    # Visit a parse tree produced by hmParser#elemTipus.
    def visitElemTipus(self, ctx: hmParser.ElemTipusContext):
        return ctx.getText()

    # End
    ##### TYPE VISITOR #####

    # Visit a parse tree produced by hmParser#expr.
    def visitExpr(self, ctx: hmParser.ExprContext):
        return self.visitChildren(ctx)

    def visitAbstraccio(self, ctx: hmParser.AbstraccioContext):
        [_, var, _, expr] = list(ctx.getChildren())
        idAbst = self.idsAbstraccio[0]
        self.idsAbstraccio.pop(0)
        return Abstraccio(esq=self.visit(var), dre=self.visit(expr), id=idAbst)

    # Visit a parse tree produced by hmParser#parenApli.
    def visitParentesiAplicacio(self, ctx: hmParser.ParentesiAplicacioContext):
        [_, absOp, _, expr] = list(ctx.getChildren())
        idApli = self.idsAplicacio[0]
        self.idsAplicacio.pop(0)
        return Aplicacio(
            esq=self.visit(absOp),
            dre=self.visit(expr),
            id=idApli)

    # Visit a parse tree produced by hmParser#recurApli.
    def visitRecursivaAplicacio(self, ctx: hmParser.RecursivaAplicacioContext):
        [apli, expr] = list(ctx.getChildren())
        idApli = self.idsAplicacio[0]
        self.idsAplicacio.pop(0)
        return Aplicacio(esq=self.visit(apli), dre=self.visit(expr), id=idApli)

    # Visit a parse tree produced by hmParser#var.
    def visitVar(self, ctx: hmParser.VarContext):
        [var] = list(ctx.getChildren())
        return Variable(id=var.getText())

    # Visit a parse tree produced by hmParser#num.
    def visitNum(self, ctx: hmParser.NumContext):
        [num] = list(ctx.getChildren())
        return Numero(val=num.getText())

    # Visit a parse tree produced by hmParser#multOp.
    def visitMultOp(self, ctx: hmParser.MultOpContext):
        return Operador(Op('(*)'))

    # Visit a parse tree produced by hmParser#divOp.
    def visitDivOp(self, ctx: hmParser.DivOpContext):
        return Operador(Op('(/'))

    # Visit a parse tree produced by hmParser#sumOp.
    def visitSumOp(self, ctx: hmParser.SumOpContext):
        return Operador(Op('(+)'))

    # Visit a parse tree produced by hmParser#restaOp.
    def visitRestaOp(self, ctx: hmParser.RestaOpContext):
        return Operador(Op('(-)'))
