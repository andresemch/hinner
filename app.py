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
    print(syntaxExpr)

    ##### FALTA
        # 4b
        # No añadir repetidos a la lista de tipo_table
    if type(tree) is SemanticTree:
        if not tree.is_empty():
            st.dataframe(st.session_state.tipo_table, width=500, hide_index=True)
            dotTree = tree.toDOT(st.session_state.tipo_table)
            st.graphviz_chart(dotTree)
    else:
        addType(list(tree.keys()), list(tree.values()))



