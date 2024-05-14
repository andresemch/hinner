import streamlit as st
from semanticTree import SemanticTree
from syntax import syntaxInfo
from hinnerVisitor import hinnerVisitor
import pandas as pd

def createType(keys, values):
    df = pd.DataFrame(
        {
            "simbol": keys,
            "tipus": values
        }
    )
    table = st.dataframe(
        df,
        column_config={
            "simbol": "Simbol",
            "tipus": "Tipus",
        },
        width=500,
        hide_index=True
    )
    return table



def addType(t, simbol, tipus):
    t.add_rows(pd.DataFrame(
        {
            "simbol": [simbol],
            "tipus": [tipus]
        }
    ))

st.title("Analitzador de tipus HinNer")
user_input = st.text_input("Expressió lambda:", "")
tree, numErrors, syntaxExpr = syntaxInfo(user_input)

if numErrors > 0:
    st.write("Number of syntax errors: ", numErrors)
    st.write("Parsing of syntax: ", syntaxExpr)
else:
    visitor = hinnerVisitor()
    tree = visitor.visit(tree)

    dotTree = SemanticTree(None).toDOT()

    print(syntaxExpr)

    if type(tree) is SemanticTree:
        dotTree = tree.toDOT()
        st.graphviz_chart(dotTree)
    else:
        typeDict = {}
        typeDict.update(tree)
        createType(list(tree.keys()), list(tree.values()))



