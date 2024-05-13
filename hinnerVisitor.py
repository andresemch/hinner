from antlr4 import *
from hmParser import hmParser
from hmVisitor import hmVisitor
from semanticTree import *


class hinnerVisitor(ParseTreeVisitor):

    def __init__(self):
        self.taulaTipus = {}

    # Visit a parse tree produced by hmParser#expressio.
    def visitExpressio(self, ctx:hmParser.ExpressioContext):
        [expr] = ctx.getChildren()
        return SemanticTree(self.visit(expr))
    
    # Visit a parse tree produced by hmParser#endfile.
    def visitEndfile(self, ctx:hmParser.EndfileContext):
        return SemanticTree(None)
    
    # Visit a parse tree produced by hmParser#defTipus.
    def visitDefTipus(self, ctx:hmParser.DefTipusContext):
        [expr, _, tipus] = list(ctx.getChildren())
        self.taulaTipus[expr] = tipus

    

    # Visit a parse tree produced by hmParser#expr.
    def visitExpr(self, ctx:hmParser.ExprContext):
        return self.visitChildren(ctx)

    def visitAbstraccio(self, ctx:hmParser.AbstraccioContext):
        [_, var, _, expr] = list(ctx.getChildren())
        return Abstraccio(self.visit(var), self.visit(expr))


    # Visit a parse tree produced by hmParser#parenApli.
    def visitParentesiAplicacio(self, ctx:hmParser.ParentesiAplicacioContext):
        [_, absOp, _, expr] = list(ctx.getChildren())
        return Aplicacio(self.visit(absOp), self.visit(expr))


    # Visit a parse tree produced by hmParser#recurApli.
    def visitRecursivaAplicacio(self, ctx:hmParser.RecursivaAplicacioContext):
        [apli, expr] = list(ctx.getChildren())
        return Aplicacio(self.visit(apli), self.visit(expr))


    # Visit a parse tree produced by hmParser#abstraccio.
    # def visitAbstraccio(self, ctx:hmParser.AbstraccioContext):
    #     left = ctx.left
    #     right = ctx.out

    #     return Abstraccio(self.visit(left), self.visit(right))


    # # Visit a parse tree produced by hmParser#opApp.
    # def visitOpApp(self, ctx:hmParser.OpAppContext):
    #     left = ctx.left
    #     right = ctx.right

    #     return Aplicacio(self.visit(left), self.visit(right))


    # # Visit a parse tree produced by hmParser#extApp.
    # def visitExtApp(self, ctx:hmParser.ExtAppContext):
    #     left = ctx.left
    #     right = ctx.right

    #     return Aplicacio(self.visit(left), self.visit(right))


    # # Visit a parse tree produced by hmParser#absApp.
    # def visitAbsApp(self, ctx:hmParser.AbsAppContext):
    #     left = ctx.left
    #     right = ctx.right

    #     return Aplicacio(self.visit(left), self.visit(right))
    
    # Visit a parse tree produced by hmParser#var.
    def visitVar(self, ctx:hmParser.VarContext):
        [var] = list(ctx.getChildren())
        return Variable(var.getText())


    # Visit a parse tree produced by hmParser#num.
    def visitNum(self, ctx:hmParser.NumContext):
        [num] = list(ctx.getChildren())
        return Numero(int(num.getText()))
    

    # Visit a parse tree produced by hmParser#multOp.
    def visitMultOp(self, ctx:hmParser.MultOpContext):
        return Operador(Op('*'))


    # Visit a parse tree produced by hmParser#divOp.
    def visitDivOp(self, ctx:hmParser.DivOpContext):
        return Operador(Op('/'))


    # Visit a parse tree produced by hmParser#sumOp.
    def visitSumOp(self, ctx:hmParser.SumOpContext):
        return Operador(Op('+'))


    # Visit a parse tree produced by hmParser#restaOp.
    def visitRestaOp(self, ctx:hmParser.RestaOpContext):
        return Operador(Op('-'))