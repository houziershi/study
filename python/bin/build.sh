#!/bin/bash
# xelatex tex/python.note.tex -output-directory=out -halt-on-error -no-pdf 
xelatex -halt-on-error -no-pdf tex/python.note.tex 
xelatex -halt-on-error tex/python.note.tex 

