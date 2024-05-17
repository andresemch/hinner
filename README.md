# Analitzador de Tipus HinNer

Aquest projecte consisteix en la implementació d'un analitzador de tipus anomenat *HinNer*, desenvolupat com a part de la pràctica de GEI-LP (edició 2023-2024 Q2). L'objectiu principal és crear un sistema d'inferència de tipus utilitzant un llenguatge similar a Haskell, seguint l'algorisme de Hindley-Milner.

## Funcionalitats

### Gramàtica
He definit una gramàtica que reconeix diverses expressions simples del tipus Haskell, com ara:
- **Nombres naturals**: `2`
- **Variables**: `x`
- **Operadors en notació prefixa**: `(+) 2`
- **Aplicació**: `(\x -> (+) 2 x) 4`
- **Abstracció**: `\x -> (+) 2 x`

Aquesta gramàtica permet reconèixer i estructurar correctament les expressions per al seu posterior processament.

### Visitador
He creat un visitador que converteix l'AST (Abstract Syntax Tree) en un arbre semàntic. Aquest arbre semàntic representa l'estructura i el significat de les expressions analitzades. Per a la visualització gràfica de l'arbre semàntic, he utilitzat el mètode `graphviz_chart` de la llibreria Streamlit, permetent així una representació clara i visual de les expressions.

### Gestió de Tipus
El sistema s'ha ampliat per reconèixer definicions de tipus i incloure-les en una taula de símbols. Això permet gestionar correctament els tipus associats a les expressions. Exemples de definicions de tipus inclouen:
- `2 :: N` (el número `2` és de tipus `N`)
- ` (+) :: N -> N -> N` (l'operador `+` és una funció que pren dos arguments de tipus `N` i retorna un valor de tipus `N`)

### Annotació dels AST
He modificat els arbres semàntics per permetre l'assignació d'un tipus a cada node de l'arbre. També he implementat una funció que anota cada node amb el seu tipus corresponent, assignant l'element de la taula de símbols que li pertoqui o una nova variable de tipus. La visualització dels arbres s'ha modificat per mostrar aquests tipus, facilitant així la comprensió del tipus associat a cada part de l'expressió.

### Inferència de Tipus
He implementat funcions d'inferència de tipus per a diferents construccions:
- **Construccions sense abstraccions**: Inferència de tipus per a expressions simples sense l'ús d'abstraccions.
- **Construccions amb abstraccions**: Afegit el processament de l'abstracció per a inferir correctament els tipus en expressions més complexes.

Això inclou la visualització en una taula dels tipus de totes les variables de tipus, proporcionant una visió clara de la inferència de tipus realitzada pel sistema.

## Referències

- [ANTLR en Python](https://gebakx.github.io/Python3/compiladors.html#1)
- [Llibreria Streamlit](https://streamlit.io)
- [Tipus algebraics en Python](https://gebakx.github.io/Python3/tipusAlgebraics.html)
- [Graphviz DOT Language](https://graphviz.org/doc/info/lang.html)
