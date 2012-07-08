# coding=utf-8

class c1():
	myname = 'aaa'
	def show(self):
		print 'c1.show()'
	def helloC1(self):
		print 'c1.helloC1()'

class c2():
	def show(self):
		print 'c2.show()'
	def helloC2(self):
		print 'c2.helloC2()'

class c3(c1, c2):               # 超类写在括号中，支持多重继承
	def show(self):
		print 'c3.show()'

print c3.__bases__              # 超类的元组

c1.myname                       # c1.myname is 'aaa'
c3.myname                       # c3.myname is 'aaa'

i1 = c3()                       # i1.myname is 'aaa'
i2 = c3()                       # i2.myname is 'aaa'

i1.myname = 'this is i1'        # i1.myname is 'this is i1'
i2.myname = 'this is i2'        # i2.myname is 'this is i2'
# 对象成员赋值后不影响类成员的值
c1.myname                       # c1.myname still is 'aaa'
c3.myname                       # c3.myname still is 'aaa'

i1.show()                       # 调用重写的方法
i1.helloC1()                    # 调用到父类的方法
i1.helloC2()                    # 调用到父类的方法
