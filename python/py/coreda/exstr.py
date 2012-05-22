# coding=utf-8

s = 'Spam'
print len(s)          # length
print s[0]            # index start from 0
print s[1]            # 
print s[-1]           # first from end
print s[len(s)-1]     # first from end
print s[-2]           # second from end

print s[1:3]
print s[1:]
print s[:3]
print s[:-1]
print s[:]
print s[::2]          # set step
print s[::-1]         # backward

print s + '^_^'       # create new object, s still the same
print s * 3           # create new object, s still the same

print s.find('pa')
print s.replace('pa','^_^')
print s.upper()
print s.isalpha()

line = '   aaa,bbb,ccc,ddd,eee   '
print line.lstrip()
print line.rstrip()
print line.split(',')

print ord('\n')       # show 10, because'\n' binary value is 0x10
