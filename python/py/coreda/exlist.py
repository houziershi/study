# coding=utf-8

l = [123, 'spam', 1.23]

print l.append('NI') # None
print l              # [123, 'spam', 1.23, 'NI']
print l.pop(2)       # 1.23
print l              # [123, 'spam', 'NI']

print l.sort()       # Nome
print l              # [123, 'NI', 'spam']

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
