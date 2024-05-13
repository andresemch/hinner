from dataclasses import dataclass, field
from typing import Union
from enum import Enum


class Op(Enum):
    SUM = '+'
    SUB = '-'
    MUL = '*'
    DIV = '/'

@dataclass
class Numero:
    val: int

@dataclass
class Variable:
    id: str

@dataclass
class Operador:
    op: Op

@dataclass
class Aplicacio:
    left: Union['Aplicacio', 'Operador']
    right: 'Expr'

@dataclass
class Abstraccio:
    left: 'Variable'
    right: 'Expr'

Expr = Abstraccio | Aplicacio | Variable | Numero


def termToString(f):
    match f:
        case Abstraccio(_, _):
            return 'λ'
        case Aplicacio(_, _):
            return '@'
        case Variable(iden):
            return iden
        case Operador(op):
            return op.value
        case Numero(val):
            return str(val)

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
                nodeID = self.count
                self.count = self.count + 1
                    
                dot.append(f'   {nodeID} [label="{termToString(node)}"]')
                
                child1ID = self.count
                
                self.toDOTRecursive(inp, dot)
                
                child2ID = self.count
                
                self.toDOTRecursive(out, dot)
                
                dot.append(f'   {nodeID} -- {child1ID}')
                dot.append(f'   {nodeID} -- {child2ID}')
                
            case Aplicacio(func, arg):
                nodeID = self.count
                self.count = self.count + 1
                    
                dot.append(f'   {nodeID} [label="{termToString(node)}"]')
                
                child1ID = self.count
                
                self.toDOTRecursive(func, dot)
                
                child2ID = self.count
                
                self.toDOTRecursive(arg, dot)
                
                dot.append(f'   {nodeID} -- {child1ID}')
                dot.append(f'   {nodeID} -- {child2ID}')
                
            case Variable(iden):
                nodeID = self.count
                self.count = self.count + 1
                    
                dot.append(f'   {nodeID} [label="{termToString(node)}"]')
            case Operador(op):
                nodeID = self.count
                self.count = self.count + 1
                    
                dot.append(f'   {nodeID} [label="{termToString(node)}"]')
            case Numero(val):
                nodeID = self.count
                self.count = self.count + 1
                    
                dot.append(f'   {nodeID} [label="{termToString(node)}"]')