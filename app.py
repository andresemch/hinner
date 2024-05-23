from antlr4 import *
from hmLexer import hmLexer
from hmParser import hmParser
import streamlit as st
from semanticTree import SemanticTree
from hinnerVisitor import hinnerVisitor
import pandas as pd


def syntaxInfo(input):
    lexer = hmLexer(InputStream(input))
    token_stream = CommonTokenStream(lexer)
    parser = hmParser(token_stream)
    parseTree = parser.root()
    numErrors = parser.getNumberOfSyntaxErrors()
    syntaxExpr = parseTree.toStringTree(recog=parser)
    return parseTree, numErrors, syntaxExpr


def creaTaula(keys, values):
    df = pd.DataFrame({
        "simbol": keys,
        "tipus": values
    },
        dtype=str)
    return df


def addTipus(keys, values, infer):
    addDf = pd.DataFrame({
        "simbol": keys,
        "tipus": values
    }, dtype=str)

    if infer:
        taula = st.session_state.taulaTipusInfer
    else:
        taula = st.session_state.taulaTipus

    for _, row in addDf.iterrows():
        if row['simbol'] in taula['simbol'].values:
            taula.loc[taula['simbol'] == row['simbol'], 'tipus'] = row['tipus']
        else:
            taula = pd.concat([taula, pd.DataFrame([row])], ignore_index=True)

    if infer:
        st.session_state.taulaTipusInfer = taula
    else:
        st.session_state.taulaTipus = taula
    st.dataframe(taula, width=500, hide_index=True)


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

    if isinstance(tree, SemanticTree):
        if not tree.is_empty():
            st.dataframe(
                st.session_state.taulaTipus,
                width=500,
                hide_index=True)
            dotTree = tree.toDOT(st.session_state.taulaTipus, False)
            st.graphviz_chart(dotTree)

            taulaTipusInfer = tree.inferTypes()
            dotTreeInfer = tree.toDOT(None, True)
            st.graphviz_chart(dotTreeInfer)
            st.session_state.taulaTipusInfer = creaTaula([], [])
            addTipus(
                list(
                    taulaTipusInfer.keys()), list(
                    taulaTipusInfer.values()), True)

    else:
        addTipus(list(tree.keys()), list(tree.values()), False)
