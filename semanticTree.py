from dataclasses import dataclass, field
from typing import Union, Optional, Dict, List
from enum import Enum


class Op(Enum):
    SUM = '(+)'
    SUB = '(-)'
    MUL = '(*)'
    DIV = '(/)'

@dataclass
class Numero:
    val: str

@dataclass
class Variable:
    id: str

@dataclass
class Operador:
    op: Op

@dataclass
class Aplicacio:
    esq: Union['Aplicacio', 'Operador']
    dre: 'Expr'

@dataclass
class Abstraccio:
    esq: 'Variable'
    dre: 'Expr'

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
            return val

@dataclass 
class SemanticTree:
    root: Optional[Expr] = None
    count: int = field(default=0)
    tablaTipus: Dict[str, str] = field(default_factory=dict)
    nousTipus: List[str] = field(default_factory=lambda: [chr(i) for i in range(ord('a'), ord('z') + 1)])

    def is_empty(self):
        return self.root is None

    def toDOT(self, df):
        self.tablaTipus = df.set_index('simbol')['tipus'].to_dict()
        dot = ["graph {"]
        self.toDOTRecursive(self.root, dot)
        dot.append("}")
        return "\n".join(dot)
    
    def toDOTRecursive(self, node, dot):
        nodeStr = termToString(node)
        
        if nodeStr in self.tablaTipus:
            nodeStr += f"\n{self.tablaTipus[termToString(node)]}"
        else:
            nodeStr += f"\n{self.nousTipus[0]}"
            self.nousTipus.pop(0)

        match node:
            case Abstraccio(inp, out):
                nodeIden = self.count
                self.count = self.count + 1
                    
                dot.append(f'   {nodeIden} [label="{nodeStr}"]')
                fillEsq = self.count
                
                self.toDOTRecursive(inp, dot)
                fillDre = self.count
                
                self.toDOTRecursive(out, dot)
                dot.append(f'   {nodeIden} -- {fillEsq}')
                dot.append(f'   {nodeIden} -- {fillDre}')
                
            case Aplicacio(func, arg):
                nodeIden = self.count
                self.count = self.count + 1
                    
                dot.append(f'   {nodeIden} [label="{nodeStr}"]')
                fillEsq = self.count
                
                self.toDOTRecursive(func, dot)
                fillDre = self.count
                
                self.toDOTRecursive(arg, dot)
                dot.append(f'   {nodeIden} -- {fillEsq}')
                dot.append(f'   {nodeIden} -- {fillDre}')
                
            case Variable(iden):
                nodeIden = self.count
                self.count = self.count + 1
                dot.append(f'   {nodeIden} [label="{nodeStr}"]')

            case Operador(op):
                nodeIden = self.count
                self.count = self.count + 1
                dot.append(f'   {nodeIden} [label="{nodeStr}"]')
                
            case Numero(val):
                nodeIden = self.count
                self.count = self.count + 1
                dot.append(f'   {nodeIden} [label="{nodeStr}"]')