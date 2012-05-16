# coding=utf-8

class c1():
	def show(self):
		print 'c1.show()'
	def helloC1(self):
		print 'c1.helloC1()'

class c2():
	def show(self):
		print 'c2.show()'
	def helloC2(self):
		print 'c2.helloC2()'

class c3(c1, c2):               # python支持多重继承
	def show(self):
		print 'c3.show()'

i1 = c3()
i1.show()                       # 调用重写的方法
i1.helloC1()                    # 调用到父类的方法
i1.helloC2()                    # 调用到父类的方法

