# coding=utf-8

def containsAny(seq, aSet):
	"""序列中的成员是否属于某集合"""
	for item in seq:
		if item in aSet: return True
	return False

print containsAny('abcde','abc')

import itertools
def containsAny(seq, aSet):
	"""序列中的成员是否属于某集合"""
	for item in itertools.ifilter(aSet.__contains__, seq):
		return True
	return False

print containsAny('abcde','abc')
