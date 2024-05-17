import streamlit as st
from semanticTree import SemanticTree
from syntax import syntaxInfo
from hinnerVisitor import hinnerVisitor
import pandas as pd

def creaTaula(keys, values):
    df = pd.DataFrame({
        "simbol": keys,
        "tipus": values
    },
    dtype=str)
    return df

def addTipus(keys, values):
    addDf = pd.DataFrame({
        "simbol": keys,
        "tipus": values
    },
    dtype=str)

    listaKeys = set(st.session_state.taulaTipus['simbol'])
    existValue = addDf[~addDf['simbol'].isin(listaKeys)]

    if not existValue.empty:
        nouDf = pd.concat([st.session_state.taulaTipus, addDf], ignore_index=True)
        st.session_state.taulaTipus = nouDf
    st.dataframe(st.session_state.taulaTipus, width=500, hide_index=True)


st.title("Analitzador de tipus HinNer")
user_input = st.text_input("Expressió lambda:", "")

if 'taulaTipus' not in st.session_state:
    st.session_state.taulaTipus = creaTaula([], [])

tree, errors, syntax = syntaxInfo(user_input)

if errors > 0:
    st.write("Number of syntax errors: ", errors)
    st.write("Parsing of syntax: ", syntax)
else:
    visitor = hinnerVisitor()
    tree = visitor.visit(tree)
    print(syntax)

    if type(tree) is SemanticTree:
        if not tree.is_empty():
            st.dataframe(st.session_state.taulaTipus, width=500, hide_index=True)
            dotTree = tree.toDOT(st.session_state.taulaTipus)
            st.graphviz_chart(dotTree)
    else:
        addTipus(list(tree.keys()), list(tree.values()))



