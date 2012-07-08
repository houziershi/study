# coding=utf-8

class c1():
	count = 0
	def show(self):
		print 'c1.show()'

a = c1()
b = c1()

print a.__class__           # class of instance

c1.count = 10               # c1.count is 10
a.count = 5                 # a.count is 5
b.count = 6                 # b.count is 6

a.show()
b.show()
