#!/bin/bash
# xelatex tex/java.tcp.ip.tex -output-directory=out -halt-on-error -no-pdf 
xelatex -halt-on-error -no-pdf tex/ant.tex 
xelatex -halt-on-error tex/ant.tex 

rm -f *.aux *.lof *.log *.lot *.toc *.xdv
find . -name "*.aux"  | xargs rm -f
