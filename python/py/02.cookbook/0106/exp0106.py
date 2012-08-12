# encode=utf-8

list = {'a','b','c','d'}

str = ''
for c in list:
	str = str + c
print str

import operator
print reduce(operator.add, list, '')

print ''.join(list)

print '%s %s %s' % ('a','b','c')
