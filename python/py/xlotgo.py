# coding=utf-8
# 本程序的作用是自动执行两次xelatex并且删除临时文件
# 执行两遍 xelatex -halt-on-error  sys.argv[1], 然后显示pdf
import os,sys,WConio

helpmsg="""usage: xltgo texfile [options]
options:
    -showpdf:  show pdf after compiled
    -encrypt:  encrtypt pdf    
e.g: xltgo youfile
     xltgo youfile.tex -showpdf -encrypt"""

def printgoodnews(message):
    global attr
    WConio.textcolor(WConio.GREEN)
    total_chars=80
    ll=len(message)
    start=(total_chars-ll)/2
    print "-"*start+message+"-"*(80-start-ll)
    WConio.textcolor(attr)
    
def printbadnews(message):
    global attr
    WConio.textcolor(WConio.GREEN)
    total_chars=80
    ll=len(message)
    start=(total_chars-ll)/2
    print "-"*start+message+"-"*(80-start-ll)
    WConio.textcolor(attr)
    
def cleartmpfiles(file):
    dir=os.path.dirname(file)
    filename=os.path.basename(file)
    if (filename[-4:]).upper()=='.TEX':
        filename=filename[:-4]
    tmpexts=['.aux','.log','.nav','.out','.snm','.toc','vrb','.xdv']
    
    for ext in tmpexts:
        tmpfile=os.path.join(dir,filename)+ext
        #print tmpfile
        if os.path.exists(tmpfile):
            print "Deleting %s" % tmpfile
            os.unlink(tmpfile)

if __name__=='__main__':
    attr=WConio.gettextinfo()[4]
    if len(sys.argv)==1:
       print helpmsg 
    if len(sys.argv)>1 :
        options=[option.upper() for option in sys.argv[1:]]

        exist=False
        out_dir=os.path.dirname(os.path.abspath(sys.argv[1]))
        filename=os.path.abspath(sys.argv[1])
        filename_noext=filename
        if os.path.abspath(sys.argv[1])[-4:].upper()=='.TEX':
            filename_noext=sys.argv[1][:-4]
        if os.path.abspath(sys.argv[1])[-4:].upper()=='.TEX' :
            exist= os.path.exists(filename)
        else:
            exist= os.path.exists(filename_noext+".tex")

        if exist:                    
            printgoodnews('xelatex -halt-on-error -no-pdf -output-directory="%s" "%s"' %(out_dir,filename))
            i=-1
            j=-1
            k=-1
            i=os.system('xelatex -halt-on-error -no-pdf -output-directory="%s" "%s"' %(out_dir, filename))
            if i==0:
                printgoodnews("The xelatex 1st run finished!")
                j=os.system('xelatex -halt-on-error -no-pdf -output-directory="%s" "%s"' %(out_dir, filename))
                if  j==0:
                    printgoodnews("The xelatex 2nd run finished!")

                    if '-ENCRYPT' in options:
                        k=os.system('xdvipdfmx -r 600 -E -V 5 -S -K 128 -P 0x0804 -o "%s.pdf" "%s.xdv"' % (filename_noext,filename_noext))
                    else:
                        k=os.system('xdvipdfmx -r 600 -E -V 5 -o "%s.pdf" "%s.xdv"' % (filename_noext,filename_noext))
                    
                    if k==0:
                        printgoodnews("xdvipdfmx finished!")
                        if '-SHOWPDF' in options:
                            k=os.startfile(filename_noext+".pdf")
                            printgoodnews("Command 'showpdf' was executed!")
                        cleartmpfiles(sys.argv[1])
                        printgoodnews("All finished!")
                        sys.exit(0)                            
                    else:
                        printbadnews("Error on xdvipdfmx!")
                        sys.exit(-1)
                else:
                    printbadnews("Error on the 2rd run !")
                    cleartmpfiles(sys.argv[1])
                    sys.exit(-1)
            else:
                printbadnews("Error on the 1st run !")
                cleartmpfiles(sys.argv[1])
                sys.exit(-1)
        else:
            printbadnews( "Error: where is your tex file %s?'"%sys.argv[1])
            sys.exit(-1)
