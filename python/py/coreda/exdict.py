# coding=utf-8

d = {'a':1, 'b':2, 'c':3, 'd':4, 'e':5, 'f':6, 'g':7}
d2 = dict.fromkeys(['a','b']) # {'a':None, 'b':None}
d3 = dict(zip(d.keys(),d.values()))
d4 = dict(name='skinner', age=18)

d.copy()

# create new dict and add attr
d = {}
d['name'] = 'Bob'
d['job'] = 'Dev'
d['age'] = 25



d = {'a':1, 'b':2, 'c':3, 'd':4, 'e':5, 'f':6, 'g':7}
d['a']
d['a'] = 33
d['a'] += 1

d2.update(d3)  # update d2's value as d3's same key value

d.pop('a')
del d['c']

len(d)

d.keys()
d.values()
d.items()

'f' in d
d.has_key('f')
d.get('f', 'default')

# nesting
rec = {'name': {'first':'Jade', 'last':'Shan'},
		'job': ['dev','mgr'],
		'age': 25}

print rec['name']['last']     # Shan
print rec['job'][-1]          # mgr

ks = d.keys()                 # ['a','c','b']
ks.sort()                     # sort keys
for key in ks:
	print key, ' => ', d[key]

for key in sorted(d):
	print key, ' => ', d[key]

d = {}
d[99] = 'spam'

mtx = {}
mtx[(2,3,4)] = 88
mtx[(7,8,9)] = 99

print mtx.get((2,3,4),0)
print mtx.get((7,8,9),0)
print mtx.get((0,8,9),0)
