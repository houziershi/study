# encode=utf-8

for line in input.readlines():
	process(line)

for line in input:
	pricess(line)

def scanner(file, handler):
	for line in file:
		handler(line)

from myutils import scanner

def firstword(line):
	print line.split()[0]

file = open('data.txt')

scanner(file, firstword)

from cStringIO import StringIO
from myutils import scanner

def firstword(line):
	print line.split()[0]

string = StringIO('one\nTwo xxx\nthree\n')
scanner(string, firstword)


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

