# coding=utf-8

l = [123, 'spam', 1.23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

l.index(1)

l.append('NI') # [123, 'spam', 1.23, 'NI']
l.extend([5,6,7])
l.insert(1,88)

l.pop(2)       # 1.23 # [123, 'spam', 'NI']
l.remove(2)
del l[1]
del l[1:2]

l[0] = 5
l[3:5] = [66,77,88]

range(4)       # create new list [1,2,3,4]
xrange(0,4)    # xrange(4)

l.sort()
l.reverse()

m = [[1,2,3], 
		[4,5,6], 
		[7,8,9]]

print m[1]    # [4,5,6] print row 2 
print m[1][2] # 6       print row 2, item 3

# show col 3 use list comprehension expression
print [row[1] for row in m]                     # [2,5,8]
print [row[1]+1 for row in m]                   # [3,6,9]
print [row[1] for row in m if row[1] % 2 == 0 ] # [2,8]

print [m[i][i] for i in [0,1,2]]          # [1,5,9]
print [c*2 for c in 'span']               # ['ss','pp','aa','mm']
