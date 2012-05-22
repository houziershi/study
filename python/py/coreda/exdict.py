# coding=utf-8

d = {'food':'spam', 'quantity':4, 'color':'pink'}
print d.has_key('f')          # False

print d['food']
d['quantity'] += 1
print d['quantity']

# create new dict and add attr
d = {}

d['name'] = 'Bob'
d['job'] = 'Dev'
d['age'] = 25

print d

# nesting
rec = {'name': {'first':'Jade', 'last':'Shan'},
		'job': ['dev','mgr'],
		'age': 25}

print rec['name']['last']     # Shan
print rec['job'][-1]          # mgr

d = {'a':1, 'b':2, 'c':3}

ks = d.keys()                 # ['a','c','b']
ks.sort()                     # sort keys
for key in ks:
	print key, ' => ', d[key]

for key in sorted(d):
	print key, ' => ', d[key]


