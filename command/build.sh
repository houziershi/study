#!/bin/bash
# xelatex tex/command.tex -output-directory=out -halt-on-error -no-pdf 
xelatex -halt-on-error -no-pdf tex/command.tex 
xelatex -halt-on-error tex/command.tex 

rm -f *.aux *.lof *.log *.lot *.toc *.xdv
find . -name "*.aux"  | xargs rm -f
