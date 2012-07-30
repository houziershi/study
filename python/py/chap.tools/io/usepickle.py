# coding=utf-8

import pickle

d = {'a':1, 'b':2, 'c':3}

outfile = open('data.txt','w')
pickle.dump(d,outfile)
outfile.close()

infile = open('data.txt')
obj = pickle.load(infile)

print obj              # {'a': 1, 'c': 3, 'b': 2}

