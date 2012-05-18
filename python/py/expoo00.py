# coding=utf-8

class C1: pass             # Empty class
                           # as an namespace object

a = C1()
a.name = "morgan"          # a.name is "morgan"

C1.name = "Class C1"       # C1.name is "C1"
b = C1()                   # b.name is "C1"
                           # a.name still is "morgan"

def upperName(self):
	print self.name.upper()

C1.showName = upperName    # add func to class
a.showName()
b.showName()
