#!/bin/bash
# xelatex tex/java.tcp.ip.tex -output-directory=out -halt-on-error -no-pdf 
xelatex -halt-on-error -no-pdf tex/java.tcp.ip.tex 
xelatex -halt-on-error tex/java.tcp.ip.tex 

rm -f *.aux *.lof *.log *.lot *.toc *.xdv
find . -name "*.aux"  | xargs rm -f
