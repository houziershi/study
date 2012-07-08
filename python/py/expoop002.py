# coding=utf-8

class Employee():
	def __init__(self, name):   # __init__ defing construter
		self.name = name
	def showName(self):
		print self.name

morgan = Employee("Morgan")
morgan.showName()

morgan.showName = "new name"    # set value
morgan.nickName = "Jade"        # create new variable

print Employee.__dict__.keys()  # 大多数基于类的对象的命名空间字典
print morgan.__dict__.keys()    # 大多数基于类的对象的命名空间字典
