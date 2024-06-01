from antlr4 import *
from hmLexer import hmLexer
from hmParser import hmParser

from dataclasses import dataclass, field
from typing import Union, Optional, Dict, List
from enum import Enum

import streamlit as st
import pandas as pd


class Op(Enum):
    SUM = '(+)'
    SUB = '(-)'
    MUL = '(*)'
    DIV = '(/)'


@dataclass
class Abstraccio:
    esq: 'Variable'
    dre: 'Expr'
    id: str


@dataclass
class Aplicacio:
    esq: Union['Aplicacio', 'Operador']
    dre: 'Expr'
    id: str


@dataclass
class Variable:
    id: str


@dataclass
class Operador:
    op: Op


@dataclass
class Numero:
    val: str


Expr = Abstraccio | Aplicacio | Variable | Numero


def termToString(f):
    match f:
        case Abstraccio(_, _):
            return f'λ:{f.id}'
        case Aplicacio(_, _):
            return f'@:{f.id}'
        case Variable(iden):
            return iden
        case Operador(op):
            return op.value
        case Numero(val):
            return val


@dataclass
class SemanticTree:
    root: Optional[Expr] = None
    count: int = field(default=0)
    tablaTipus: Dict[str, str] = field(default_factory=dict)
    tablaInferTipus: Dict[str, str] = field(default_factory=dict)
    nousTipus: List[str] = field(
        default_factory=lambda: [
            chr(i) for i in range(
                ord('a'), ord('z') + 1)])

    def is_empty(self):
        return self.root is None

    def toDOT(self, df, infer):
        if not infer:
            self.tablaTipus = df.set_index('simbol')['tipus'].to_dict()
        dot = ["graph {"]
        self.toDOTRecursive(self.root, dot, infer)
        dot.append("}")
        return "\n".join(dot)

    def toDOTRecursive(self, node, dot, infer):
        if infer:
            nodeStr = termToString(node)
            tipus = self.tablaTipus[nodeStr]
            if nodeStr.startswith(('@', 'λ')):
                nodeStr, _ = nodeStr.split(':')
                nodeStr += f"\n{self.tablaInferTipus[tipus]}"
            elif nodeStr in self.tablaTipus:
                if tipus.islower():
                    nodeStr += f"\n{self.tablaInferTipus[tipus]}"
                else:
                    nodeStr += f"\n{tipus}"
        else:
            nodeStr = termToString(node)
            if nodeStr in self.tablaTipus:
                nodeStr += f"\n{self.tablaTipus[termToString(node)]}"
            else:
                self.tablaTipus[nodeStr] = self.nousTipus[0]
                if nodeStr.startswith(('@', 'λ')):
                    nodeStr, _ = nodeStr.split(':')
                nodeStr += f"\n{self.nousTipus[0]}"
                self.nousTipus.pop(0)

        match node:
            case Abstraccio(inp, out):
                nodeIden = self.count
                self.count = self.count + 1

                dot.append(f'   {nodeIden} [label="{nodeStr}"]')
                fillEsq = self.count

                self.toDOTRecursive(inp, dot, infer)
                fillDre = self.count

                self.toDOTRecursive(out, dot, infer)
                dot.append(f'   {nodeIden} -- {fillEsq}')
                dot.append(f'   {nodeIden} -- {fillDre}')

            case Aplicacio(func, arg):
                nodeIden = self.count
                self.count = self.count + 1

                dot.append(f'   {nodeIden} [label="{nodeStr}"]')
                fillEsq = self.count

                self.toDOTRecursive(func, dot, infer)
                fillDre = self.count

                self.toDOTRecursive(arg, dot, infer)
                dot.append(f'   {nodeIden} -- {fillEsq}')
                dot.append(f'   {nodeIden} -- {fillDre}')

            case Variable(_):
                nodeIden = self.count
                self.count = self.count + 1
                dot.append(f'   {nodeIden} [label="{nodeStr}"]')

            case Operador(_):
                nodeIden = self.count
                self.count = self.count + 1
                dot.append(f'   {nodeIden} [label="{nodeStr}"]')

            case Numero(_):
                nodeIden = self.count
                self.count = self.count + 1
                dot.append(f'   {nodeIden} [label="{nodeStr}"]')

    def getType(self, id):
        try:
            return self.tablaTipus[id]
        except KeyError:
            return "Unknown"

    def inferTypes(self):
        self.inferTypesNode(self.root)
        return self.tablaInferTipus

    def inferTipusAplicacio(self, func_type, arg_type):
        if not isinstance(func_type, str):
            raise TypeError(
                f"Expected string for func_type, got {type(func_type).__name__}")

        if '->' in func_type:
            parentesi = func_type.find('(')
            if parentesi != -1:
                func_type = func_type[1:-1]

            paren_balance = 0
            arrow_index = -1
            for i in range(len(func_type) - 1):
                if func_type[i] == '(':
                    paren_balance += 1
                elif func_type[i] == ')':
                    paren_balance -= 1
                elif func_type[i:i + 2] == '->' and paren_balance == 0:
                    arrow_index = i
                    break

            if arrow_index != -1:
                input_type = func_type[:arrow_index].strip()
                output_type = func_type[arrow_index + 2:].strip()

            if arg_type.isupper() and arg_type != input_type:
                raise TypeError(f"Type error: {input_type} vs {arg_type}")
            if arg_type.strip().islower():
                self.tablaInferTipus[arg_type] = input_type
                return output_type
            elif input_type == arg_type.strip():
                return output_type
            else:
                raise TypeError(
                    f"Type mismatch: cannot apply {arg_type} to {func_type}")
        else:
            raise TypeError(f"Invalid function type: {func_type}")

    def inferTipusAbstraccio(self, var_type, expr_type):
        if not isinstance(var_type, str):
            raise TypeError(
                f"Expected string for func_type, got {type(var_type).__name__}")

        if var_type.islower():
            var_type = self.tablaInferTipus[var_type]
        if expr_type.islower():
            expr_type = self.tablaInferTipus[expr_type]

        output_type = '(' + var_type + '->' + expr_type + ')'
        return output_type

    def inferTypesNode(self, node):
        type = "Unknown"
        match node:
            case Variable(_) | Operador(_) | Numero(_):
                return self.getType(termToString(node))

            case Aplicacio(func, arg):
                func_type = self.inferTypesNode(func)
                arg_type = self.inferTypesNode(arg)

                nodeType = self.tablaTipus[termToString(node)]
                aplicacioTipus = self.inferTipusAplicacio(func_type, arg_type)

                self.tablaInferTipus[nodeType] = aplicacioTipus
                return aplicacioTipus

            case Abstraccio(var, expr):
                var_type = self.inferTypesNode(var)
                expr_type = self.inferTypesNode(expr)

                nodeType = self.tablaTipus[termToString(node)]
                abstraccioTipus = self.inferTipusAbstraccio(
                    var_type, expr_type)

                self.tablaInferTipus[nodeType] = abstraccioTipus
                return abstraccioTipus


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


