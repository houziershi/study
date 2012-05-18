#!/bin/bash
# xelatex tex/python.note.tex -output-directory=out -halt-on-error -no-pdf 
xelatex -halt-on-error -no-pdf tex/python.note.tex 
xelatex -halt-on-error tex/python.note.tex 

rm -f *.aux *.lof *.log *.lot *.toc *.xdv
rm -f tex/*.aux
