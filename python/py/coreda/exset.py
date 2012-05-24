# coding=utf-8

x = set('spam')
y = set(['h','a','m'])

print x,y   # set(['a', 'p', 's', 'm']) set(['a', 'h', 'm'])
print x & y # set(['a', 'm'])
print x | y # set(['a', 'p', 's', 'h', 'm'])
print x - y # set(['p', 's'])

engineers = set(['bob','sue','ann','vic'])
managers  = set(['tom','sue'])

print engineers & managers # set(['sue'])
print engineers - managers # set(['vic', 'bob', 'ann'])
print engineers | managers # set(['vic', 'sue', 'tom', 
                           # 'bob', 'ann'])

