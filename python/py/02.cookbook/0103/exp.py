# coding=utf-8

def isString(obj):
	return isinstance(obj, basestring)

print isString('asdf')
print isString(u'\u2020')
print isString(65535)

def isLikeString(obj):
	try:
		obj + ''
	except:
		return False
	else:
		return True

print isLikeString('asdf')
print isLikeString(555)
