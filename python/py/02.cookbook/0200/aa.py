# encode=utf-8

def scanner(file, handler):
	for line in file:
		handler(line)

class MyStream(object):
	def __init__(self,items):
		self.items = items
	def __iter__(self):
		return iter(self.items)

def firstword(line):
	print line.split()[0]

obj = MyStream('aaa\nbbb\nccc'.split())
scanner(obj, firstword)
