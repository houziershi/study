# coding=utf-8

x = set('spam')
y = set(['h','a','m'])

print x,y   # set(['a', 'p', 's', 'm']) set(['a', 'h', 'm'])
print x & y # set(['a', 'm'])
print x | y # set(['a', 'p', 's', 'h', 'm'])
print x - y # set(['p', 's'])

