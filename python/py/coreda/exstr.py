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

