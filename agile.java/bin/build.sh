#!/bin/bash
# xelatex tex/python.note.tex -output-directory=out -halt-on-error -no-pdf 
xelatex -halt-on-error -no-pdf tex/agile.java.tex 
xelatex -halt-on-error tex/agile.java.tex 

rm -f *.aux *.lof *.log *.lot *.toc *.xdv
rm -f tex/*.aux
