# coding=utf-8

l = [None] * 100

print type(l)                   # <type 'list'>
print type(type(l))             # <type 'type'>

print type(l) == type([])       # True
print type(l) == list           # True
print isinstance(l, list)       # True

