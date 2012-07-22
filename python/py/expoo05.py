# coding=utf-8

class CallBack:
	def __init__(self,color):
		self.color = color
	def show(self):
		print 'color: ' + self.color

a = CallBack('red')
b = CallBack('blue')


