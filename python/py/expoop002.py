# coding=utf-8

class Employee():
	def __init__(self, name):   # __init__ 声明构造函数
		self.name = name
	def showName(self):
		print self.name

morgan = Employee("Morgan")
morgan.showName()
print morgan.showName

morgan.showName = "new name"    # 可以把变量赋值给原来是方法的成员
print morgan.showName
