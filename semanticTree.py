from dataclasses import dataclass, field
from typing import Union, Optional
from enum import Enum


class Op(Enum):
    SUM = '+'
    SUB = '-'
    MUL = '*'
    DIV = '/'

@dataclass
class Numero:
    val: int
    tipus: Optional[str] = None

@dataclass
class Variable:
    id: str
    tipus: Optional[str] = None

@dataclass
class Operador:
    op: Op
    tipus: Optional[str] = None

@dataclass
class Aplicacio:
    esq: Union['Aplicacio', 'Operador']
    dre: 'Expr'
    tipus: Optional[str] = None

@dataclass
class Abstraccio:
    esq: 'Variable'
    dre: 'Expr'
    tipus: Optional[str] = None

Expr = Abstraccio | Aplicacio | Variable | Numero


def termToString(f):
    tipus = f"\n{f.tipus}" if f.tipus else ""
    match f:
        case Abstraccio(_, _):
            return f'λ{tipus}'
        case Aplicacio(_, _):
            # return '@'
            return f'@{tipus}'
        case Variable(iden):
            return f'{iden}{tipus}'
        case Operador(op):
            # return op.value
            return f'({op.value}){tipus}'
        case Numero(val):
            # return str(val)
            return f'{val}{tipus}'

@dataclass 
class SemanticTree:
    root: Expr
    count: int = field(default=0)

    def toDOT(self):
        dot = ["graph {"]
        self.toDOTRecursive(self.root, dot)
        dot.append("}")
        return "\n".join(dot)
    
    def toDOTRecursive(self, node, dot):
        match node:
            case Abstraccio(inp, out):
                nodeIden = self.count
                self.count = self.count + 1
                    
                dot.append(f'   {nodeIden} [label="{termToString(node)}"]')
                fillEsq = self.count
                
                self.toDOTRecursive(inp, dot)
                fillDre = self.count
                
                self.toDOTRecursive(out, dot)
                dot.append(f'   {nodeIden} -- {fillEsq}')
                dot.append(f'   {nodeIden} -- {fillDre}')
                
            case Aplicacio(func, arg):
                nodeIden = self.count
                self.count = self.count + 1
                    
                dot.append(f'   {nodeIden} [label="{termToString(node)}"]')
                fillEsq = self.count
                
                self.toDOTRecursive(func, dot)
                fillDre = self.count
                
                self.toDOTRecursive(arg, dot)
                dot.append(f'   {nodeIden} -- {fillEsq}')
                dot.append(f'   {nodeIden} -- {fillDre}')
                
            case Variable(iden):
                nodeIden = self.count
                self.count = self.count + 1
                dot.append(f'   {nodeIden} [label="{termToString(node)}"]')

            case Operador(op):
                nodeIden = self.count
                self.count = self.count + 1
                dot.append(f'   {nodeIden} [label="{termToString(node)}"]')
                
            case Numero(val):
                nodeIden = self.count
                self.count = self.count + 1
                dot.append(f'   {nodeIden} [label="{termToString(node)}"]')