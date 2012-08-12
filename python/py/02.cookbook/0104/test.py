# coding=utf-8

import StringUtils

# print '|'+StringUtils.justCJK('15天免费退换货，满199免运费。',32,'r')  + '|'
# print '|'+StringUtils.justCJK('10天无理由退货，支持货到付款',32,'r')  + '|'
# print '|'+StringUtils.justCJK('',32,'r')  + '|'
# print '|'+StringUtils.justCJK('满600元免运费支持货到付款。',32,'r')  + '|'

import unicodedata

def countStrWidthCJK(str, ambiwidth=2):
	'''计算字符串显示长度，能够处理CJK字符宽度
	ambiwidth: 宽度不定的字符算几个，取值为 1, 2'''
	if ambiwidth == 2:
		doubleWidth = ('W', 'A')
	elif ambiwidth == 1:
		doubleWidth = ('W',)
	else:
		raise ValueError('ambiwidth 取值为 1 或者 2')

	uniStr = str.decode('utf-8')
	count = 0
	for i in uniStr:
		if unicodedata.east_asian_width(i) in doubleWidth:
			count += 2
			continue
		count += 1
	
#	for c in str:
#		if c in doubleWidthCharStr:
#			count +=1
	return count

stt = '15天免费退换货，满199免运费。'
for c in stt:
	print '>'+c+'< ='+str(countStrWidthCJK('a'+c))
