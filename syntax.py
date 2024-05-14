from antlr4 import *
from hmLexer import hmLexer
from hmParser import hmParser

def syntaxInfo(input):
    lexer = hmLexer(InputStream(input))
    token_stream = CommonTokenStream(lexer)
    parser = hmParser(token_stream)
    parseTree = parser.root()
    numErrors = parser.getNumberOfSyntaxErrors()
    syntaxExpr = parseTree.toStringTree(recog=parser)
    return parseTree, numErrors, syntaxExpr