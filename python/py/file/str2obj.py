# coding=utf-8

l = [1,2,3]
d = {'a':1, 'b':2, 'c':3}

out = open('obj.txt','w')
out.write(str(l) + "\n")
out.write(str(d) + "\n")
out.flush()
out.close()

infile = open('obj.txt', 'r')
lines = infile.readlines()
infile.close()

objs = [eval(line) for line in lines]
print objs       # [[1, 2, 3], {'a': 1, 'c': 3, 'b': 2}]


