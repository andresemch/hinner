import streamlit as st
from semanticTree import SemanticTree
from syntax import syntaxInfo
from hinnerVisitor import hinnerVisitor
import pandas as pd

def createType(keys, values):
    df = pd.DataFrame({
        "simbol": keys,
        "tipus": values
    },
    dtype=str)
    return df

def addType(new_keys, new_values):
    print(len(new_values))
    new_df = pd.DataFrame({
        "simbol": new_keys,
        "tipus": new_values
    },
    dtype=str)
    updated_df = pd.concat([st.session_state.tipo_table, new_df], ignore_index=True)
    st.session_state.tipo_table = updated_df
    st.dataframe(st.session_state.tipo_table, width=500, hide_index=True)


st.title("Analitzador de tipus HinNer")
user_input = st.text_input("Expressió lambda:", "")

if 'tipo_table' not in st.session_state:
    st.session_state.tipo_table = createType([], [])

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
        st.dataframe(st.session_state.tipo_table, width=500, hide_index=True)
        dotTree = tree.toDOT()
        st.graphviz_chart(dotTree)

        # typeDict = tree.getTipus()
        # createType(list(typeDict.keys()), list(typeDict.values()))
    else:
        # typeDict = {}
        # typeDict.update(tree)
        # createType(list(tree.keys()), list(tree.values()))

        addType(list(tree.keys()), list(tree.values()))
        # addType(tabla, tree.keys(), tree.values())



