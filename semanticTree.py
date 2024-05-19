from dataclasses import dataclass, field
from typing import Union, Optional, Dict, List
from enum import Enum


class Op(Enum):
    SUM = '(+)'
    SUB = '(-)'
    MUL = '(*)'
    DIV = '(/)'

@dataclass
class Abstraccio:
    esq: 'Variable'
    dre: 'Expr'
    # id: str

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
            return 'λ'
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
            self.tablaTipus[nodeStr] = self.nousTipus[0]
            if nodeStr.startswith('@'):
                nodeStr, _ = nodeStr.split(':')
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

    def toDOTinfer(self):
        print(self.tablaTipus)

        dot = ["graph {"]
        self.toDOTInferRecursive(self.root, dot)
        dot.append("}")

        return "\n".join(dot)
    
    def toDOTInferRecursive(self, node, dot):
        nodeStr = termToString(node)
        tipus = self.tablaTipus[nodeStr]
        if nodeStr.startswith('@'):
            nodeStr, _ = nodeStr.split(':')
            nodeStr += f"\n{self.tablaInferTipus[tipus]}"
        elif nodeStr in self.tablaTipus:
            if tipus.islower():
                nodeStr += f"\n{self.tablaInferTipus[tipus]}"
            else:
                nodeStr += f"\n{tipus}"

        match node:
            # case Abstraccio(inp, out):
            #     nodeIden = self.count
            #     self.count = self.count + 1
                    
            #     dot.append(f'   {nodeIden} [label="{nodeStr}"]')
            #     fillEsq = self.count
                
            #     self.toDOTInferRecursive(inp, dot)
            #     fillDre = self.count
                
            #     self.toDOTInferRecursive(out, dot)
            #     dot.append(f'   {nodeIden} -- {fillEsq}')
            #     dot.append(f'   {nodeIden} -- {fillDre}')
                
            case Aplicacio(func, arg):
                nodeIden = self.count
                self.count = self.count + 1
                    
                dot.append(f'   {nodeIden} [label="{nodeStr}"]')
                fillEsq = self.count
                
                self.toDOTInferRecursive(func, dot)
                fillDre = self.count
                
                self.toDOTInferRecursive(arg, dot)
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


    def get_type(self, identifier: str) -> str:
        """Obtiene el tipo de un identificador, si está disponible."""
        try:
            return self.tablaTipus[identifier]
        except KeyError:
            return "Unknown"
    
    def infer_types(self):
        """Recorre el árbol y asigna tipos a cada nodo."""
        self.infer_types_node(self.root)
        # print(self.tablaInferTipus)
        return self.tablaInferTipus
    
    def inferTipusAplicacio(self, func_type, arg_type):
        # Asegúrate de que los tipos son cadenas antes de proceder
        if not isinstance(func_type, str):
            raise TypeError(f"Expected string for func_type, got {type(func_type).__name__}")

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
                elif func_type[i:i+2] == '->' and paren_balance == 0:
                    arrow_index = i
                    break

            if arrow_index != -1:
                input_type = func_type[:arrow_index].strip()
                output_type = func_type[arrow_index+2:].strip()

            # input_type, output_type = func_type.split('->', 1)
            # input_type = input_type.strip().strip('()')
            # output_type = output_type.strip().strip('()')

            print(input_type)
            print(arg_type)

            if arg_type.isupper() and arg_type != input_type:
                raise TypeError(f"Type error: {input_type} vs {arg_type}")

            if arg_type.strip().islower(): # arg_type no tiene un tipo asignado
                # HAZ ALGO CON EL TIPO ARG_TYPE
                self.tablaInferTipus[arg_type] = input_type
                return output_type
            elif input_type == arg_type.strip():
                return output_type  # Retorna el tipo resultante de la aplicación
            else:
                raise TypeError(f"Type mismatch: cannot apply {arg_type} to {func_type}")
        else:
            raise TypeError(f"Invalid function type: {func_type}")

    def infer_types_node(self, node):
        type = "Unknown"
        match node:
            case Variable(_) | Operador(_) | Numero(_):
                return self.get_type(termToString(node))
            case Aplicacio(func, arg):
                func_type = self.infer_types_node(func)
                arg_type = self.infer_types_node(arg)

                nodeType = self.tablaTipus[termToString(node)]
                aplicacioTipus = self.inferTipusAplicacio(func_type, arg_type)

                self.tablaInferTipus[nodeType] = aplicacioTipus

                return aplicacioTipus



    def unify_types(self, type1: str, type2: str) -> str:
        # Implementación básica de unificación de tipos
        if type1 == type2:
            return type1
        else:
            raise TypeError(f"Cannot unify types {type1} and {type2}")