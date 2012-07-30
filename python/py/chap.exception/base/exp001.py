# coding=utf-8

class Bad(Exception): pass

def doomed(): raise Bad()

try:
	doomed()
except Bad:
	print 'got Bad'
finally:
	print 'after fetch'