def syntaxInfo(input):
    lexer = hmLexer(InputStream(input))
    token_stream = CommonTokenStream(lexer)
    parser = hmParser(token_stream)
    parseTree = parser.root()
    numErrors = parser.getNumberOfSyntaxErrors()
    syntaxExpr = parseTree.toStringTree(recog=parser)
    return parseTree, numErrors, syntaxExpr


def creaTaula(keys, values):
    df = pd.DataFrame({
        "simbol": keys,
        "tipus": values
    },
        dtype=str)
    return df


def addTipus(keys, values, infer):
    addDf = pd.DataFrame({
        "simbol": keys,
        "tipus": values
    }, dtype=str)

    if infer:
        taula = st.session_state.taulaTipusInfer
    else:
        taula = st.session_state.taulaTipus

    for _, row in addDf.iterrows():
        if row['simbol'] in taula['simbol'].values:
            taula.loc[taula['simbol'] == row['simbol'], 'tipus'] = row['tipus']
        else:
            taula = pd.concat([taula, pd.DataFrame([row])], ignore_index=True)

    if infer:
        st.session_state.taulaTipusInfer = taula
    else:
        st.session_state.taulaTipus = taula
    st.dataframe(taula, width=500, hide_index=True)


st.title("Analitzador de tipus HinNer")
user_input = st.text_input("Expressió lambda:", "")

if 'taulaTipus' not in st.session_state:
    st.session_state.taulaTipus = creaTaula([], [])

tree, errors, syntax = syntaxInfo(user_input)

if errors > 0:
    st.write("Number of syntax errors: ", errors)
    st.write("Parsing of syntax: ", syntax)
else:
    visitor = hinnerVisitor()
    tree = visitor.visit(tree)

    if isinstance(tree, SemanticTree):
        if not tree.is_empty():
            st.dataframe(
                st.session_state.taulaTipus,
                width=500,
                hide_index=True)
            dotTree = tree.toDOT(st.session_state.taulaTipus, False)
            st.graphviz_chart(dotTree)

            taulaTipusInfer = tree.inferTypes()
            dotTreeInfer = tree.toDOT(None, True)
            st.graphviz_chart(dotTreeInfer)
            st.session_state.taulaTipusInfer = creaTaula([], [])
            addTipus(
                list(
                    taulaTipusInfer.keys()), list(
                    taulaTipusInfer.values()), True)

    else:
        addTipus(list(tree.keys()), list(tree.values()), False)
