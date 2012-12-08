#!/bin/bash
# xelatex tex/regex.note.tex -output-directory=out -halt-on-error -no-pdf 
xelatex -halt-on-error -no-pdf tex/regex.note.tex 
xelatex -halt-on-error tex/regex.note.tex 

rm -f *.aux *.lof *.log *.lot *.toc *.xdv
find . -name "*.aux"  | xargs rm -f
