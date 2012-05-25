# coding=utf-8

l1 = [1,2,3,4,5]
l2 = l1[:]
l2[0] = 0
print l1          # [1, 2, 3, 4, 5]
print l2          # [0, 2, 3, 4, 5]

dic1 = {'a':1,'b':2,'c':3}
dic2 = dic1.copy()
dic2['a'] = 0
print dic1        # {'a': 1, 'c': 3, 'b': 2}
print dic2        # {'a': 0, 'c': 3, 'b': 2}

import copy

l1 = [1,2,3,4,5]
dic1 = {'a':1,'b':2,'c':l1}
dic2 = copy.copy(dic1)
dic2['a'] = 99
dic2['c'][0] = 99
print dic1         # {'a': 1, 'c': [99, 2, 3, 4, 5], 'b': 2}
print dic2         # {'a': 99, 'c': [99, 2, 3, 4, 5], 'b': 2}

l1 = [1,2,3,4,5]
dic1 = {'a':1,'b':2,'c':l1}
dic2 = copy.deepcopy(dic1)
dic2['a'] = 99
dic2['c'][0] = 99
print dic1         # {'a': 1, 'c': [1, 2, 3, 4, 5], 'b': 2}
print dic2         # {'a': 99, 'c': [99, 2, 3, 4, 5], 'b': 2}

l1 = [1,2,3]
l2 = [1,2,3]
print l1 == l2     # True
print l1 is l2     # False

x = 42
y = 42
print x == y       # True
print x is y       # True

import sys
print sys.getrefcount(1)  # 86
print sys.getrefcount(x)  # 11

l = [4,5,6]
x = l * 4    # new list
y = [l] * 4  # reference l 4 time

print x # [4, 5, 6, 4, 5, 6, 4, 5, 6, 4, 5, 6]
print y # [[4, 5, 6], [4, 5, 6], [4, 5, 6], [4, 5, 6]]

l[1] = 0
print x # [4, 5, 6, 4, 5, 6, 4, 5, 6, 4, 5, 6]
print y # [[4, 0, 6], [4, 0, 6], [4, 0, 6], [4, 0, 6]]


