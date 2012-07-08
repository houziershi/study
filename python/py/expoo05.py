# coding=utf-8

class C1():
	def __init__(self, value):
		self.data = value
	def __add__(self, other):
		return C1(self.data + other)
	def __mul__(self, other):
		return C1(self.data * other)

a = C1(5)
b = C1(10)

print (a + 3).data           # result is 8
print (b * 5).data           # result is 50
