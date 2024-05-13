from antlr4 import *
from hmLexer import hmLexer
from hmParser import hmParser
from hmVisitor import hmVisitor
import sys


class EvalVisitor(hmVisitor):

    def visitRoot(self, ctx:hmParser.RootContext):
        return self.visitChildren(ctx)

    def visitInstru(self, ctx:hmParser.InstruContext):
        return self.visitChildren(ctx)

    def visitParentesi(self, ctx:hmParser.ParentesiContext):
        return self.visitChildren(ctx)

    def visitPotencia(self, ctx:hmParser.PotenciaContext):
        return self.visitChildren(ctx)

    def visitMultDiv(self, ctx:hmParser.MultDivContext):
        return self.visitChildren(ctx)

    def visitSumaResta(self, ctx:hmParser.SumaRestaContext):
        return self.visitChildren(ctx)

    def visitNumero(self, ctx:hmParser.NumeroContext):
        return self.visitChildren(ctx)

    def visitVariable(self, ctx:hmParser.VariableContext):
        return self.visitChildren(ctx)

    def visitAbstraccio(self, ctx:hmParser.AbstraccioContext):
        return self.visitChildren(ctx)

    def visitAplicacio(self, ctx:hmParser.AplicacioContext):
        return self.visitChildren(ctx)


#while(True):
#try:
def main():
    #input_stream = InputStream(input('? '))
    input_stream = FileStream(sys.argv[1])
    lexer = hmLexer(input_stream)
    token_stream = CommonTokenStream(lexer)
    parser = hmParser(token_stream)
    tree = parser.root()


    if parser.getNumberOfSyntaxErrors() == 0:
        visitor = EvalVisitor()
        visitor.visit(tree)
    else:
        print(parser.getNumberOfSyntaxErrors(), 'errors de sintaxi.')
        print(tree.toStringTree(recog=parser))

if __name__ == '__main__':
    main()



