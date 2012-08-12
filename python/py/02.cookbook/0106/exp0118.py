# encode=utf-8

import re

def multipleReplace(text, aDict):
	print '|'.join(map(re.escape, aDict))
	rx = re.compile('|'.join(map(re.escape, aDict)))
	print rx
	def one_xlat(match):
		return aDict[match.group(0)]
	return rx.sub(one_xlat, text)

adic = {'aaa':'111','bbb':'222','ccc':'333'}
print multipleReplace('aaa bbb ccc',adic)
