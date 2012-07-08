# coding=utf-8

# use oct and hex
print str(42)
print int("42")
print str(3.14159265)
print float("1.234E-10")

print ord('\n')       # show 10, because'\n' binary value is 0x10
print ord('s')          # 115
print chr(115)          # s

s = '\001\002\x03'
print s
print len(s)            # 3

# user unicode
print u'spam'
print u'ab\x20cd'       # 1-byte char : ab cd
print u'ab\u0020cd'     # 2-byte char : ab cd
print u'ab\U00000020cd' # 4-byte char : ab cd

# do not escape
print r'c:\new\text.txt'

# corss lines 
print """ threre is 
cross lines...
hahahah....  """

print ''' threre is 
cross lines...
hahahah....  '''


line = '   aaa,bbb,ccc,ddd,eee   '
print line.lstrip()
print line.rstrip()
print line.upper()
print line.isalpha()       # False
print 'abc'.endswith('c')  # True

# join up the string
print 'aaa' + "bbb"    # aaabbb
print 'aaa' "bbb"      # aaabbb

# create a list
ll =  'aaa',"bbb"      # ('aaa','bbb')

# string format
exclamation = "Ni"

print "%d %s %d you" % (1, 'spam', 4)
# use turple to set more element into one place
print "%s -- %s -- %s" % (42, 3.14159, [1,2,3])
# format by dict
print "%(n)d %(x)s" % {"n":1, "x":"spam"}

s = 'hello a hello b hello c'
print s.find('hello')           # offsit is 0
print s.replace('hello', 'bye') # bye a bye b bye c

# break string to list
l = list('abcdefg') 
print l                # ['a', 'b', 'c', 'd', 'e', 'f', 'g']
# join list to string
print ''.join(l)       # abcdefg
print '-'.join(l)       # a-b-c-d-e-f-g

# split string
print 'aa bb cc'.split()    # ['aa','bb','cc']
print 'aa,bb,cc'.split(',') # ['aa','bb','cc']
