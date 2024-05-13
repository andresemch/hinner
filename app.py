import streamlit as st
from syntax import syntaxInfo
from hinnerVisitor import hinnerVisitor

st.title("Analitzador de tipus HinNer")

user_input = st.text_input("Expressió lambda:", "")

tree, numErrors, syntaxExpr = syntaxInfo(user_input)

if numErrors > 0:
    st.write("Number of syntax errors: ", numErrors)
    st.write("Parsing of syntax: ", syntaxExpr)
else:
    visitor = hinnerVisitor()
    semTree = visitor.visit(tree)

    dotTree = semTree.toDOT()
    st.graphviz_chart(dotTree)