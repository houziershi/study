# coding=utf-8

f = open('data.txt','w')
f.write('hello\n')
f.write('world\n')
f.close()

f = open('data.txt')   # default flag is 'r'
bytes = f.read()
print bytes
print bytes.split()

